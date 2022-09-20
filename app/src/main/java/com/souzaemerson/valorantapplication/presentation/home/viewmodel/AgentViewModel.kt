package com.souzaemerson.valorantapplication.presentation.home.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souzaemerson.valorantapplication.core.State
import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.di.qualifier.dispatcher.Io
import com.souzaemerson.valorantapplication.domain.repository.cache.CacheAgentRepository
import com.souzaemerson.valorantapplication.domain.usecase.agent.GetAgentUseCase
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.firstaccess.FirstAccessCacheUseCase
import com.souzaemerson.valorantapplication.domain.usecase.agent.cache.fromcache.GetAgentFromCacheUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class AgentViewModel @Inject constructor(
    @Io private val ioDispatcher: CoroutineDispatcher,
    private val cacheRepository: CacheAgentRepository,
    private val getAgentRemoteUseCase: GetAgentUseCase,
    private val firstAccessCacheUseCase: FirstAccessCacheUseCase,
    private val getAgentFromCacheUseCase: GetAgentFromCacheUseCase
) : ViewModel() {

    private val _agentRemote = MutableLiveData<State<List<AgentData>>>()
    val agentRemote: LiveData<State<List<AgentData>>> get() = _agentRemote

    private val _agentCache = MutableLiveData<State<List<AgentData>>>()
    val agentCache: LiveData<State<List<AgentData>>> get() = _agentCache

    fun getAgents() {
        if (!cacheRepository.exists()) {
            getAgentsFromRemote()
        } else {
            getAgentsFromCache()
        }
    }

    private fun getAgentsFromRemote() {
        viewModelScope.launch {
            try {
                _agentRemote.value = State.loading(true)
                withContext(ioDispatcher) {
                    getAgentRemoteUseCase()
                }.let { response ->
                    _agentRemote.value = State.loading(false)
                    _agentRemote.value = State.success(response)
                    firstAccessCacheUseCase(response)
                }
            } catch (e: Exception) {
                _agentRemote.value = State.error(e)
                _agentRemote.value = State.loading(false)
            }
        }
    }

    private fun getAgentsFromCache() {
        viewModelScope.launch {
            try {
                _agentCache.value = State.success(getAgentFromCacheUseCase())
            } catch (e: Exception) {
                _agentCache.value = State.error(e)
            }
        }
    }
}