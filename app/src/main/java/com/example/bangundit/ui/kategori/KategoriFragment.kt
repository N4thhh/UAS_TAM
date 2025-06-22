package com.example.bangundit.ui.kategori

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentKategoriBinding

class KategoriFragment : Fragment() {
    private var _binding: FragmentKategoriBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentKategoriBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Akses view menggunakan binding
        binding.cardProduct1.setOnClickListener {
            findNavController().navigate(R.id.action_kategoriFragment_to_detailFragment)
        }
        binding.cardProduct2.setOnClickListener {
            findNavController().navigate(R.id.action_kategoriFragment_to_detailFragment)
        }
        binding.cardProduct3.setOnClickListener {
            findNavController().navigate(R.id.action_kategoriFragment_to_detailFragment)
        }
        binding.cardProduct4.setOnClickListener {
            findNavController().navigate(R.id.action_kategoriFragment_to_detailFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}