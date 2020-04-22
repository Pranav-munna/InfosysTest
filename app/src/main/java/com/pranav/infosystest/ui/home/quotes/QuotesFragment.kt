package com.pranav.infosystest.ui.home.quotes

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout
import com.pranav.infosystest.R
import com.pranav.infosystest.data.db.entities.Quote
import com.pranav.infosystest.data.db.preferences.PreferenceProvider
import com.pranav.infosystest.ui.home.ActivityHome
import com.pranav.infosystest.util.Coroutines
import kotlinx.android.synthetic.main.quotes_fragment.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.x.kodein
import org.kodein.di.generic.instance

class QuotesFragment : Fragment(), KodeinAware ,QuotesListener{

    override val kodein by kodein()
    private val factory: QuotesViewModelFactory by instance()
    private lateinit var viewModel: QuotesViewModel
    private lateinit var swipe: SwipeRefreshLayout
    private lateinit var prefs: PreferenceProvider


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val mView = inflater.inflate(R.layout.quotes_fragment, container, false)
        swipe = mView.findViewById(R.id.swipe)
        prefs=PreferenceProvider(activity!!)
        swipe.setOnRefreshListener {
            prefs.clear()
            (activity as ActivityHome?)!!.reloadData()
            swipe.isRefreshing = false
        }

        return mView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, factory).get(QuotesViewModel::class.java)
        bindUI()
    }

    private fun bindUI() = Coroutines.main {
            viewModel.quotes
            viewModel.quotes.await().observe(viewLifecycleOwner, Observer { quotes ->
                recyclerview.also {
                    it.layoutManager = LinearLayoutManager(requireContext())
                    it.setHasFixedSize(true)
                    it.adapter = QuotesAdapter(quotes)
                }

            })

    }

    override fun onFailure(message: String) {
        Toast.makeText(activity,message, Toast.LENGTH_SHORT).show()
    }
}
