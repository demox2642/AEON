package com.example.aeon.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class TokenResponse(
    val error: Error?,
    val response: ResponseToken?,
    val success: String
)
