package com.souzaemerson.valorantapplication.presentation.login.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souzaemerson.valorantapplication.core.State
import com.souzaemerson.valorantapplication.domain.usecase.login.UserSignInUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel @Inject constructor(
    private val useCaseRepository: UserSignInUseCase
) : ViewModel() {

    private val _signIn = MutableLiveData<State<Boolean>>()
    val signIn: LiveData<State<Boolean>> get() = _signIn

    fun userLogin(email: String, password: String) {
        viewModelScope.launch {
            try {
                _signIn.value = State.loading(true)
                useCaseRepository.userLogin(email, password)
                _signIn.value = State.success(true)
                _signIn.value = State.loading(false)
            } catch (e: Exception) {
                _signIn.value = State.error(e)
            }
        }
    }
}