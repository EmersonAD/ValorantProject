package com.souzaemerson.valorantapplication.presentation.weapons.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.souzaemerson.valorantapplication.data.model.weapon.Skin
import com.souzaemerson.valorantapplication.databinding.WeaponItemBinding

class WeaponChildAdapter(private val weapons: List<Skin>) :
    RecyclerView.Adapter<WeaponChildAdapter.MyWeaponViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyWeaponViewHolder {
        val view = LayoutInflater.from(parent.context)
        val binding = WeaponItemBinding.inflate(view, parent, false)
        return MyWeaponViewHolder(binding)
    }

    override fun onBindViewHolder(holder: MyWeaponViewHolder, position: Int) {
        val weapons = weapons[position]
        holder.bind(weapons)
    }

    override fun getItemCount(): Int = weapons.count()

    inner class MyWeaponViewHolder(private val binding: WeaponItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(weapon: Skin) {
            binding.run {
                imgWeaponItem.load(weapon.displayIcon)
                txtWeaponName.text = weapon.displayName
            }
        }
    }
}