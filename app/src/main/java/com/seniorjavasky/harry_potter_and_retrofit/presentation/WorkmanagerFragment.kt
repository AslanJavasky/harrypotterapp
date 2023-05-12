package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentWorkmanagerBinding

class WorkmanagerFragment : Fragment() {

    private val viewModel: WorkmanagerViewModel by viewModels {
        WorkmanagerViewModelFactory()
    }

    private var _binding: FragmentWorkmanagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWorkmanagerBinding.inflate(inflater, container, false)
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