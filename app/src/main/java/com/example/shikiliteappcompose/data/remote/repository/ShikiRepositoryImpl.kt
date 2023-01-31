package com.example.shikiliteappcompose.data.remote.repository

import com.example.shikiliteappcompose.data.remote.api.ShikiApi
import com.example.shikiliteappcompose.domain.repository.ShikiRepository
import javax.inject.Inject

class ShikiRepositoryImpl @Inject constructor(
    private val api: ShikiApi
) : ShikiRepository{

}