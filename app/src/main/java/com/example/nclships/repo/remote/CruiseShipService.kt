package com.example.nclships.repo.remote

import com.example.nclships.model.CruiseShip
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path

interface CruiseShipService {
    @GET("/cms-service/cruise-ships/{cruiseShip}")
    suspend fun getCruiseShip(@Path("cruiseShip") cruiseShip: String) : Response<CruiseShip>
}