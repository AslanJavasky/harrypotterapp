package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import coil.load
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

private const val TAG = "MainFragment555"

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels()

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMainBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.character.collect {
                binding.tvName.text=it.name
                binding.tvHouse.text=it.hogwartsHouse
                binding.imageCharacter.load(it.imageUrl)
            }
        }

        binding.btnRandomCharacter.setOnClickListener {
            viewModel.randomCharacter()
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    companion object {
        fun newInstance() = MainFragment()
    }
}