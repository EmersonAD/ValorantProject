package com.souzaemerson.valorantapplication.presentation.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.souzaemerson.valorantapplication.core.Status
import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.databinding.FragmentHomeBinding
import com.souzaemerson.valorantapplication.presentation.home.adapter.AgentAdapter
import com.souzaemerson.valorantapplication.presentation.home.viewmodel.AgentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class AgentFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: AgentAdapter
    private val viewModel by viewModels<AgentViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        // Inflate the layout for this fragment
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeVMEvents()
        getAgents()
    }

    private fun getAgents() {
        viewModel.getAgents()
    }

    private fun observeVMEvents() {
        viewModel.agentRemote.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { agentsRemote ->
                        setRecycler(agentsRemote)
                    }
                }
                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }

        viewModel.agentCache.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { agentsInCache ->
                        setRecycler(agentsInCache)
                    }
                }
                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }
    }

    private fun setAdapter(agentsList: List<AgentData>) {
        mAdapter = AgentAdapter(agentsList)
    }

    private fun setRecycler(agentsList: List<AgentData>) {
        setAdapter(agentsList)
        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}