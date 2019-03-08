package io.github.mobileteacher.githubretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.mobileteacher.githubretrofitexample.model.Country
import kotlinx.android.synthetic.main.activity_main.*
import okhttp3.ResponseBody
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        start_button.setOnClickListener {
            getCountriesResponse()
        }
    }

    private fun getCountriesResponse(){
        val countriesAPI = RetrofitProvider.countriesAPI

        val call = countriesAPI.getAllCountries()

        call.enqueue(object : Callback<List<Country>> {
            override fun onFailure(call: Call<List<Country>>, t: Throwable) {
                Toast.makeText(this@MainActivity,
                    "FALHOU A REQUISICAO", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Country>>,
                                    response: Response<List<Country>>) {
                if (response.code() == 200){
                    val countriesList = response.body()
                    val builder = StringBuilder()
                    countriesList?.forEach {
                        builder.appendln("${it.name} | ${it.capital} | ${it.area}")
                    }
                    response_textview.text = builder.toString()
                } else {
                    response_textview.text = response.message()
                }
            }

        })


    }

}
