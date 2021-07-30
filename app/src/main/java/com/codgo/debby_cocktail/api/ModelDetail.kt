package com.codgo.debby_cocktail.api

import com.google.gson.annotations.SerializedName

data class ModelDetail(
    @SerializedName("drinks")
    val drinkDetails: List<DrinkDetail>
)