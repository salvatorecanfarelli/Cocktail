package com.codgo.debby_cocktail.api

import com.google.gson.annotations.SerializedName

data class ModelCocktail(
    @SerializedName("drinks")
    val drinks: ArrayList<Cocktail>? = ArrayList()
)