package com.example.shikiliteappcompose.util

import retrofit2.HttpException

sealed class ApiCallState {

    object Success : ApiCallState()
    data class Error(val exception: HttpException) : ApiCallState()
    object Loading : ApiCallState()
}