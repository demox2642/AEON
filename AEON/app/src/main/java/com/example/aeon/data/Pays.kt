package com.example.aeon.data
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.*

@JsonClass(generateAdapter = true)
data class Pays(
    val amount: Double,
    val created: Date?,
    @Json(name = "currency")
    val currency: PayCurrency?,
    val desc: String

)
