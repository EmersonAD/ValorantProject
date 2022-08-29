package com.souzaemerson.valorantapplication.presentation.login.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.souzaemerson.valorantapplication.core.Status
import com.souzaemerson.valorantapplication.data.auth.Authentication
import com.souzaemerson.valorantapplication.domain.repository.login.LoginRepository
import com.souzaemerson.valorantapplication.data.repository.login.LoginRepositoryImpl
import com.souzaemerson.valorantapplication.databinding.ActivityLoginBinding
import com.souzaemerson.valorantapplication.di.module.FirebaseModule
import com.souzaemerson.valorantapplication.domain.usecase.login.LoginUseCaseRepository
import com.souzaemerson.valorantapplication.domain.usecase.login.LoginUseCaseRepositoryImpl
import com.souzaemerson.valorantapplication.presentation.login.viewmodel.LoginViewModel
import kotlinx.coroutines.Dispatchers.IO

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding
    private lateinit var useCaseRepository: LoginUseCaseRepository
    private lateinit var repository: LoginRepository
    private lateinit var viewModel: LoginViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        repository = LoginRepositoryImpl(Authentication(FirebaseModule.initAuth()))
        useCaseRepository = LoginUseCaseRepositoryImpl(repository)
        viewModel = LoginViewModel(useCaseRepository, IO)

        observeVMEvents()
        signIn()
    }

    private fun signIn() {
        binding.run {
            imgButtonConnect.setOnClickListener {
                val userEmail = tiUsernameEdit.text.toString()
                val userPassword = tiPasswordEdit.text.toString()

                viewModel.userLogin(email = userEmail, password = userPassword)
            }
        }
    }

    private fun observeVMEvents() {
        viewModel.signIn.observe(this) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { signIn ->
                        if (signIn) "" else ""
                    }
                }
                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }
    }
}