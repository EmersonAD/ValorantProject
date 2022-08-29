package com.souzaemerson.valorantapplication.domain.usecase.login

interface UserSignInUseCase {
    suspend fun userLogin(email: String, password: String)
}