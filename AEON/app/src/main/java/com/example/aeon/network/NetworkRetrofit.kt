package com.example.aeon.network

import com.squareup.moshi.Moshi
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.create

object NetworkRetrofit {

    private val okHttpClient = OkHttpClient.Builder()
        .addInterceptor(CustomSetingInterceptor())
        .addNetworkInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        )
        .build()

    private val moshiBuilder = Moshi.Builder()
        .add(CustomDateAdapter())

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://82.202.204.94/api-test/")
        .addConverterFactory(MoshiConverterFactory.create(moshiBuilder.build()))
        .client(okHttpClient)
        .build()

    val aeonLoginApi: AeonLoginApi
        get() = retrofit.create()
}
