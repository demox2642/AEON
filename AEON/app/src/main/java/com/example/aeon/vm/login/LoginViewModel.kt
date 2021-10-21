package com.example.aeon.vm.login

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.aeon.data.Pays
import kotlinx.coroutines.launch
import java.lang.Exception

class LoginViewModel : ViewModel() {
    private val repository = LoginRepository()

    private val loadingLiveData = MutableLiveData<Boolean>()
    val loading: LiveData<Boolean>
        get() = loadingLiveData

    private val errorLiveData = MutableLiveData<String>()
    val error: LiveData<String>
        get() = errorLiveData

    private val tokenLiveData = MutableLiveData<String>()
    val token: LiveData<String>
        get() = tokenLiveData

    private val payLiveData = MutableLiveData<List<Pays>>()
    val pays: LiveData<List<Pays>>
        get() = payLiveData

    fun logon(login: String, password: String) {
        viewModelScope.launch {
            try {
                loadingLiveData.postValue(true)
                val loginResponse = repository.logon(login, password)
                if (loginResponse.success == "true") {
                    Log.e("logon", "true ")
                    tokenLiveData.postValue(loginResponse.response!!.token)
                } else {
                    errorLiveData.postValue(loginResponse.error!!.error_msg)
                    Log.e("logon", "false ")
                }
            } catch (t: Exception) {
                Log.e("logon", "Catch $t")
                errorLiveData.postValue(t.message)
            } finally {
                loadingLiveData.postValue(false)
            }
        }
    }

    fun paysList(token: String) {
        Log.e("paysList", "$token")
        viewModelScope.launch {
            try {
                loadingLiveData.postValue(true)
                payLiveData.postValue(repository.paysList(token))
                repository.paysList(token)
            } catch (t: Exception) {
                Log.e("paysList", "$t")
                errorLiveData.postValue(t.message)
            } finally {
                loadingLiveData.postValue(false)
            }
        }
    }
}
