package com.example.bangundit.ui.search

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentSearch1Binding

class Search1Fragment : Fragment() {

    private var _binding: FragmentSearch1Binding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSearch1Binding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Existing listener for the "Semua" tab
        binding.tabSemua.setOnClickListener {
            findNavController().navigate(R.id.action_search1_to_search2)
        }

        // NEW LISTENER for the search bar
        binding.searchBarContainer.setOnClickListener {
            // Use the new action ID to navigate to Search4Fragment
            findNavController().navigate(R.id.action_search1_to_search4)
        }

        binding.tabPerkakas.setOnClickListener {
            findNavController().navigate(R.id.action_search1_to_search3)
        }

        binding.tabMaterial.setOnClickListener {
            findNavController().navigate(R.id.action_search1_to_search5)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}