package br.com.timedomatheus.repository

import br.com.timedomatheus.entities.Msg
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


interface Repository {
    @GET("produtos")
    suspend fun getAllProdutosRepo(): Msg
}

val rf = Retrofit.Builder()
    .baseUrl("https://promoios.com.br/api/")
    .addConverterFactory(GsonConverterFactory.create())
    .build()

val repository: Repository = rf.create(Repository::class.java)
