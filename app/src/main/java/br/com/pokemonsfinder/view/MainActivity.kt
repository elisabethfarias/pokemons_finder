package br.com.pokemonsfinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pokemonsfinder.databinding.ActivityMainBinding
import br.com.pokemonsfinder.remote.PokemonApi
import br.com.pokemonsfinder.remote.PokemonService
import br.com.pokemonsfinder.remote.model.PokemonListResponse
import br.com.pokemonsfinder.remote.repository.PokemonRepository
import br.com.pokemonsfinder.viewmodel.PokemonViewModel
import br.com.pokemonsfinder.viewmodel.PokemonViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    val pokemonService = PokemonService

    private val viewModel by lazy {
        ViewModelProvider(this, PokemonViewModelFactory())
            .get(PokemonViewModel::class.java)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel.getLisPokemons()

        viewModel.pokemonList.observe(this) {
            loadRecyclerView(it)
        }

    }

    private fun loadRecyclerView(pokemons : List<PokemonListResponse>) {
        binding.rvPokemons.layoutManager = LinearLayoutManager(this)
        binding.rvPokemons.adapter = PokemonAdapter(pokemons)
    }
}