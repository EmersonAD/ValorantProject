package com.souzaemerson.valorantapplication.presentation.home.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.souzaemerson.valorantapplication.core.Status
import com.souzaemerson.valorantapplication.data.model.valorant.Data
import com.souzaemerson.valorantapplication.domain.repository.agent.AgentRepository
import com.souzaemerson.valorantapplication.data.repository.agent.AgentRepositoryImpl
import com.souzaemerson.valorantapplication.databinding.FragmentHomeBinding
import com.souzaemerson.valorantapplication.di.module.RetrofitModule
import com.souzaemerson.valorantapplication.presentation.home.adapter.AgentAdapter
import com.souzaemerson.valorantapplication.presentation.home.viewmodel.AgentViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: AgentAdapter
    private lateinit var viewModel: AgentViewModel
    private lateinit var repository: AgentRepository

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
        repository = AgentRepositoryImpl(RetrofitModule.initRetrofit())
        viewModel = AgentViewModel(repository, Dispatchers.IO)

        observeVMEvents()
        getAgents()
    }

    private fun getAgents() {
        viewModel.getAgents()
    }

    private fun observeVMEvents() {
        viewModel.agentResponse.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { agentResponse ->
                        setRecycler(agentResponse.data)
                    }
                }
                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }
    }

    private fun setAdapter(agentsList: List<Data>) {
        mAdapter = AgentAdapter(agentsList)
    }

    private fun setRecycler(agentsList: List<Data>) {
        setAdapter(agentsList)
        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}