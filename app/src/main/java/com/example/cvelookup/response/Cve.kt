package com.example.cvelookup.response

data class Cve(
    val configurations: List<Configuration>,
    val descriptions: List<Description>,
    val id: String,
    val lastModified: String,
    val metrics: Metrics,
    val published: String,
    val references: List<Reference>,
    val sourceIdentifier: String,
    val vulnStatus: String,
    val weaknesses: List<Weaknesse>
)