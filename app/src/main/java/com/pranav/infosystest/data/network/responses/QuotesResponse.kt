package com.pranav.infosystest.data.network.responses

import com.pranav.infosystest.data.db.entities.Quote

data class QuotesResponse(
    val title: String,
    val rows: List<Quote>
)