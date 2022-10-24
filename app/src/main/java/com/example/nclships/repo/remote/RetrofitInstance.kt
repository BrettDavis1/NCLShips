package com.example.nclships.repo.remote

import com.example.nclships.util.BASE_URL
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

object RetrofitInstance {
    private val retrofit = Retrofit.Builder()
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val cruiseShipService: CruiseShipService by lazy {
        retrofit.create(CruiseShipService::class.java)
    }
}