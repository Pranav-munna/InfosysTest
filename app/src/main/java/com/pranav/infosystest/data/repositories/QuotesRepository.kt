package com.pranav.infosystest.data.repositories

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranav.infosystest.data.db.AppDatabase
import com.pranav.infosystest.data.db.entities.Quote
import com.pranav.infosystest.data.db.preferences.PreferenceProvider
import com.pranav.infosystest.data.network.MyApi
import com.pranav.infosystest.data.network.SafeApiRequest
import com.pranav.infosystest.ui.home.ActivityHome
import com.pranav.infosystest.ui.home.quotes.QuotesListener
import com.pranav.infosystest.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.lang.Exception

val MINIMUM_INTERVAL = 1
val CHECK_NETWORK = "check your network connection"

class QuotesRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val prefs: PreferenceProvider
) : SafeApiRequest() {
    private val quotes = MutableLiveData<List<Quote>>()
    var quotesListener: QuotesListener? = null

    init {
        quotes.observeForever {
            saveQuotes(it)
        }
    }

    suspend fun getQuotes(): LiveData<List<Quote>> {
        return withContext(Dispatchers.IO) {
            fetchQuotes()
            db.getQuoteDao().getQuotes()
        }
    }

    private suspend fun fetchQuotes() {
        Log.e("api 1 ", "1")

        val lastSavedAt = prefs.getlastSavedAt()
        if (lastSavedAt == null || isfetchNeeded(lastSavedAt)) {
            Log.e("api 2 ", "2")
            try {
                val response = apiRequest { api.getQuotes() }
                quotes.postValue(response.rows)
            }catch (e:Exception){
                Log.e("api exception","Check your network state")
                quotesListener?.onFailure(CHECK_NETWORK)
            }

        }
    }

    private fun isfetchNeeded(lastSavedAt: String): Boolean {
        val time = (System.currentTimeMillis() - lastSavedAt.toLong()) / 1000F / 60F / 60F
        Log.e("api 3 ", time.toString())
        return time.toInt() > MINIMUM_INTERVAL
    }

    private fun saveQuotes(quotes: List<Quote>) {
        val tsLong = System.currentTimeMillis()
        val ts = tsLong.toString()
        Coroutines.io {
            prefs.saveLastSavedAt(ts)
            db.getQuoteDao().deleteTable()
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}