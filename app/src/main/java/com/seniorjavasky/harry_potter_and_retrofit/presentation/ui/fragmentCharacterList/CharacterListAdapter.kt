package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacterList

import android.view.ViewGroup
import androidx.compose.ui.platform.ComposeView
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.CharacterItem

class CharacterListAdapter
    : ListAdapter<CharacterItem, CharacterListViewHolder>(callback) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): CharacterListViewHolder {

        val composeView = ComposeView(parent.context)
        return CharacterListViewHolder(composeView)
    }

    override fun onBindViewHolder(
        holder: CharacterListViewHolder, position: Int
    ) {
        val characterItem = getItem(position)
        holder.bind(characterItem)
    }
}

class CharacterListViewHolder(
    private val composeView: ComposeView
) : RecyclerView.ViewHolder(composeView) {

    fun bind(characterItem: CharacterItem) {
        composeView.setContent {
            CharacterItemCompose(character=characterItem)
        }

    }
}

val callback = object : DiffUtil.ItemCallback<CharacterItem>() {
    override fun areItemsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: CharacterItem, newItem: CharacterItem): Boolean {
        return oldItem == newItem
    }

}