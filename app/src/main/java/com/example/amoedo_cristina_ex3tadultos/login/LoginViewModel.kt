package com.example.amoedo_cristina_ex3tadultos.login

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel

class LoginViewModel : ViewModel() {

    private val userRepository = UserRepository()

    //esta es la variable mutable, solo vamos a poder modificarla desde dentro
    private var _loggedUser: User? by mutableStateOf(null)
    //esta es la variable inmutable que tiene un get que devuelve la de arriba
    //esta es la que vamos a poder modificar desde fuera
    val loggedUser get() = _loggedUser

    private var _logginError by mutableStateOf(false)
    val logginError get() = _logginError


    fun loggin(emailString: String, passwordString: String) {
        _loggedUser = userRepository.authenticateUser(emailString, passwordString)
        _logginError = _loggedUser?.let { false } ?: true
    }

    fun logOut() {
        _loggedUser = null
    }

}