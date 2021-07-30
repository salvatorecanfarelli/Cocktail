package com.codgo.debby_cocktail.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Spinner
import androidx.fragment.app.activityViewModels
import androidx.navigation.Navigation
import com.codgo.debby_cocktail.R
import com.codgo.debby_cocktail.databinding.FragmentCategorieBinding
import com.codgo.debby_cocktail.utilities.CocktailViewModel

const val CATEGORY = 2131296688
const val GLASS = 2131296689
const val ALCOL = 2131296692
const val INGREDIENT = 2131296690
const val TIPO = 2131296691

class Categorie : Fragment(), AdapterView.OnItemSelectedListener {
    private lateinit var binding : FragmentCategorieBinding
    val cocktailViewModel : CocktailViewModel by activityViewModels()
    var glasses = ""
    var category = ""
    var ingredients = ""
    var tipo = ""


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentCategorieBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        spinnerAdapter(R.array.glass, binding.spinnerGlass)
        binding.spinnerGlass.onItemSelectedListener = this

        binding.bicchiere.setOnClickListener {
        cocktailViewModel.getGlass(glasses)
        Navigation.findNavController(requireView()).navigate(R.id.action_categorie2_to_listaCocktailCategory)}


        spinnerAdapter(R.array.categorie, binding.spinnerCategorie)
        binding.spinnerCategorie.onItemSelectedListener = this

        binding.category.setOnClickListener {
            cocktailViewModel.getCategory(category)
            Navigation.findNavController(requireView()).navigate(R.id.action_categorie2_to_listaCocktailCategory)}


        spinnerAdapter(R.array.tipo_di_alcolico, binding.spinnerTipoAlcol)
        binding.spinnerTipoAlcol.onItemSelectedListener = this

        binding.tipoAlcol.setOnClickListener {
            cocktailViewModel.getIngredient(ingredients)
            Navigation.findNavController(requireView()).navigate(R.id.action_categorie2_to_listaCocktailCategory)}

        spinnerAdapter(R.array.ingrediente, binding.spinnerIngrediente)
        binding.spinnerIngrediente.onItemSelectedListener = this

        binding.ingredient.setOnClickListener {
           cocktailViewModel.getIngredient(ingredients)
            Navigation.findNavController(requireView()).navigate(R.id.action_categorie2_to_listaCocktailCategory) }

        spinnerAdapter(R.array.tipo, binding.spinnerTipo)
        binding.spinnerTipo.onItemSelectedListener = this

        binding.tipo.setOnClickListener {
           cocktailViewModel.getTipo(tipo)
            Navigation.findNavController(requireView()).navigate(R.id.action_categorie2_to_listaCocktailCategory)
        }
    }

    override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
        when (parent!!.id) {
            CATEGORY -> category = parent!!.getItemAtPosition(position).toString()
            GLASS -> glasses = parent!!.getItemAtPosition(position).toString()
            ALCOL -> ingredients = parent!!.getItemAtPosition(position).toString()
            INGREDIENT -> ingredients = parent!!.getItemAtPosition(position).toString()
            TIPO -> tipo = parent!!.getItemAtPosition(position).toString()
        }
    }

    override fun onNothingSelected(parent: AdapterView<*>?) {}

    private fun spinnerAdapter (array : Int, spinnerAdapter: Spinner) {
        ArrayAdapter.createFromResource(
            requireContext(),
            array,
            R.layout.support_simple_spinner_dropdown_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_dropdown_item_1line)
            spinnerAdapter.adapter = adapter
        }
    }

}