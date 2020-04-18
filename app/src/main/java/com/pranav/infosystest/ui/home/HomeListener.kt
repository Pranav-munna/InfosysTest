package com.pranav.infosystest.ui.home

interface HomeListener {
    fun onStarted()
    fun onSuccess()
    fun onFailure(message:String)
}