package com.example.aeon.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class PaysResponse(
    val response: List<Pays>,
    val success: String
)
