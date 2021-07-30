package com.codgo.debby_cocktail.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import androidx.recyclerview.widget.LinearLayoutManager
import com.codgo.debby_cocktail.R
import com.codgo.debby_cocktail.api.GlobalCategorie
import com.codgo.debby_cocktail.databinding.FragmentListaCocktailCategoryBinding
import com.codgo.debby_cocktail.utilities.CocktailViewModel
import com.codgo.debby_cocktail.utilities.genericAlert
import com.robertlevonyan.components.kex.create

class ListaCocktailCategory : Fragment() {
    private lateinit var binding: FragmentListaCocktailCategoryBinding
    val cocktailViewModel : CocktailViewModel by activityViewModels()
    var category = ArrayList<GlobalCategorie>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentListaCocktailCategoryBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cocktailViewModel.onError.observe(viewLifecycleOwner) {
            if (it == true){
                genericAlert(cancelable = true, message = "Error", textxButton = "OK")
                cocktailViewModel.onError.postValue(false)}
        }

        cocktailViewModel.onSuccessCategory.observe(viewLifecycleOwner){
            category.clear()
            it.globalCategorie.forEach {
                it.strDrink!!.let { it1 -> category.add(it) }
            }
            recyclerCategory()
        }
    }

    fun recyclerCategory () {
        binding.recyclerCategory.create(
            R.layout.item_category,
            category,
            LinearLayoutManager(requireContext()),
            creator = { item, position ->
                var categoryAll = findViewById<TextView>(R.id.drinkCategory)
                var cardCategory = findViewById<CardView>(R.id.cardViewCategory)
                categoryAll.text = item.strDrink
                cardCategory.setOnClickListener {
                    cocktailViewModel.idCocktail.postValue(category[position].idDrink)
                    Navigation.findNavController(requireView()).navigate(R.id.action_global_detailCocktail4)
                }
            }
        )}


}