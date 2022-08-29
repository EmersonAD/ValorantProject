package com.souzaemerson.valorantapplication.data.repository.login

import com.souzaemerson.valorantapplication.data.auth.Authentication
import com.souzaemerson.valorantapplication.domain.repository.login.LoginRepository
import javax.inject.Inject

class LoginRepositoryImpl @Inject constructor(private val auth: Authentication) : LoginRepository {
    override suspend fun userLogin(email: String, password: String) {
        auth.signIn(email, password)
    }
}