package com.example.shikiliteappcompose.presentation.screens.home

import android.util.Log
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import com.example.shikiliteappcompose.domain.use_case.GetOnGoingsUseCase
import com.example.shikiliteappcompose.util.RepoCallState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn

import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val getOnGoingsUseCase: GetOnGoingsUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(HomeScreenState())
    val state: State<HomeScreenState> = _state

    init {
        Log.d("urls", "called getOnGoings")
        getOngoings()
    }


    private fun getOngoings() {
        getOnGoingsUseCase().onEach { result ->
            when (result) {
                is RepoCallState.Success -> {
                    result.data?.let { onGoings ->
                        Log.d("urls", "ongoings size = ${onGoings.size}" )
                        _state.value = HomeScreenState(
                            onGoingsList = onGoings,
                            isLoading = false
                        )
                    }

                }
                is RepoCallState.Error -> {
                    result.data?.let { onGoings ->
                        _state.value = HomeScreenState(
                            onGoingsList = onGoings,
                            isLoading = false,
                            errorMessageId = result.messageId
                        )
                    }
                }
                is RepoCallState.Loading -> {
                    _state.value = HomeScreenState(
                        isLoading = result.isLoading
                    )
                }
            }
        }.launchIn(viewModelScope)
    }
}