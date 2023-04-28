package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MyScrollToBottomObserver(
    private val recyclerView: RecyclerView,
    private val manager: LinearLayoutManager,
    private val adapter: ForumAdapter
) : RecyclerView.AdapterDataObserver() {

    override fun onItemRangeInserted(positionStart: Int, itemCount: Int) {
        super.onItemRangeInserted(positionStart, itemCount)

        val count = adapter.itemCount
        val lastVisiblePosition =
            manager.findLastCompletelyVisibleItemPosition()
        val loading = lastVisiblePosition == -1
        val atBottom = positionStart >= count - 1
                && lastVisiblePosition == positionStart - 1

        if (loading || atBottom) {
            recyclerView.scrollToPosition(positionStart)
        }
    }

}