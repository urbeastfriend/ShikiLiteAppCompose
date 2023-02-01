package com.example.shikiliteappcompose.data.remote.ApiEntities

class Anime : ArrayList<AnimeItem>()


data class AnimeItem(
    val aired_on: String,
    val episodes: Int,
    val episodes_aired: Int,
    val id: Int,
    val image: Image,
    val kind: String,
    val name: String,
    val released_on: Any,
    val russian: String,
    val score: String,
    val status: String,
    val url: String
)

data class Image(
    val original: String,
    val preview: String,
    val x48: String,
    val x96: String
)

