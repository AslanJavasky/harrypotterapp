package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterModel

class CharacterListAdapter
    : RecyclerView.Adapter<CharacterListAdapter.CharacterListViewHolder>() {

    val list = mutableListOf<CharacterModel>()

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterListViewHolder {

        val itemView=
            LayoutInflater
                .from(parent.context)
                .inflate(R.layout.character_item,parent,false)
        return CharacterListViewHolder(itemView)

    }
    override fun onBindViewHolder(
        holder: CharacterListViewHolder, position: Int
    ) {
        val characterItem=list[position]
        holder.imageView.load(characterItem.imageUrl)
        holder.tvName.text=characterItem.name
        holder.tvHouse.text=characterItem.hogwartsHouse

    }
    override fun getItemCount(): Int = list.size

    class CharacterListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<ImageView>(R.id.image_character)
        val tvName=itemView.findViewById<TextView>(R.id.tvName)
        val tvHouse=itemView.findViewById<TextView>(R.id.tvHouse)
    }


}