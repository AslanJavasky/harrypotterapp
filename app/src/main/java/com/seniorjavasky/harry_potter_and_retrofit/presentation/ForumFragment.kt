package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.firebase.ui.database.FirebaseRecyclerOptions
import com.google.firebase.ktx.Firebase
import com.google.firebase.storage.ktx.storage
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentForumBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils.DatabaseUtils

class ForumFragment : Fragment() {


    private val viewModel: ForumViewModel by viewModels()

    private var _binding: FragmentForumBinding? = null
    private val binding get() = _binding!!

    private lateinit var adapter: ForumAdapter

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
                viewModel.sendTextToFirebaseDb(
                    text,
                    getDbUtils()
                )
                binding.editText.setText("")
            }
        }

        binding.editText.addTextChangedListener(
            viewModel.TextWatcherForEditText(binding.btnSend)
        )

        setRecyclerView()


    }

    private fun setRecyclerView() {
        adapter = ForumAdapter(getDbUtils().getFirebaseRecyclerOptions())
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
    private fun getDbUtils() = getMainActivity().databaseUtils

}