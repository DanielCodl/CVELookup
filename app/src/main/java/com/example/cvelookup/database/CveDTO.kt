package com.example.cvelookup.database

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "cve_table")
data class CveDTO (
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    val cveid: String,
    val published: String,
    val description: String,
    val baseScore: Double,
    val baseSeverity: String,
    val vectorString: String
)