package com.example.vehiclehealthmonitor

class LoginViewModel : ViewModel() {
    val username = MutableLiveData<String>()
    val password = MutableLiveData<String>()
    val errorMessage = MutableLiveData<String>()

    fun login() {
        if (username.value.isNullOrEmpty() || password.value.isNullOrEmpty()) {
            errorMessage.value = "Username or Password cannot be empty"
        } else {
            // Implement login logic
        }
    }

    fun register() {
        // Implement registration logic
    }
}