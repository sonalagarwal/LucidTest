package com.example.myapplication

import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn

class LucidPhotosRepository {
    private val apiService = retrofit.create(LucidApi::class.java)

    suspend fun getPhotos(): Flow<List<Photos>> = flow {
        emit(apiService.getPhotos())
    }.flowOn(IO)

}