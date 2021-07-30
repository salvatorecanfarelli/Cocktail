package com.codgo.debby_cocktail.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.codgo.debby_cocktail.api.DrinkDetail
import com.codgo.debby_cocktail.databinding.FragmentDetailCocktailBinding
import com.codgo.debby_cocktail.utilities.CocktailViewModel
import com.codgo.debby_cocktail.utilities.genericAlert
import com.squareup.picasso.Picasso

class DetailCocktail : Fragment() {
    private lateinit var binding: FragmentDetailCocktailBinding
    val cocktailViewModel: CocktailViewModel by activityViewModels()
    var detailDrink = ArrayList<DrinkDetail>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentDetailCocktailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var idDrink: String = cocktailViewModel.idCocktail.value.toString()
        cocktailViewModel.getDetail(idDrink)

        cocktailViewModel.onError.observe(viewLifecycleOwner) {
            if (it == true) {
                genericAlert(cancelable = true, message = "Error", textxButton = "OK")
                cocktailViewModel.onError.postValue(false)
            }
        }
        cocktailViewModel.onSuccessDetail.observe(viewLifecycleOwner) {
            it.drinkDetails!!.forEach {
                detailDrink.add(it)
            }
            setUpView()
        }


    }

    fun setUpView(){
        detailDrink.forEach {
            binding.nomeDrink.text = it.strDrink
            binding.categoriaDrink.text = it.strCategory
            binding.tipoDrink.text = it.strAlcoholic
            binding.glassDrink.text = it.strGlass
            binding.istruzioni.text = it.strInstructionsIT
            binding.ingrediente1.text = it.strIngredient1
            binding.ingrediente2.text = it.strIngredient2
            binding.ingrediente3.text = it.strIngredient3
            binding.ingrediente4.text = it.strIngredient4
            binding.misure1.text = it.strMeasure1
            binding.misure2.text = it.strMeasure2
            binding.misure3.text = it.strMeasure3
            binding.misure4.text = it.strMeasure4
            Picasso.get().load(it.strDrinkThumb).into(binding.imageDrink)
        }
    }

}