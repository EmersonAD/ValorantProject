package com.souzaemerson.valorantapplication.presentation.weapons.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.souzaemerson.valorantapplication.core.State
import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain
import com.souzaemerson.valorantapplication.domain.usecase.weapon.GetWeaponsUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WeaponViewModel @Inject constructor(
    private val getWeaponsUseCase: GetWeaponsUseCase,
) : ViewModel() {

    private val _getWeapons = MutableLiveData<State<List<WeaponDomain>>>()
    val getWeapons: LiveData<State<List<WeaponDomain>>> get() = _getWeapons

    fun getWeapons() {
        viewModelScope.launch {
            try {
                _getWeapons.value = State.loading(true)
                getWeaponsUseCase.getWeapons().let { weapons ->
                    _getWeapons.value = State.success(weapons)
                    _getWeapons.value = State.loading(false)
                }
            } catch (e: Exception) {
                _getWeapons.value = State.error(e)
                _getWeapons.value = State.loading(false)
            }
        }
    }
}