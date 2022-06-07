package com.gb.m_1975_3.model

import com.gb.m_1975_3.BuildConfig
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.sql.Date

interface PictureOfTheDayAPI {
    @GET("/planetary/apod")
    fun getPictureOfTheDay(@Query("api_key") apiKey:String): Call<PictureOfTheDayServerResponseData>

    @GET("/planetary/apod")
    fun getPictureOfTheDayTemp(@Query("api_key") apiKey:String,@Query("date") date: String= "2022-06-05"): Call<PictureOfTheDayServerResponseData>
}