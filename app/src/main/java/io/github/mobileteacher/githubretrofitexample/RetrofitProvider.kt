package io.github.mobileteacher.githubretrofitexample

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitProvider {

    private val retrofitInstance =
        Retrofit.Builder()
            .baseUrl("https://restcountries.eu/rest/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

    val countriesAPI:ContriesAPI = retrofitInstance.create(ContriesAPI::class.java)



}