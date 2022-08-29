package com.souzaemerson.valorantapplication.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souzaemerson.valorantapplication.core.State
import com.souzaemerson.valorantapplication.data.model.valorant.AgentResponse
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    private val repository: AgentRepository,
    private val ioDispatcher: CoroutineDispatcher
) : ViewModel() {

    private val _agentResponse = MutableLiveData<State<AgentResponse>>()
    val agentResponse: LiveData<State<AgentResponse>> get() = _agentResponse

    fun getAgents() {
        viewModelScope.launch {
            try {
                _agentResponse.value = State.loading(true)
                withContext(ioDispatcher) {
                    repository.getAgents()
                }.let { response ->
                    _agentResponse.value = State.loading(false)
                    _agentResponse.value = State.success(response)
                }
            } catch (e: Exception) {
                _agentResponse.value = State.error(e)
                _agentResponse.value = State.loading(false)
            }
        }
    }
}