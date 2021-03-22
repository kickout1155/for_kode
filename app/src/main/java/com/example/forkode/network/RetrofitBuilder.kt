package com.example.forkode.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitBuilder {
    private const val BASE_URL_WEATHER = "https://api.openweathermap.org"
    private const val BASE_URL_CITY = "https://api.openweathermap.org"


    private fun getRetrofitWeather(): Retrofit {

        val client = OkHttpClient().newBuilder()
        client.interceptors().add(InterceptorAuth())



        return Retrofit.Builder()
            .baseUrl(BASE_URL_WEATHER)
            .client(client.build())
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    private fun getRetrofitCity(): Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL_CITY)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }


    val weatherApi: WeatherApi = getRetrofitWeather().create(WeatherApi::class.java)
    val cityApi: CityApi = getRetrofitCity().create(CityApi::class.java)

}

class InterceptorAuth : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {

        val original = chain.request()
        val urlResponse = chain.request().url()

        val request = original.newBuilder()
            .url(
                urlResponse.newBuilder()
                    .addQueryParameter("appid", "48ad64290be9d19a266b0f8154a22a26")
                    .addQueryParameter("units", "metric")
                    .build()
            )
            .build()
        return chain.proceed(request)

    }
}

