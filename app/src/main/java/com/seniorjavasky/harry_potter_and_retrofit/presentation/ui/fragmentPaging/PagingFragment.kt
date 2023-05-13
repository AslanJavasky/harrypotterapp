package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentPagingBinding
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

class PagingFragment : Fragment() {

    private val viewModel: PagingViewModel by viewModels()

    private var _binding: FragmentPagingBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentPagingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rvAdapter=CharacterPagingListAdapter()
        binding.rvPagingCharacters.layoutManager=
            LinearLayoutManager(activity?.applicationContext)
        binding.rvPagingCharacters.adapter=rvAdapter

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.characters.collect{
                rvAdapter.submitList(it)
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}