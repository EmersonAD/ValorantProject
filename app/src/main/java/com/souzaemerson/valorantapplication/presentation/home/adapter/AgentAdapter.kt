package com.souzaemerson.valorantapplication.presentation.home.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.souzaemerson.valorantapplication.data.model.valorant.AgentData
import com.souzaemerson.valorantapplication.databinding.AgentBannerBinding

class AgentAdapter(private val agents: List<AgentData>) :
    RecyclerView.Adapter<AgentAdapter.MyViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = AgentBannerBinding.inflate(view, parent, false)
        return MyViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val agents = agents[position]
        holder.bindView(agents)
    }

    override fun getItemCount(): Int = agents.count()

    inner class MyViewHolder(private val binding: AgentBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(agent: AgentData) {
            binding.run {
                if (agent.isPlayableCharacter) {
                    txtAgentTitle.text = agent.displayName
                    imgAgentBackground.load(agent.background)
                    imgAgent.load(agent.fullPortrait)
                }
            }
        }

    }
}