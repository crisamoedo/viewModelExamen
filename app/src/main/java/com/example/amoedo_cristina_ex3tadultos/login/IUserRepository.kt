package com.example.amoedo_cristina_ex3tadultos.login

interface IUserRepository {

    fun authenticateUser(email: String, password: String): User?
}