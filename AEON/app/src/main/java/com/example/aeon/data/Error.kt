package com.example.aeon.data

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Error(
    val error_code: Int,
    val error_msg: String
)
