package com.example.cvelookup.model

data class Node(
    val cpeMatch: List<CpeMatch>,
    val negate: Boolean,
    val `operator`: String
)