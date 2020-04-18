package com.pranav.infosystest.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProviders
import com.pranav.infosystest.R
import com.pranav.infosystest.databinding.ActivityHomeBinding
import com.pranav.infosystest.util.toast

class ActivityHome : AppCompatActivity(), HomeListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityHomeBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_home)
        val viewModel = ViewModelProviders.of(this).get(HomeViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.homeListener

    }

    override fun onStarted() {
        toast("0k")

    }

    override fun onSuccess() {
        toast("0k2")

    }

    override fun onFailure(message: String) {
        toast("0k3")

    }
}
