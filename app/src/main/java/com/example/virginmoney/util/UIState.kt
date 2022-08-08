package com.example.virginmoney.util

import com.example.virginmoney.model.PeopleResponse
import com.example.virginmoney.model.RoomResponse

sealed class UIState{
    object LOADING: UIState()
    data class SUCCESS(val response: RoomResponse): UIState()
    data class SUCCESS2(val response: PeopleResponse): UIState()
    data class ERROR(val error: Exception): UIState()
}