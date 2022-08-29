package com.souzaemerson.valorantapplication.domain.repository.login

interface LoginRepository {
    suspend fun userLogin(email: String, password: String)
}