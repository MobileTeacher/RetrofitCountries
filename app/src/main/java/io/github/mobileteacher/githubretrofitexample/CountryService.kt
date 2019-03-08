package io.github.mobileteacher.githubretrofitexample

import io.github.mobileteacher.githubretrofitexample.model.Country

class CountryService {

    fun searchCountries(searchTerm: String, fullText:Boolean,
                        actionSuccess: (list:List<Country>?)->Unit,
                   actionFailure: (t: Throwable)->Unit){

        val call = RetrofitProvider.countriesAPI.searchCountries(searchTerm, fullText)
        call.executar(actionSuccess, actionFailure)
    }

    fun getAllCountries(actionSuccess: (list:List<Country>?)->Unit,
                        actionFailure: (t: Throwable)->Unit) {
        val call = RetrofitProvider.countriesAPI.getAllCountries()
        call.executar(actionSuccess, actionFailure)
    }
}