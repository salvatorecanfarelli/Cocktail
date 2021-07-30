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
import com.codgo.debby_cocktail.api.Cocktail
import com.codgo.debby_cocktail.databinding.FragmentAllCocktailBinding
import com.codgo.debby_cocktail.utilities.CocktailViewModel
import com.codgo.debby_cocktail.utilities.genericAlert
import com.robertlevonyan.components.kex.create


class AllCocktail : Fragment() {
    private lateinit var binding : FragmentAllCocktailBinding
    val cocktailViewModel : CocktailViewModel by activityViewModels()
    var alcoholic = ArrayList<Cocktail>()
    var noAlcoholic = ArrayList<Cocktail>()
    var allCocktail = ArrayList<Cocktail>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentAllCocktailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        cocktailViewModel.getAllCocktail("Alcoholic")

        cocktailViewModel.onError.observe(viewLifecycleOwner) {
            if (it == true){
                genericAlert(cancelable = true, message = "Error", textxButton = "OK")
                cocktailViewModel.onError.postValue(false)}
        }
        cocktailViewModel.onSuccessCocktail.observe(viewLifecycleOwner){
            it.drinks!!.forEach {
                it.strDrink?.let {it1 -> alcoholic.add(it)
                }
            }
        }
        cocktailViewModel.getAllCocktail("Non_Alcoholic")
        cocktailViewModel.onSuccessCocktail.observe(viewLifecycleOwner){
            it.drinks!!.forEach {
                it.strDrink?.let {it1 -> noAlcoholic.add(it)}
                allCocktail = ((alcoholic + noAlcoholic) as ArrayList<Cocktail>)
            }
            recyclerCocktail()
        }

    }

    fun recyclerCocktail () {
        binding.recyclerDrink.create(
            R.layout.item_cocktail,
            allCocktail,
            LinearLayoutManager(requireContext()),
            creator = { item, position ->
                var coktailAll = findViewById<TextView>(R.id.cocktail)
                var cardDrink = findViewById<CardView>(R.id.cardViewDrink)
                coktailAll.text = item.strDrink
                cardDrink.setOnClickListener {
                    cocktailViewModel.idCocktail.postValue(allCocktail[position].idDrink)
                    Navigation.findNavController(requireView()).navigate(R.id.action_global_detailCocktail)
                }
                }
            )}
}