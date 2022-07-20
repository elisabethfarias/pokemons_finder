package br.com.pokemonsfinder.remote.repository

import br.com.pokemonsfinder.remote.PokemonService


class PokemonRepository constructor(private val pokemonApi: PokemonService) {
    fun getListPokemons() = pokemonApi.getListPokemons()

}