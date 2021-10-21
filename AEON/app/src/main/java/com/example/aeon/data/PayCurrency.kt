package com.example.aeon.data

import com.squareup.moshi.Json

enum class PayCurrency {

    @Json(name = "USDT")
    USDT,
    @Json(name = "ETH")
    ETH,
    @Json(name = "BTC")
    BTC,
    @Json(name = "LTC")
    LTC,
    @Json(name = "TRON")
    TRON,
    @Json(name = "XRP")
    XRP,
    @Json(name = "")
    NOT_INDICATED
}
