package com.souzaemerson.valorantapplication.domain.usecase.login

import com.souzaemerson.valorantapplication.domain.repository.login.LoginRepository
import javax.inject.Inject

class LoginUseCaseRepositoryImpl @Inject constructor
    (private val repository: LoginRepository) : LoginUseCaseRepository {

    override suspend fun userLogin(email: String, password: String) {
        if (email.isNotEmpty() && password.isNotEmpty()) {
            repository.userLogin(email, password)
        }
    }
}