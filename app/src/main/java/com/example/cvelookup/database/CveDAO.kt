package com.example.cvelookup.database

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface CveDao {

    @Query("select * from cve_table order by published DESC")
    fun readAllData():LiveData<List<CveDTO>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun addCve(cve: CveDTO)
}

