package com.pranav.infosystest.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.pranav.infosystest.data.repositories.QuotesRepository
import com.pranav.infosystest.util.lazyDeferred

class QuotesViewModel(repository: QuotesRepository) : ViewModel() {
    var quotesListener: QuotesListener? = null
    val quotes by lazyDeferred { repository.getQuotes() }


     fun onFailureMessage(message: String) {
        quotesListener?.onFailure(message)
    }

}

