package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.*
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import coil.load
import com.google.firebase.crashlytics.FirebaseCrashlytics
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentMainBinding
import kotlinx.coroutines.launch

private const val TAG = "MainFragment555"

class MainFragment : Fragment() {

    private val viewModel: MainViewModel by viewModels {
        MainViewModelFactory()
    }


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
                with(binding) {
                    tvName.text = it.name
                    tvHouse.text = it.hogwartsHouse
                    imageCharacter.load(it.imageUrl)
                }
            }
        }
        viewLifecycleOwner.lifecycleScope.launch {
            viewModel.state.collect {
                binding.progressBar.isVisible = it is ProgressState.Loading
            }
        }

        binding.btnRandomCharacter.setOnClickListener {
            viewModel.randomCharacter()

//            FirebaseCrashlytics.getInstance().log("This log method with extra info")
//            try {
//                throw Exception("My first exception")
//            } catch (e: Exception) {
//                FirebaseCrashlytics.getInstance().recordException(e)
//            }
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}