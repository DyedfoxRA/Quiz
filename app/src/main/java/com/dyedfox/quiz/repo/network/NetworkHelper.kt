package com.dyedfox.quiz.repo.network

import com.dyedfox.quiz.utils.API_LINK
import com.jakewharton.retrofit2.adapter.kotlin.coroutines.CoroutineCallAdapterFactory
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class NetworkHelper {

    lateinit var client: ApiMethods

    constructor() {
        createClient()
    }

    private fun createClient() {

        val retrofit = Retrofit.Builder()
            .baseUrl(API_LINK)
            .addCallAdapterFactory(CoroutineCallAdapterFactory())
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        client = retrofit
            .create(ApiMethods::class.java)


    }
}