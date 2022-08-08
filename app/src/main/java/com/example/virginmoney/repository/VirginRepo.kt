package com.example.virginmoney.repository

import com.example.virginmoney.api.VirginApi
import com.example.virginmoney.model.PeopleResponse
import com.example.virginmoney.model.RoomResponse
import retrofit2.Response
import javax.inject.Inject

interface VirginRepo {
    suspend fun getRooms():Response<RoomResponse>
    suspend fun getPeople():Response<PeopleResponse>
}

class VirginRepositoryImpl @Inject constructor(
    private val virginApi: VirginApi
): VirginRepo{
    override suspend fun getRooms(): Response<RoomResponse> {
        return virginApi.getRooms()
    }

    override suspend fun getPeople(): Response<PeopleResponse> {
        return virginApi.getPeople()
    }

}