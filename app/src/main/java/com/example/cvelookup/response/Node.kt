package com.example.cvelookup.response

data class Node(
    val cpeMatch: List<CpeMatch>,
    val negate: Boolean,
    val `operator`: String
)