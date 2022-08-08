package com.example.virginmoney.api

import com.example.virginmoney.model.PeopleResponse
import com.example.virginmoney.model.RoomResponse
import retrofit2.Response
import retrofit2.http.GET

interface VirginApi {
    @GET("rooms")
    suspend fun getRooms():Response<RoomResponse>

    @GET("people")
    suspend fun getPeople(): Response<PeopleResponse>

    companion object{
        const val BASE_URL ="https://61d6afbe35f71e0017c2e74b.mockapi.io/api/v1/"
    }
}