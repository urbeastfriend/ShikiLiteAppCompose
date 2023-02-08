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

import com.example.shikiliteappcompose.util.RepoCallState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.launchIn

import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeScreenViewModel @Inject constructor(
    private val shikiRepository: ShikiRepository
) : ViewModel() {


    var state by mutableStateOf(HomeScreenState())

    init {
        viewModelScope.launch {
        getHomeScreenContent()
        }
    }

    fun onEvent(event: HomeScreenEvent) {
        when (event) {
            is HomeScreenEvent.Refresh -> {
                viewModelScope.launch {
                getHomeScreenContent(fetchFromRemote = true)
                }
            }
        }
    }

    private suspend fun getHomeScreenContent(
        fetchFromRemote: Boolean = false
    ) = withContext(Dispatchers.IO){


        shikiRepository.getHomeScreenPageContent(fetchFromRemote).collect { result ->
            when (result) {
                is RepoCallState.Success -> {
                    result.data?.let { response ->
                        withContext(Dispatchers.Main){
                        state = state.copy(
                            onGoingsList = response.ongoingsList,
                            recentlyWatchedList = response.recentlyWatchedList
                        )
                        }
                    }

                }
                is RepoCallState.Error -> Unit

                is RepoCallState.Loading -> {
                    withContext(Dispatchers.Main) {
                        state = state.copy(
                            isLoading = result.isLoading
                        )
                    }
                }
            }
        }
    }

}