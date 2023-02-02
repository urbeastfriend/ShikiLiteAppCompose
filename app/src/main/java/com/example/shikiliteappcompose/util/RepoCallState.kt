package com.example.shikiliteappcompose.util

sealed class RepoCallState<T>(val data: T? = null, val messageId: Int? = null) {
    class Success<T>(data: T) : RepoCallState<T>(data)
    class Error<T>(messageId: Int, data: T? = null) : RepoCallState<T>(data, messageId)
    class Loading<T>(val isLoading: Boolean = true) : RepoCallState<T>(null)
}