package io.github.mobileteacher.githubretrofitexample.model

import com.google.gson.annotations.SerializedName

class Country(var name:String,
              var capital: String,
              var area: Double,
              var latlng: List<Float>,
              var languages: List<Language>)

class Language(var name: String,
               @SerializedName("iso639_1") var code: String)