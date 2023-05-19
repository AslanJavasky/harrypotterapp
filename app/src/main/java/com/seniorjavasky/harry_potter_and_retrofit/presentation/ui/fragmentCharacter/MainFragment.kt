package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentCharacter

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.*
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentMainBinding
import com.seniorjavasky.harry_potter_and_retrofit.di.ContextModule
import com.seniorjavasky.harry_potter_and_retrofit.di.DaggerApplicationComponent
import javax.inject.Inject

private const val TAG = "MainFragment555"

class MainFragment : Fragment() {

    @Inject
    lateinit var VMfactory:MainViewModelFactory

    private val viewModel: MainViewModel by viewModels {
        VMfactory
    }

    private var _binding: FragmentMainBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.injectMainFragment(this)
        super.onCreate(savedInstanceState)
    }

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