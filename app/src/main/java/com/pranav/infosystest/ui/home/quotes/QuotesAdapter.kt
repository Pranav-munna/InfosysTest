package com.pranav.infosystest.ui.home.quotes

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.pranav.infosystest.R
import com.pranav.infosystest.data.db.entities.Quote
import com.pranav.infosystest.databinding.ItemQuotesBinding

class QuotesAdapter(

    private val Quotes: List<Quote>
) : RecyclerView.Adapter<QuotesAdapter.QuotesViewHolder>() {


    override fun getItemCount() = Quotes.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        QuotesViewHolder(
            DataBindingUtil.inflate(
                LayoutInflater.from(parent.context),
                R.layout.item_quotes, parent, false
            )
        )

    override fun onBindViewHolder(holder: QuotesViewHolder, position: Int) {
        holder.recyclerViewQuotesBinding.quote = Quotes[position]
    }

    inner class QuotesViewHolder(
        val recyclerViewQuotesBinding: ItemQuotesBinding
    ) : RecyclerView.ViewHolder(recyclerViewQuotesBinding.root) {

    }


}