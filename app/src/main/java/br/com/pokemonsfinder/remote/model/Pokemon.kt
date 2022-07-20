package br.com.pokemonsfinder.remote.model


data class Pokemon(
    val number: Int,
    val name: String,
) {
    val formattedNumber = number.toString().padStart(3, '0')

    val imageUrl = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/$formattedNumber.png"

}