package com.pranav.infosystest.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.pranav.infosystest.R
import com.pranav.infosystest.ui.home.quotes.QuotesFragment
import kotlinx.android.synthetic.main.activity_home.*

class ActivityHome : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        supportFragmentManager.beginTransaction()
            .add(R.id.drawer_layout, QuotesFragment(), "Profilefragment")
            .commit()
        setSupportActionBar(toolbar)
    }
}
