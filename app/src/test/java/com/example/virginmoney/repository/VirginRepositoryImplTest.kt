package com.example.virginmoney.repository

import com.example.virginmoney.api.VirginApi
import com.example.virginmoney.model.PeopleResponse
import com.example.virginmoney.model.RoomResponse
import io.mockk.*
import org.junit.Assert.*
import io.mockk.impl.annotations.MockK

import org.junit.Before
import org.junit.Test
import retrofit2.Response


class VirginRepositoryImplTest {

    @MockK
    lateinit var virginRepositoryImpl: VirginRepositoryImpl
    @MockK
    lateinit var virginApi: VirginApi



    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        virginRepositoryImpl = VirginRepositoryImpl(virginApi)
    }

    @Test
    fun getRooms() {
        val response = mockk<Response<RoomResponse>>(relaxed = true)
        coEvery { virginRepositoryImpl.getRooms() } returns response
    }

    @Test
    fun getPeople() {
        val response = mockk<Response<PeopleResponse>>(relaxed = true)
        coEvery { virginRepositoryImpl.getPeople() } returns response
    }
}