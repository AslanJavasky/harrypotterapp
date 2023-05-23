package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentPaging

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.paging.LoadState
import androidx.recyclerview.widget.LinearLayoutManager
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentPagingBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject
@AndroidEntryPoint
class PagingFragment : Fragment() {

    @Inject
    lateinit var VMFactory: PagingViewModelFactory

    private val viewModel: PagingViewModel by viewModels{
        VMFactory
    }

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
            repeatOnLifecycle(Lifecycle.State.STARTED){
                viewModel.items.collectLatest{
                    rvAdapter.submitData(it)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                rvAdapter.loadStateFlow.collect{
                    binding.appendProgress.isVisible=
                        it.source.append is LoadState.Loading
                    binding.prependProgress.isVisible=
                        it.source.prepend is LoadState.Loading

                }
            }
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }


}