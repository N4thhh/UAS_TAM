package com.example.bangundit.ui.favorite

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.bangundit.R
import com.example.bangundit.databinding.FragmentFavoriteBinding
import com.example.bangundit.databinding.FragmentKategoriFavoriteBinding
import com.example.bangundit.databinding.FragmentUrutkanBinding
import com.google.android.material.bottomsheet.BottomSheetDialog

class FavoriteFragment : Fragment() {
    private var _binding: FragmentFavoriteBinding? = null
    private val binding get() = _binding!!
    private var selectedSortOption = "newest" // Opsi default: Terbaru Disimpan
    private var selectedCategoryOption = "material" // Opsi default: Material

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // 2. Inflate layout utama Fragment menggunakan View Binding.
        _binding = FragmentFavoriteBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.sortChip.setOnClickListener { showSortBottomSheet() }
        binding.categoryChip.setOnClickListener { showCategoryBottomSheet() }
    }


    private fun showSortBottomSheet() {
        if (!isAdded) return

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val sheetBinding = FragmentUrutkanBinding.inflate(LayoutInflater.from(requireContext()))
        bottomSheetDialog.setContentView(sheetBinding.root)

        sheetBinding.ivClose.setOnClickListener { bottomSheetDialog.dismiss() }

        when (selectedSortOption) {
            "newest" -> sheetBinding.rbNewestSaved.isChecked = true
            "oldest" -> sheetBinding.rbOldestSaved.isChecked = true
            "most_reviews" -> sheetBinding.rbMostReviews.isChecked = true
        }

        sheetBinding.rgSortOptions.setOnCheckedChangeListener { _, checkedId ->
            selectedSortOption = when (checkedId) {
                R.id.rb_oldest_saved -> "oldest"
                R.id.rb_most_reviews -> "most_reviews"
                else -> "newest"
            }
            applySorting(selectedSortOption)
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }


    private fun showCategoryBottomSheet() {
        if (!isAdded) return

        val bottomSheetDialog = BottomSheetDialog(requireContext())
        val sheetBinding = FragmentKategoriFavoriteBinding.inflate(LayoutInflater.from(requireContext()))
        bottomSheetDialog.setContentView(sheetBinding.root)

        sheetBinding.ivClose.setOnClickListener { bottomSheetDialog.dismiss() }

        when (selectedCategoryOption) {
            "material" -> sheetBinding.rbMaterial.isChecked = true
            "perkakas" -> sheetBinding.rbPerkakas.isChecked = true
        }

        sheetBinding.rgSortOptionsKategori.setOnCheckedChangeListener { _, checkedId ->
            selectedCategoryOption = when (checkedId) {
                R.id.rb_perkakas -> "perkakas"
                else -> "material"
            }
            applyCategoryFilter(selectedCategoryOption)
            bottomSheetDialog.dismiss()
        }

        bottomSheetDialog.show()
    }


    private fun applySorting(sortType: String) {
        val message = "Mengurutkan berdasarkan: $sortType"
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

    private fun applyCategoryFilter(category: String) {
        val message = "Filter berdasarkan kategori: $category"
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
        // TODO: Tambahkan logika untuk memfilter daftar produk Anda di sini.
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}