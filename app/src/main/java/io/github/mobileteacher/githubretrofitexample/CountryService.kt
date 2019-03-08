package io.github.mobileteacher.githubretrofitexample

import io.github.mobileteacher.githubretrofitexample.model.Country
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CountryService {

    fun getAllCountries(actionSuccess: (list:List<Country>?)->Unit,
                        actionFailure: (t: Throwable)->Unit) {
        val call = RetrofitProvider.countriesAPI.getAllCountries()
        call.enqueue(object : Callback<List<Country>>{
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                actionFailure(t)
            }

            override fun onResponse(call: Call<List<Country>>, response: Response<List<Country>>) {
                    actionSuccess(response.body())
            }

        })
    }
}