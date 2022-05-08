package com.itheamc.koinditutorial.viewmodel

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.itheamc.koinditutorial.repository.MainRepository
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class MainViewModel(
    private val mainRepository: MainRepository
): ViewModel() {

//    private val _res = MutableStateFlow("")
//    val res : StateFlow<String> = _res

    private val _res = MutableSharedFlow<String>(replay = 0)
    val res : SharedFlow<String> = _res

    fun fetchPosts() {
        viewModelScope.launch {
            var i = 0
            while (i < 10) {
                i++
                _res.emit("$i")
                delay(1000)
            }
            val s = mainRepository.fetchPosts()
            _res.emit(s)
        }
    }
}