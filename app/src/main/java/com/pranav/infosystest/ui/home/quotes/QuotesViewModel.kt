package com.pranav.infosystest.ui.home.quotes

import androidx.lifecycle.ViewModel
import com.pranav.infosystest.data.repositories.QuotesRepository
import com.pranav.infosystest.util.lazyDeferred

class QuotesViewModel(repository: QuotesRepository) : ViewModel() {
    val quotes by lazyDeferred { repository.getQuotes() }
}

