package br.com.pokemonsfinder.remote

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonService {
    private lateinit var service: PokemonApi

    fun getInstance() : Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            service = retrofit.create(PokemonApi::class.java)

        return retrofit
    }

}