package com.pranav.infosystest.ui.home

import android.view.View
import androidx.lifecycle.ViewModel

class HomeViewModel: ViewModel() {


    var homeListener :HomeListener?= null

    fun onButnClick(view:View){
        homeListener?.onStarted()
//        homeListener?.onSuccess()
    }

}