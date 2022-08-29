package com.souzaemerson.valorantapplication.domain.usecase.login

interface LoginUseCaseRepository {
    suspend fun userLogin(email: String, password: String)
}