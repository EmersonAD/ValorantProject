package com.souzaemerson.valorantapplication.presentation.weapons.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.recyclerview.widget.RecyclerView
import com.souzaemerson.valorantapplication.databinding.WeaponBannerBinding
import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain

class WeaponParentAdapter(private val weapons: List<WeaponDomain>) :
    RecyclerView.Adapter<WeaponParentAdapter.MyWeaponParentViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWeaponParentViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = WeaponBannerBinding.inflate(view, parent, false)
        return MyWeaponParentViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyWeaponParentViewHolder, position: Int) {
        val weapons = weapons[position]
        holder.bindView(weapons)
    }

    override fun getItemCount(): Int = weapons.count()

    inner class MyWeaponParentViewHolder(private val binding: WeaponBannerBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bindView(weapon: WeaponDomain) {
            binding.run {
                val pagerSnapHelper = PagerSnapHelper()
                val weaponChildAdapter = WeaponChildAdapter(weapon.skins)

                recyclerChild.adapter = weaponChildAdapter
                recyclerChild.onFlingListener = null

                pagerSnapHelper.attachToRecyclerView(recyclerChild)
            }
        }
    }
}