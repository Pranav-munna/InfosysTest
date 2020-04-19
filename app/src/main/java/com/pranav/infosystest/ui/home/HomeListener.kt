package com.pranav.infosystest.ui.home

import androidx.lifecycle.LiveData
import com.pranav.infosystest.data.db.entities.News

interface HomeListener {
    fun onStarted()
    fun onSuccess(news: News)
    fun onFailure(message:String)
}