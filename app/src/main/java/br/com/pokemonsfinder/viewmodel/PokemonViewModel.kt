package br.com.pokemonsfinder.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.com.pokemonsfinder.remote.model.PokemonResponse
import br.com.pokemonsfinder.remote.repository.PokemonRepository
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class PokemonViewModel constructor(private val repository: PokemonRepository) : ViewModel() {

    val pokemonList = MutableLiveData<PokemonResponse>()
    val erroMessage = MutableLiveData<String>()

    fun getLisPokemons() {
        val resquest = repository.getListPokemons()
        resquest.enqueue(object : Callback<PokemonResponse>{
            override fun onResponse(call: Call<PokemonResponse>, response: Response<PokemonResponse>) {
                pokemonList.postValue(response.body())
            }

            override fun onFailure(call: Call<PokemonResponse> , t: Throwable) {
                erroMessage.postValue(t.message)
            }

        })
    }
}