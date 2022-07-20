package br.com.pokemonsfinder.remote

import br.com.pokemonsfinder.remote.model.PokemonResponse
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface PokemonService {
 @GET("pokemon")
 fun getListPokemons(): Call<PokemonResponse>

     companion object {

       private val retrofitService: PokemonService by lazy {
            val retrofit = Retrofit.Builder()
                .baseUrl("https://pokeapi.co/api/v2/")
                .addConverterFactory(GsonConverterFactory.create())
                .build()

           retrofit.create(PokemonService::class.java)
       }

       fun getInstance() : PokemonService {
         return retrofitService
       }
    }

}