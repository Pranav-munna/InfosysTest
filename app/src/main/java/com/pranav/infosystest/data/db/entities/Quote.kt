package com.pranav.infosystest.data.db.entities

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val description: String?,
    val imageHref: String?
)