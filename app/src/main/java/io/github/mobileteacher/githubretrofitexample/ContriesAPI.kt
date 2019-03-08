package io.github.mobileteacher.githubretrofitexample

import io.github.mobileteacher.githubretrofitexample.model.Country
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.http.GET



interface ContriesAPI {

    @GET("all")
    fun getAllCountriesRaw(): Call<ResponseBody>

    @GET("all")
    fun getAllCountries(): Call<List<Country>>

}