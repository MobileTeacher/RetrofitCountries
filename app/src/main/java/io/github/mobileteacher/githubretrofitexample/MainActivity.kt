package io.github.mobileteacher.githubretrofitexample

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import io.github.mobileteacher.githubretrofitexample.model.Country
import kotlinx.android.synthetic.main.activity_main.*
import java.lang.StringBuilder

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)



        start_button.setOnClickListener {
            getCountriesResponse()
        }

        search_button.setOnClickListener {
            searchCountries(search_edittext.text.toString())
        }
    }

    private fun getCountriesResponse(){
        CountryService().getAllCountries(countriesSuccess, failureAction)
    }

    private fun searchCountries(countryName: String){
        CountryService().searchCountries(countryName, checkBox.isChecked, countriesSuccess, failureAction)
    }

    private val failureAction: (t: Throwable)->Unit = {
        Toast.makeText(this@MainActivity,
            "FALHOU com ${it.message}", Toast.LENGTH_SHORT).show()
    }

    private val countriesSuccess:(list: List<Country>?)->Unit = {list->
        val builder = StringBuilder()

        list?.let {list->
            list.forEach {
                builder.appendln("${it.name} | ${it.capital} | ${it.area}" +
                        "${it.latlng} | ${it.languages[0].name} ${it.languages[0].code}")
            }
            response_textview.text = builder.toString()
        } ?: run {
            Toast.makeText(this@MainActivity, "Lista nula", Toast.LENGTH_SHORT).show()
        }
    }
}
