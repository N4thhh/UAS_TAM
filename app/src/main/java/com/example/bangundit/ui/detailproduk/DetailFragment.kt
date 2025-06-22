package com.example.bangundit.ui.detailproduk

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentDetailBinding // Import View Binding class

class DetailFragment : Fragment() {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentDetailBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.layoutViewAllReviews.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_reviewAndRatingFragment)
        }
        binding.profiltoko.setOnClickListener {
            findNavController().navigate(R.id.action_detailFragment_to_informasiTokoFragment)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}