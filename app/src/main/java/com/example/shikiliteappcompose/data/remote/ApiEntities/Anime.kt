package com.example.shikiliteappcompose.data.remote.ApiEntities


data class Anime(
    val aired_on: String,
    val episodes: Int,
    val episodes_aired: Int,
    val id: Int,
    val image: Images,
    val kind: String,
    val name: String,
    val released_on: Any,
    val russian: String,
    val score: String,
    val status: String,
    val url: String
)

data class Images(
    val original: String,
    val preview: String,
    val x48: String,
    val x96: String
)

