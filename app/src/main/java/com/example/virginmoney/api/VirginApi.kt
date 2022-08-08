package com.example.virginmoney.api

import com.example.virginmoney.model.PeopleResponse
import com.example.virginmoney.model.RoomResponse
import retrofit2.Response
import retrofit2.http.GET

interface VirginApi {
    @GET("photos")
    suspend fun getRooms():Response<RoomResponse>

    @GET("users")
    suspend fun getPeople(): Response<PeopleResponse>

    companion object{
        const val BASE_URL ="https://jsonplaceholder.typicode.com/"
    }
}