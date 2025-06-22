package com.example.bangundit.ui.home

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentHomeBinding

class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Define the navigation action once.
        val navigateToDetailAction = View.OnClickListener {
            findNavController().navigate(R.id.action_homeFragment_to_detailFragment)
        }

        // Apply the same click action to every product card.
        binding.cardSemenTigaRoda.setOnClickListener(navigateToDetailAction)
        binding.cardBataMerah.setOnClickListener(navigateToDetailAction)
        binding.cardPipaPvc.setOnClickListener(navigateToDetailAction)
        binding.cardSeng.setOnClickListener(navigateToDetailAction)
        binding.cardCatTembok.setOnClickListener(navigateToDetailAction)
        binding.cardKeramik.setOnClickListener(navigateToDetailAction)
        binding.cardKayuBalok.setOnClickListener(navigateToDetailAction)
        binding.cardPakuBeton.setOnClickListener(navigateToDetailAction)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}