package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.firebase.ui.database.FirebaseRecyclerAdapter
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.ForumItemBinding
import com.seniorjavasky.harry_potter_and_retrofit.domain.model.ForumItem

class ForumAdapter(
    private val options: FirebaseRecyclerOptions<ForumItem>
) : FirebaseRecyclerAdapter<ForumItem, ForumAdapter.ForumViewHolder>(options) {

    override fun onCreateViewHolder(
        parent: ViewGroup, viewType: Int
    ): ForumViewHolder {
        return ForumViewHolder(
            ForumItemBinding.bind(
                LayoutInflater.from(parent.context).inflate(R.layout.forum_item, parent, false)
            )
        )

    }

    override fun onBindViewHolder(
        holder: ForumViewHolder, position: Int, model: ForumItem
    ) {
        holder.bind(model)
    }


    inner class ForumViewHolder(
        private val binding: ForumItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(forumItem: ForumItem) {
            binding.tvForumMessage.text = forumItem.text
            binding.tvCurrentUser.text = forumItem.user ?: ANONYMOUS
        }
    }

    companion object {
        private const val ANONYMOUS = "Anonymous"
    }
}

