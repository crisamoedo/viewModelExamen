package com.example.amoedo_cristina_ex3tadultos.login

class ApiDataSourceMock {

    var validUsersInRemoteServer = mapOf(
        "cris@cris.com" to User("cris@cris.com", "123", "Cris"),
        "lola@lola.com" to User("lola@lola.com", "123", "Lola"),
    )
}