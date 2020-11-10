package com.example.data.di

import com.example.data.api.Endpoint
import com.example.data.api.service.RepoService
import com.example.data.utils.LiveDataCallAdapterFactory
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

@JvmField
val networkModel = module {
    single<Retrofit> {
        Retrofit.Builder()
            .baseUrl(Endpoint.BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(LiveDataCallAdapterFactory())
            .build()
    }
    single { get<Retrofit>().create(RepoService::class.java) }
}