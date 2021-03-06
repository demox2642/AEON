package com.example.aeon.network

import okhttp3.Interceptor
import okhttp3.Response

class CustomSetingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val originalRequest = chain.request()
        val modifiRequest = originalRequest.newBuilder()
            .header("app-key", " 12345")
            .header("v", "1")
            .build()
        return chain.proceed(modifiRequest)
    }
}
