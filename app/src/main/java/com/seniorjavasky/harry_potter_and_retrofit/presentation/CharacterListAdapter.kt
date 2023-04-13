package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.CharacterItemBinding
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel

class CharacterListAdapter
    : ListAdapter<CharacterModel, CharacterListViewHolder>(callback) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterListViewHolder {

        val binding=
            CharacterItemBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return CharacterListViewHolder(binding)

    }

    override fun onBindViewHolder(
        holder: CharacterListViewHolder, position: Int
    ) {
        val characterItem = getItem(position)
        holder.binding.imageCharacter.load(characterItem.imageUrl)
        holder.binding.tvName.text = characterItem.name
        holder.binding.tvHouse.text = characterItem.hogwartsHouse

    }
}

class CharacterListViewHolder(val binding:CharacterItemBinding) : RecyclerView.ViewHolder(binding.root)

val callback = object : DiffUtil.ItemCallback<CharacterModel>() {
    override fun areItemsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterModel, newItem: CharacterModel): Boolean {
        return oldItem == newItem
    }

}