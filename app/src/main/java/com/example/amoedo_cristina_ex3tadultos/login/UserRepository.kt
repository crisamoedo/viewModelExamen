package com.example.amoedo_cristina_ex3tadultos.login

class UserRepository() : IUserRepository {

    private val apiDataSource = ApiDataSourceMock()


    override fun authenticateUser(email: String, password: String) =
        apiDataSource.validUsersInRemoteServer[email]?.run {
            if (this.password == password) this else null
        }
}