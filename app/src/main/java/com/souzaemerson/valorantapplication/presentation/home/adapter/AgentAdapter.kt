package com.souzaemerson.valorantapplication.presentation.home.adapter

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.souzaemerson.valorantapplication.R
import com.souzaemerson.valorantapplication.data.model.Data
import com.souzaemerson.valorantapplication.databinding.AgentBannerBinding
import com.souzaemerson.valorantapplication.domain.mapper.AgentDomain
import org.xmlpull.v1.XmlPullParser

class AgentAdapter(private val agents: List<Data>) :
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

        fun bindView(agent: Data) {
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