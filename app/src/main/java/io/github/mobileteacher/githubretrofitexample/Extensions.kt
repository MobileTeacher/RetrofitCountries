package io.github.mobileteacher.githubretrofitexample

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

fun<T> Call<T>.executar(actionSuccess: (list:T?)->Unit,
                        actionFailure: (t: Throwable)->Unit){
    enqueue(object : Callback<T> {
        override fun onFailure(call: Call<T>, t: Throwable) {
            actionFailure(t)
        }

        override fun onResponse(call: Call<T>, response: Response<T>) {
            actionSuccess(response.body())
        }

    })
}