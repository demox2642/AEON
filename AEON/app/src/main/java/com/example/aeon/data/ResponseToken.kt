package com.example.aeon.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ResponseToken(
    val token: String
)
