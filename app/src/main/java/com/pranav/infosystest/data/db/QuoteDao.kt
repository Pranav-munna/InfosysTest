package com.pranav.infosystest.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.pranav.infosystest.data.db.entities.Quote

@Dao
interface QuoteDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun saveAllQuotes(quotes: List<Quote>)

    @Query("DELETE FROM Quote")
    fun deleteTable()

    @Query("SELECT * FROM Quote")
    fun getQuotes(): LiveData<List<Quote>>
}