package com.pranav.infosystest.ui.home

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
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

    fun reloadData(){
        var frg: Fragment? = null
        frg = supportFragmentManager.findFragmentByTag("Profilefragment")
        val ft: FragmentTransaction = supportFragmentManager.beginTransaction()
        ft.detach(frg!!)
        ft.add(R.id.drawer_layout, QuotesFragment(), "Profilefragment")
        ft.commit()


    }

}
