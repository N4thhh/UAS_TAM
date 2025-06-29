package com.example.bangundit.ui.reviewrating

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentReviewAndRatingBinding // Import the View Binding class

class reviewAndRatingFragment : Fragment() {

    private var _binding: FragmentReviewAndRatingBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentReviewAndRatingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonWriteReview.setOnClickListener {
            findNavController().navigate(R.id.action_reviewAndRatingFragment_to_tulisulasanFragment)
        }


    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}