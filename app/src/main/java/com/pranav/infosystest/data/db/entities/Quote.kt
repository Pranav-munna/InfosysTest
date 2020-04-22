package com.pranav.infosystest.data.db.entities

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy


@Entity
data class Quote(
    @PrimaryKey(autoGenerate = true)
    val id: Int,
    val title: String?,
    val description: String?,
    val imageHref: String?
) {
    fun getNull(): Boolean {
        return title == null && description == null && imageHref == null
    }
}