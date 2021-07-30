package com.codgo.debby_cocktail.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.codgo.debby_cocktail.api.DrinkDetail
import com.codgo.debby_cocktail.databinding.FragmentDrinkRandomBinding
import com.codgo.debby_cocktail.utilities.CocktailViewModel
import com.codgo.debby_cocktail.utilities.genericAlert
import com.squareup.picasso.Picasso


class DrinkRandom : Fragment() {
    private lateinit var binding : FragmentDrinkRandomBinding
    val cocktailViewModel : CocktailViewModel by activityViewModels()
    var detailRandomDrink = ArrayList<DrinkDetail>()


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDrinkRandomBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        cocktailViewModel.getRandomDrink()

        cocktailViewModel.onError.observe(viewLifecycleOwner) {
            if (it == true) {
                genericAlert(cancelable = true, message = "Error", textxButton = "OK")
                cocktailViewModel.onError.postValue(false)
            }
        }

        cocktailViewModel.onSuccessRandom.observe(viewLifecycleOwner) {
            it.drinkDetails!!.forEach {
                detailRandomDrink.add(it)
            }
            setUpView()
        }
    }

    fun setUpView(){
        detailRandomDrink.forEach {
            binding.titleDrink.text = it.strDrink
            binding.categoriaRandom.text = it.strCategory
            binding.tipoRandom.text = it.strAlcoholic
            binding.glassRandom.text = it.strGlass
            binding.istruzioniRandom.text = it.strInstructionsIT
            binding.ingrediente1R.text = it.strIngredient1
            binding.ingrediente2R.text = it.strIngredient2
            binding.ingrediente3R.text = it.strIngredient3
            binding.ingrediente4R.text = it.strIngredient4
            binding.misure1R.text = it.strMeasure1
            binding.misure2R.text = it.strMeasure2
            binding.misure3R.text = it.strMeasure3
            binding.misure4R.text = it.strMeasure4
            Picasso.get().load(it.strDrinkThumb).into(binding.imageRandom)
        }
    }

}