package com.example.virginmoney.ui.viewmodel

import com.example.virginmoney.repository.VirginRepo
import io.mockk.*
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Job
import org.junit.Assert
import org.junit.Assert.*

import org.junit.Before
import org.junit.Test
import kotlin.coroutines.coroutineContext


class VirginViewModelTest {

    @MockK
    private lateinit var virginViewModel: VirginViewModel
    @MockK
    private lateinit var virginRepo: VirginRepo
    @Before
    fun setUp() {
        MockKAnnotations.init(this)
        virginViewModel = VirginViewModel(virginRepo)

    }

    @Test
    fun getRooms() {
       Assert.assertNotNull(virginViewModel.rooms)
    }

    @Test
    fun getPeople() {
        Assert.assertNotNull(virginViewModel.people)
    }

    @Test
    fun getRoom() {
        Assert.assertNotNull(virginViewModel.getRoom())
    }

    @Test
    fun testGetPeople() {
        Assert.assertNotNull(virginViewModel.getPeople())
    }
}