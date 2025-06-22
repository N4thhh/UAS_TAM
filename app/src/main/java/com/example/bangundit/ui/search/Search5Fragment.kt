package com.example.bangundit.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentSearch5Binding

class Search5Fragment : Fragment() {

    private var _binding: FragmentSearch5Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearch5Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tabMaterial.setOnClickListener {
            findNavController().navigate(R.id.action_search5_to_search1)
        }

        binding.tabSemua.setOnClickListener {
            findNavController().navigate(R.id.action_search5_to_search2)
        }

        binding.tabPerkakas.setOnClickListener {
            findNavController().navigate(R.id.action_search5_to_search3)
        }

        binding.searchBarContainer.setOnClickListener {
            findNavController().navigate(R.id.action_search5_to_search4)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}