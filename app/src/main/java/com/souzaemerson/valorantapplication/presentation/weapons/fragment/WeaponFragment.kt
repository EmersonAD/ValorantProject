package com.souzaemerson.valorantapplication.presentation.weapons.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearSnapHelper
import com.souzaemerson.valorantapplication.core.Status
import com.souzaemerson.valorantapplication.databinding.FragmentWeaponBinding
import com.souzaemerson.valorantapplication.domain.mapper.WeaponDomain
import com.souzaemerson.valorantapplication.presentation.weapons.adapter.WeaponParentAdapter
import com.souzaemerson.valorantapplication.presentation.weapons.viewmodel.WeaponViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class WeaponFragment : Fragment() {

    private lateinit var binding: FragmentWeaponBinding
    private lateinit var mAdapter: WeaponParentAdapter
    private val viewModel by viewModels<WeaponViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentWeaponBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        observeVMEvents()
        getWeapons()
    }

    private fun getWeapons() {
        viewModel.getWeapons()
    }

    private fun observeVMEvents() {
        viewModel.getWeapons.observe(viewLifecycleOwner) {
            when (it.status) {
                Status.SUCCESS -> {
                    it.data?.let { weaponDomains ->
                        setRecycler(weaponDomains)
                    }
                }
                Status.LOADING -> {}
                Status.ERROR -> {}
            }
        }
    }

    private fun setAdapter(weapons: List<WeaponDomain>) {
        mAdapter = WeaponParentAdapter(weapons)
    }

    private fun setRecycler(weapons: List<WeaponDomain>) {
        setAdapter(weapons)
        binding.recyclerParentWeapons.apply {
            adapter = mAdapter
        }
    }
}