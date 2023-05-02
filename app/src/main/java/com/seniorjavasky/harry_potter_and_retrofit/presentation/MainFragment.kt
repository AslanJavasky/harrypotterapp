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

        binding.viewModel = viewModel
        binding.lifecycleOwner = viewLifecycleOwner

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}