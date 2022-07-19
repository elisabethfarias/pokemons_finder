package br.com.pokemonsfinder.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import br.com.pokemonsfinder.remote.repository.PokemonRepository
import java.lang.IllegalArgumentException

class PokemonViewModelFactory constructor(private val repository: PokemonRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>) : T {
        return if(modelClass.isAssignableFrom(PokemonViewModel::class.java)) {
            PokemonViewModel(this.repository) as T
       } else {
           throw IllegalArgumentException("ViewModel Not Found")
        }
    }
}