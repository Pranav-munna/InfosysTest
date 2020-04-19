package com.pranav.infosystest.data.db.entities

import androidx.room.Entity

const val TITLE = ""

@Entity
class News (
    var title: String? = null,
    var description: String? = null,
    var imageHref: String? = null

){
    var newsTitle: String = TITLE
}