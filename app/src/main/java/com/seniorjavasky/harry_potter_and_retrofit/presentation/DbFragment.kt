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
import kotlinx.coroutines.launch

class DbFragment : Fragment() {

    val dbVMFactory by lazy{
        object:ViewModelProvider.Factory{
            override fun <T : ViewModel> create(modelClass: Class<T>): T {
                if (modelClass.isAssignableFrom(DbViewModel::class.java)){
                    return DbViewModel(requireActivity().application) as T
                }
                throw RuntimeException("Unknown class name")
            }
        }
    }

    private val viewModel: DbViewModel by viewModels{
        dbVMFactory
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

        binding.btnAdd.setOnClickListener { viewModel.onBtnAdd() }
        binding.btnUpdate.setOnClickListener { viewModel.onUpdateBtn()}
        binding.btnDelete.setOnClickListener { viewModel.onDeleteBtn()}



        lifecycleScope.launch {
//            viewModel.characters.collect {
//                binding.textView.text = it.joinToString(separator = "\r\n")
//            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}