package com.example.wavesoffood

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentMenuBottomSheetBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class MenuBottomSheetFragment : BottomSheetDialogFragment() {

    private lateinit var binding: FragmentMenuBottomSheetBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMenuBottomSheetBinding.inflate(inflater, container, false)

        binding.buttonBack.setOnClickListener {
            dismiss()
        }

        val menuFoodName = listOf("Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza")
        val menuItemprice = listOf("$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3")
        val menuImage = listOf(R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1)
        val adapter = MenuAdapter(ArrayList(menuFoodName), ArrayList(menuItemprice), ArrayList(menuImage))
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        return binding.root
    }

    companion object {

    }
}