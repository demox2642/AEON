package com.example.aeon.network

import com.example.aeon.data.PaysResponse
import com.example.aeon.data.TokenResponse
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Query

interface AeonLoginApi {

    @FormUrlEncoded
    @POST("login")
    suspend fun logon(
        @Field("login") login: String,
        @Field("password") password: String
    ): TokenResponse

    @GET("payments")
    suspend fun testPay(@Query("token") token: String): PaysResponse
}
