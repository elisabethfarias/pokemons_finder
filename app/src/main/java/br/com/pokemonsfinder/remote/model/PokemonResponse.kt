package br.com.pokemonsfinder.remote.model

data class PokemonResponse (
    val count: Int,
    val next: String?,
    val previous: String?,
    val results: List<PokemonListResponse>
)

data class PokemonListResponse(
    val name: String,
    val url: String
)
