package com.codgo.debby_cocktail.api

import com.google.gson.annotations.SerializedName

data class ModelLogin(
    @SerializedName("email")
    val email : String = "",
    @SerializedName("password")
    val password : String = ""
)
