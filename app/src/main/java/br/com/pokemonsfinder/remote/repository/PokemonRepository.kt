package br.com.pokemonsfinder.remote.repository

import br.com.pokemonsfinder.remote.PokemonApi
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class PokemonRepository constructor(private val pokemonApi: PokemonApi) {
    fun getListPokemons() = pokemonApi.getListPokemons()

    companion object {
        private var service: PokemonApi? = null

        fun getInstance() : Retrofit {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

            service = retrofit.create(PokemonApi::class.java)

            return retrofit
        }
    }
}