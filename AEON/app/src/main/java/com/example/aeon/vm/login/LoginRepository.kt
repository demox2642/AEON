package com.example.aeon.vm.login

import com.example.aeon.data.Pays
import com.example.aeon.data.TokenResponse
import com.example.aeon.network.NetworkRetrofit

class LoginRepository {
    suspend fun logon(login: String, password: String): TokenResponse {
        return NetworkRetrofit.aeonLoginApi.logon(login, password)
    }

    suspend fun paysList(token: String): List<Pays> {
        return NetworkRetrofit.aeonLoginApi.testPay(token).response
    }
}
