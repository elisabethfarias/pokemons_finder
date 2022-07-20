package br.com.pokemonsfinder.remote

import br.com.pokemonsfinder.remote.model.PokemonApiResult
import br.com.pokemonsfinder.remote.model.PokemonsApiResult
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface PokemonService {
 @GET("pokemon")
 fun getListPokemons(): Call<PokemonsApiResult>

    @GET("pokemon/{number}")
    fun getPokemon(@Path("number") number: Int): Call<PokemonApiResult>

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