package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentDbBinding
import com.seniorjavasky.harry_potter_and_retrofit.lessons.MyService
import kotlinx.coroutines.launch
import okhttp3.internal.notify

class DbFragment : Fragment() {

    private val viewModel: DbViewModel by viewModels {
        DbViewModelFactory()
    }

    private var _binding: FragmentDbBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDbBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnService.setOnClickListener {
            viewModel.startService()
        }
        binding.btnStop.setOnClickListener {
            viewModel.stopService()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}