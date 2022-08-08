package com.example.virginmoney.ui.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.virginmoney.repository.VirginRepo
import com.example.virginmoney.util.UIState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject
import kotlin.Exception

@HiltViewModel
class VirginViewModel @Inject constructor(private val virginRepo: VirginRepo): ViewModel() {

    private val _room: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val rooms: LiveData<UIState> get() = _room

    private val _people: MutableLiveData<UIState> = MutableLiveData(UIState.LOADING)
    val people: LiveData<UIState> get() = _people

    fun getRoom() {
        CoroutineScope(Dispatchers.IO).launch {
            try {
                val response = virginRepo.getRooms()
                if(response.isSuccessful){
                    response.body()?.let {
                        _room.postValue(UIState.SUCCESS(it))
                    } ?: throw Exception("Data null")
                } else {
                    throw Exception(response.errorBody().toString())
                }
            }catch (e: Exception){
                withContext(Dispatchers.Main){
                    _room.postValue(UIState.ERROR(e))
                }
            }
        }
    }
    fun getPeople(){
        CoroutineScope(Dispatchers.IO).launch {
            val response = virginRepo.getPeople()
            if(response.isSuccessful){
                response.body()?.let {
                    _people.postValue(UIState.SUCCESS2(it))
                } ?: throw java.lang.Exception("Data Null")
            } else {
                throw java.lang.Exception(response.errorBody()?.string())
            }

        }
    }

    override fun onCleared() {
        super.onCleared()
    }
}