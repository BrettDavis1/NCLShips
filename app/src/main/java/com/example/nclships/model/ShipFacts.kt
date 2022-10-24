package com.example.nclships.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ShipFacts(
    @Json(name = "crew")
    val crew: String,
    @Json(name = "inauguralDate")
    val inauguralDate: String,
    @Json(name = "passengerCapacity")
    val passengerCapacity: String
)