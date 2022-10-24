package com.example.nclships.repo

import com.example.nclships.model.CruiseShip
import com.example.nclships.repo.remote.RetrofitInstance
import retrofit2.Response
import java.lang.Exception

object CruiseShipRepository {

    suspend fun getCruiseShipResponse(ship: String) : Response<CruiseShip>? {
        try {
            return RetrofitInstance.cruiseShipService.getCruiseShip(ship)
        } catch (ex: Exception) {

        }
        return null
    }
}