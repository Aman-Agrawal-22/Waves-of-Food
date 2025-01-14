package com.example.wavesoffood.Fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.widget.SearchView
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.wavesoffood.R
import com.example.wavesoffood.adapter.MenuAdapter
import com.example.wavesoffood.databinding.FragmentSearchBinding

class SearchFragment : Fragment() {
    private lateinit var binding: FragmentSearchBinding
    private lateinit var adapter: MenuAdapter
    private val originalMenuFoodName = listOf("Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza", "Burger", "Sandwich", "momo", "Pizza")
    private val originalMenuFoodPrice = listOf("$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3", "$5", "$4", "$6", "$3")
    private val originalMenuFoodImage = listOf(R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1, R.drawable.menupic, R.drawable.photomenu1, R.drawable.photomenu2, R.drawable.photomenu1)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }
    private val filteredMenuFoodName = mutableListOf<String>()
    private val filteredMenuItemPrice = mutableListOf<String>()
    private val filteredMenuImage = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSearchBinding.inflate(inflater, container, false)
        adapter = MenuAdapter(filteredMenuFoodName, filteredMenuItemPrice, filteredMenuImage, requireContext())
        binding.menuRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        binding.menuRecyclerView.adapter = adapter

        //setup search view
        setupSearchView()

        //show all menu items
        showAllMenu()

        return binding.root
    }

    private fun showAllMenu() {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()
        filteredMenuFoodName.addAll(originalMenuFoodName)
        filteredMenuItemPrice.addAll(originalMenuFoodPrice)
        filteredMenuImage.addAll(originalMenuFoodImage)
        adapter.notifyDataSetChanged()
    }

    private fun setupSearchView() {
        binding.searchView.setOnQueryTextListener(object :android.widget.SearchView.OnQueryTextListener{
            override fun onQueryTextSubmit(query: String?): Boolean {
                filterMenuItems(query)
                return true
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                filterMenuItems(newText)
                return true
            }
        })
    }

    private fun filterMenuItems(query: String?) {
        filteredMenuFoodName.clear()
        filteredMenuItemPrice.clear()
        filteredMenuImage.clear()

        originalMenuFoodName.forEachIndexed { index, foodName ->
            if (foodName.contains(query.toString(), ignoreCase = true)) {
                filteredMenuFoodName.add(foodName)
                filteredMenuItemPrice.add(originalMenuFoodPrice[index])
                filteredMenuImage.add(originalMenuFoodImage[index])
            }
        }
        adapter.notifyDataSetChanged()
    }

    companion object {

    }
}