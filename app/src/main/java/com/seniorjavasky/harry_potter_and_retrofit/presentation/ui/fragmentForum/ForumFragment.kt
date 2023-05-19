package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentForumBinding
import com.seniorjavasky.harry_potter_and_retrofit.di.ContextModule
import com.seniorjavasky.harry_potter_and_retrofit.di.DaggerApplicationComponent
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.activities.MainActivity
import javax.inject.Inject

class ForumFragment : Fragment() {

    @Inject
    lateinit var VMFactory:ForumViewModelFactory

    private val viewModel: ForumViewModel by viewModels {
        VMFactory
    }

    private var _binding: FragmentForumBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ForumAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.injectForumFragment(this)
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentForumBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSend.setOnClickListener {
            val text = binding.editText.text.toString().trim()
            if (text.isNotEmpty()) {
                viewModel.sendTextToFirebaseDb(text)
                binding.editText.setText("")
            }
        }

        binding.editText.addTextChangedListener(
            viewModel.TextWatcherForEditText(binding.btnSend)
        )

        setRecyclerView()


    }

    private fun setRecyclerView() {
        adapter = viewModel.getRecyclerAdapter()
        val layoutManager = LinearLayoutManager(getMainActivity())
        layoutManager.stackFromEnd = true
        binding.rvData.layoutManager = layoutManager
        binding.rvData.adapter = adapter

        adapter.registerAdapterDataObserver(
            MyScrollToBottomObserver(binding.rvData, layoutManager, adapter)
        )
    }

    override fun onPause() {
        adapter.stopListening()
        super.onPause()
    }

    override fun onResume() {
        super.onResume()
        adapter.startListening()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun getMainActivity() = (requireActivity() as MainActivity)


}