package com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentWorkmanager

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.viewModels
import androidx.work.WorkInfo
import com.seniorjavasky.harry_potter_and_retrofit.App
import com.seniorjavasky.harry_potter_and_retrofit.databinding.FragmentWorkmanagerBinding
import com.seniorjavasky.harry_potter_and_retrofit.presentation.ui.fragmentForum.ForumViewModelFactory
import com.seniorjavasky.harry_potter_and_retrofit.presentation.worker.CasherDataWorker
import javax.inject.Inject

class WorkmanagerFragment : Fragment() {

    @Inject
    lateinit var VMFactory: WorkmanagerViewModelFactory


    private val viewModel: WorkmanagerViewModel by viewModels {
        VMFactory
    }

    private var _binding: FragmentWorkmanagerBinding? = null
    private val binding get() = _binding!!

    override fun onCreate(savedInstanceState: Bundle?) {
        App.INSTANCE.appComponent.injectWorkmanagerFragment(this)
        super.onCreate(savedInstanceState)
    }

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

        viewModel.progressWorkInfoItems.observe(viewLifecycleOwner) { listOfWorkInfo ->
            if (!listOfWorkInfo.isNullOrEmpty()) {

                listOfWorkInfo.forEach { workInfo ->
                    if (workInfo.state == WorkInfo.State.RUNNING) {
                        val progressValue = workInfo.progress.getInt(CasherDataWorker.PROGRESS, 0)
                        binding.progressBar.progress = progressValue

                    }
                    binding.progressBar.isVisible = !workInfo.state.isFinished


                }

            }


        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}