package com.example.nclships.model


import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class CruiseShip(
    @Json(name = "shipFacts")
    val shipFacts: ShipFacts,
    @Json(name = "shipName")
    val shipName: String
)