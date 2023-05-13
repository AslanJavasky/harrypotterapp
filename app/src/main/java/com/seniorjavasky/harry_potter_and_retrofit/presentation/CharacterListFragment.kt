package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentCharacterListBinding
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class CharacterListFragment : Fragment() {

    private val viewModel: CharacterListViewModel by viewModels {
        CharacterListViewModelFactory()
    }

    private var _binding: FragmentCharacterListBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCharacterListBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

        val rcAdapter = CharacterListAdapter()
        binding.rvCharacterList.adapter = rcAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characterList.collect {
                rcAdapter.submitList(it)
            }
        }
        binding.swipeRefreshLayout.setOnRefreshListener {
            viewModel.refresh()
        }

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.isLoading.collect{
                binding.swipeRefreshLayout.isRefreshing=it
            }
        }

    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}