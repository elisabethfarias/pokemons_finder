package br.com.pokemonsfinder.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import br.com.pokemonsfinder.databinding.ActivityMainBinding
import br.com.pokemonsfinder.remote.PokemonService
import br.com.pokemonsfinder.remote.repository.PokemonRepository
import br.com.pokemonsfinder.viewmodel.PokemonViewModel
import br.com.pokemonsfinder.viewmodel.PokemonViewModelFactory


class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding

    lateinit var viewModel: PokemonViewModel

    private val pokemonService = PokemonService.getInstance()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        viewModel =
            ViewModelProvider(this, PokemonViewModelFactory(PokemonRepository(pokemonService)))
                .get(PokemonViewModel::class.java)

        viewModel.getLisPokemons()
        setRecyclearView()
    }


    fun setRecyclearView() {
        val recyclearView = binding.rvPokemons
        recyclearView.layoutManager = LinearLayoutManager(this)
        viewModel.pokemonList.observe(this, Observer {
            recyclearView.adapter = PokemonAdapter(it.results)
        })
    }

}