package br.com.pokemonsfinder.remote.repository

import br.com.pokemonsfinder.remote.PokemonApi
import br.com.pokemonsfinder.remote.PokemonService

class PokemonRepository constructor(private val pokemonApi: PokemonApi) {
    fun getListPokemons() = pokemonApi.getListPokemons()
}