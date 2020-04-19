package com.pranav.infosystest.data.repositories

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.pranav.infosystest.data.db.AppDatabase
import com.pranav.infosystest.data.db.entities.Quote
import com.pranav.infosystest.data.db.preferences.PreferenceProvider
import com.pranav.infosystest.data.network.MyApi
import com.pranav.infosystest.data.network.SafeApiRequest
import com.pranav.infosystest.util.Coroutines
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

val MINIMUM_INTERVAL = 1

class QuotesRepository(
    private val api: MyApi,
    private val db: AppDatabase,
    private val prefs: PreferenceProvider
) : SafeApiRequest() {
    private val quotes = MutableLiveData<List<Quote>>()


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
        val lastSavedAt = prefs.getlastSavedAt()
        if (lastSavedAt == null || isfetchNeeded(lastSavedAt)) {
            val response = apiRequest { api.getQuotes() }
            quotes.postValue(response.rows)
        }
    }

    private fun isfetchNeeded(lastSavedAt: String): Boolean {
        val time = (System.currentTimeMillis() - lastSavedAt.toLong()) / 1000F / 60F / 60F
        return time.toInt() < MINIMUM_INTERVAL
    }

    private fun saveQuotes(quotes: List<Quote>) {
        val tsLong = System.currentTimeMillis()
        val ts = tsLong.toString()
        Coroutines.io {
            prefs.saveLastSavedAt(ts)
            db.getQuoteDao().saveAllQuotes(quotes)
        }
    }
}