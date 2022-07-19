package br.com.pokemonsfinder.model

data class PokemonEntity (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonResult>
)

data class PokemonResult (
    val name: String,
    val url: String
)
