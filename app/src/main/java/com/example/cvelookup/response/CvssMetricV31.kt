package com.example.cvelookup.response

data class CvssMetricV31(
    val cvssData: CvssDataX,
    val exploitabilityScore: Double,
    val impactScore: Double,
    val source: String,
    val type: String
)