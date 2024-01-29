package com.example.cvelookup.response

data class CpeMatch(
    val criteria: String,
    val matchCriteriaId: String,
    val versionEndIncluding: String,
    val vulnerable: Boolean
)