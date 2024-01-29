package com.example.cvelookup.model

data class CpeMatch(
    val criteria: String,
    val matchCriteriaId: String,
    val versionEndIncluding: String,
    val vulnerable: Boolean
)