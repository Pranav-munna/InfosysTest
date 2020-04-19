package com.pranav.infosystest.ui.home

import android.util.Log
import android.view.View
import androidx.lifecycle.ViewModel
import com.pranav.infosystest.data.repositories.NewsRepository
import com.pranav.infosystest.util.Coroutines

class HomeViewModel : ViewModel() {


    var homeListener: HomeListener? = null

    fun onButnClick(view: View) {
        Log.e("test here", "ok")
        homeListener?.onStarted()
//        homeListener?.onFailure("poe")

        Coroutines.main {
            val response = NewsRepository().news()
            if (response.isSuccessful) {
                homeListener?.onSuccess(response.body()?.news!!)
            }
        }
    }

}