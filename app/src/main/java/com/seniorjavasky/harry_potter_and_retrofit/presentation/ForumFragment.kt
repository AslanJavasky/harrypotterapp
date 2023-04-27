package com.seniorjavasky.harry_potter_and_retrofit.presentation

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.seniorjavasky.harry_potter_and_retrofit.R
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentForumBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.firebaseUtils.DatabaseUtils

class ForumFragment : Fragment() {


    private val viewModel: ForumViewModel by viewModels()

    private var _binding: FragmentForumBinding? = null
    private val binding get() = _binding!!


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
            val text=binding.editText.text.toString().trim()
            if (text.isNotEmpty()){
                viewModel.sendTextToFirebaseDb(
                    text,
                    (requireActivity() as MainActivity).databaseUtils
                )
                binding.editText.setText("")
            }
        }

        binding.editText.addTextChangedListener(object :TextWatcher{

            override fun onTextChanged(
                text: CharSequence?, start: Int, before: Int, count: Int
            ) {
                if (text?.trim()!!.isNotEmpty()){
                    binding.btnSend.isEnabled=true
                    binding.btnSend.setImageResource(R.drawable.send_blue)
                }else{
                    binding.btnSend.isEnabled=false
                    binding.btnSend.setImageResource(R.drawable.send_gray)
                }


            }
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun afterTextChanged(s: Editable?) {}
        })

        binding.tvData.setOnClickListener {
            viewModel.retreiveDataFromDb(
                binding.tvData,
                (requireActivity() as MainActivity).databaseUtils)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}