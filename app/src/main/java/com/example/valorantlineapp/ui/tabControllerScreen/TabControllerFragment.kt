package com.example.valorantlineapp.ui.tabControllerScreen

import android.os.Bundle
import android.view.View
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.example.valorantlineapp.base.BaseFragment
import com.example.valorantlineapp.databinding.FragmentTabControllerBinding
import com.google.android.material.tabs.TabLayoutMediator


class TabControllerFragment : BaseFragment<FragmentTabControllerBinding>(FragmentTabControllerBinding::inflate) {

    private val adapter by lazy {
        TabControllerAdapter(childFragmentManager,lifecycle)
    }
    private val fragmentArray = arrayOf("Detail","Ability","Line Up")
    private val args : TabControllerFragmentArgs by navArgs()

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initTabs()
        initBack()
        binding.agentNmTV.text = args.agent.name
    }

    private fun initTabs(){
        args.agent.let { adapter.setArg(it) }
        binding.viewPager.adapter = adapter
        TabLayoutMediator(binding.tabLayout, binding.viewPager) { tab, position ->
            tab.text = fragmentArray[position]
        }.attach()
    }

    private fun initBack(){
        binding.btnBack.setOnClickListener {
           findNavController().navigate(TabControllerFragmentDirections.actionTabControllerFragmentToHomeFragment())
        }
    }
}