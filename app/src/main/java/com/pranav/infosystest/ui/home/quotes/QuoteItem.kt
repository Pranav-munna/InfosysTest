package com.pranav.infosystest.ui.home.quotes

import com.pranav.infosystest.R
import com.pranav.infosystest.data.db.entities.Quote
import com.pranav.infosystest.databinding.ItemQuotesBinding
import com.xwray.groupie.databinding.BindableItem

class QuoteItem(
    private val quote: Quote
) : BindableItem<ItemQuotesBinding>() {
    override fun getLayout() = R.layout.item_quotes

    override fun bind(viewBinding: ItemQuotesBinding, position: Int) {
        viewBinding.setQuote(quote)
    }
}