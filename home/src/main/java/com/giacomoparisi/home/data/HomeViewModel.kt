package com.giacomoparisi.home.data

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.giacomoparisi.data.error.ErrorMapper
import com.giacomoparisi.data.error.toError
import com.giacomoparisi.domain.datatype.LazyData
import com.giacomoparisi.domain.ext.Action
import com.giacomoparisi.domain.ext.action
import com.giacomoparisi.domain.ext.launchAction
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.sync.Mutex
import kotlinx.coroutines.sync.withLock
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val mutex: Mutex,
    private val errorMapper: ErrorMapper
) : ViewModel() {

    /* --- state --- */

    private val mutableStateFlow = MutableStateFlow(HomeState())
    val stateFlow = mutableStateFlow.asStateFlow()

    private suspend fun emit(update: suspend (HomeState) -> HomeState) {
        mutex.withLock { mutableStateFlow.emit(update(mutableStateFlow.value)) }
    }

    /* --- init --- */

    init {
        dispatch(HomeAction.GetWeatherDays)
    }

    /* --- weather --- */

    private fun getWeatherDays(): Action =
        action(
            {
                emit { it.copy(weatherDays = LazyData.Loading()) }
            },
            { throwable ->
                emit { it.copy(weatherDays = throwable.toError(errorMapper)) }
            }
        )

    /* --- action --- */

    fun dispatch(action: HomeAction) {
        when (action) {
            HomeAction.GetWeatherDays -> viewModelScope.launchAction(getWeatherDays())
        }
    }

}