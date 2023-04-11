package com.seniorjavasky.harry_potter_and_retrofit.presentation

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentCharacterListBinding

class CharacterListFragment : Fragment() {

    private val viewModel: CharacterListViewModel by viewModels()

    private var _binding: FragmentCharacterListBinding?=null
    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding=FragmentCharacterListBinding.inflate(inflater,container,false)
        return binding.root
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding=null
    }

}