package com.pranav.infosystest.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pranav.infosystest.data.db.entities.News
import com.pranav.infosystest.data.db.entities.TITLE

@Dao
interface NewsDaw {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(news :News): Long

    @Query("SELECT * FROM news WHERE title = $TITLE")
    fun  fetNews(): LiveData<News>
}