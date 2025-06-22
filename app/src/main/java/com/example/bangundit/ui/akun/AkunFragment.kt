package com.example.bangundit.ui.akun

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentAkunBinding // Import the View Binding class

class AkunFragment : Fragment() {

    private var _binding: FragmentAkunBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentAkunBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.favorit.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_FavoriteFragment)
        }
        binding.editProfil.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_editprofil)
        }
        binding.ulasanSaya.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_ulasan_saya)
        }
        binding.pusatBantuan.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_pusat_bantuan)
        }
        binding.tentangAplikasi.setOnClickListener {
            findNavController().navigate(R.id.action_akunFragment_to_tentang_aplikasi)
        }

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}