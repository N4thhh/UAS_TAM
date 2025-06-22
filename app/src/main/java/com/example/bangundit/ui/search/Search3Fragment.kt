package com.example.bangundit.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentSearch3Binding // Import View Binding

class Search3Fragment : Fragment() {

    private var _binding: FragmentSearch3Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearch3Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.tabPerkakas.setOnClickListener {
            findNavController().navigate(R.id.action_search3_to_search1)
        }

        binding.tabMaterial.setOnClickListener {
            findNavController().navigate(R.id.action_search3_to_search5)
        }

        binding.tabSemua.setOnClickListener {
            findNavController().navigate(R.id.action_search3_to_search2)
        }

        binding.searchBarContainer.setOnClickListener {
            findNavController().navigate(R.id.action_search3_to_search4)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}