package com.codgo.debby_cocktail.api

import com.google.gson.annotations.SerializedName

data class ModelGlobalCategorie(
    @SerializedName("drinks")
    val globalCategorie: List<GlobalCategorie>
)