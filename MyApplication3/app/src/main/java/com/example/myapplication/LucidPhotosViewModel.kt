package com.example.myapplication

import android.annotation.SuppressLint
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import java.lang.Exception

class LucidPhotosViewModel : ViewModel() {

    private val _photos = MutableLiveData<Result<List<Photos>>>()
    val photos: LiveData<Result<List<Photos>>> = _photos

    init {
        getLucidPhotos()
    }

    @SuppressLint("CheckResult")
    private fun getLucidPhotos() = viewModelScope.launch(IO) {
        LucidPhotosRepository().getPhotos().collect {
            try {
                _photos.postValue(Result.Success(it))
            } catch (e: Exception) {
                _photos.postValue(Result.Error(e.message ?: "Something went wrong!"))
            }
        }
    }
}

sealed class Result<out T : Any> {
    object Loading : Result<Nothing>()
    data class Success<out T : Any>(val data: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
}
