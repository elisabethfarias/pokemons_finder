package br.com.pokemonsfinder.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import br.com.pokemonsfinder.databinding.PokemonItemBinding
import br.com.pokemonsfinder.remote.model.PokemonListResponse

import com.bumptech.glide.Glide

class PokemonAdapter(
    private var pokemons: List<PokemonListResponse>,
) : RecyclerView.Adapter<PokemonAdapter.ViewHolder>()  {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = PokemonItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }


    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = pokemons[position]

        holder.bind(item)
    }

    override fun getItemCount() = pokemons.size

    class ViewHolder(var binding: PokemonItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: PokemonListResponse) {
            binding.tvName.text = item.name

            item.let {
                Glide.with(itemView.context).load(formatedUrl(it.url)).into(binding.ivPokemon)
            }
        }

        fun formatedUrl(url: String) : String {
            val numberFormated = url.replace("https://pokeapi.co/api/v2/pokemon/", "")
                .replace("/", "").padStart(3, '0')
            val urlFormated = "https://assets.pokemon.com/assets/cms2/img/pokedex/detail/${numberFormated}.png"
            return urlFormated
        }
    }


}