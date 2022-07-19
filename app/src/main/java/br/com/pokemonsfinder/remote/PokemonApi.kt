package br.com.pokemonsfinder.remote


import br.com.pokemonsfinder.remote.model.PokemonResponse
import retrofit2.Call
import retrofit2.http.GET

interface PokemonApi {
 @GET("pokemon")
 fun getListPokemons(): Call<PokemonResponse>

}