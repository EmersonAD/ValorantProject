package com.souzaemerson.valorantapplication.presentation.home.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.souzaemerson.valorantapplication.R
import com.souzaemerson.valorantapplication.data.model.Data
import com.souzaemerson.valorantapplication.databinding.FragmentHomeBinding
import com.souzaemerson.valorantapplication.presentation.home.adapter.AgentAdapter

class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    private lateinit var mAdapter: AgentAdapter

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
    }

    private fun setAdapter(agentsList: List<Data>){
        mAdapter = AgentAdapter(agentsList)
    }

    private fun setRecycler(agentsList: List<Data>){
        setAdapter(agentsList)
        binding.homeRecycler.apply {
            adapter = mAdapter
            setHasFixedSize(true)
        }
    }
}