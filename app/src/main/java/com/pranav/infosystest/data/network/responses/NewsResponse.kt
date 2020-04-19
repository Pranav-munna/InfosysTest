package com.pranav.infosystest.data.network.responses
import com.pranav.infosystest.data.db.entities.News

data class NewsResponse (
    val title: String? = null,
    val news: News?

)