package com.example.virginmoney.model

data class RoomResponseItem(
    val created_at: String,
    val id: String,
    val is_occupied: Boolean,
    val max_occupancy: Int,
    val name: String
)
