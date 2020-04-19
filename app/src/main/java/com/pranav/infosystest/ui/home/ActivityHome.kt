package com.pranav.infosystest.ui.home

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.pranav.infosystest.R
import com.pranav.infosystest.data.db.entities.News
import com.pranav.infosystest.databinding.ActivityHomeBinding
import com.pranav.infosystest.util.toast

class ActivityHome : AppCompatActivity(), HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.homeListener = this

    }

    override fun onStarted() {
//        toast("0k")

    }

    override fun onSuccess(news: News) {
//        toast("Success")
        /*newsResponse.observe(this, Observer {
            toast(it)
            Log.e("error 1",it)
        })*/

    }

    override fun onFailure(message: String) {
//        toast("0k3")

    }
}
