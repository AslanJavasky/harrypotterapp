package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.CharacterItemBinding
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterPagingItem

class CharacterPagingListAdapter
    : PagingDataAdapter<CharacterPagingItem,
        CharacterPagingListAdapter.CharacterListViewHolder>(callback) {


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
        characterItem?.let { holder.bind(it) }
    }
    inner class CharacterListViewHolder(
        val binding:CharacterItemBinding) : RecyclerView.ViewHolder(binding.root){
            fun bind(characterPagingItem: CharacterPagingItem){
                if(characterPagingItem.imageUrl != null){
                    binding.imageCharacter.load(characterPagingItem.imageUrl)
                }else{
                    binding.imageCharacter.load(R.drawable.empty_face)
                }
                binding.tvName.text = characterPagingItem.name ?: "N/D"
                binding.tvHouse.text = characterPagingItem.hogwartsHouse ?: "N/D"
            }
        }

    companion object {
        val callback = object : DiffUtil.ItemCallback<CharacterPagingItem>() {
            override fun areItemsTheSame(oldItem: CharacterPagingItem, newItem: CharacterPagingItem): Boolean {
                return oldItem.id == newItem.id
            }

            override fun areContentsTheSame(oldItem: CharacterPagingItem, newItem: CharacterPagingItem): Boolean {
                return oldItem == newItem
            }
        }
    }
}


