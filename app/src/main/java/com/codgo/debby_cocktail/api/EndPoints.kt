package com.codgo.debby_cocktail.api

import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface EndPoints {
    @GET("/api/json/v1/1/filter.php")
    suspend fun getAllCocktail(@Query("a") query: String): Response<ModelCocktail>
    @GET("/api/json/v1/1/lookup.php")
    suspend fun getDetail(@Query("i") query: String): Response<ModelDetail>
    @GET("/api/json/v1/1/random.php")
    suspend fun getRandomDrink (): Response<ModelDetail>
    @GET("/api/json/v1/1/filter.php")
    suspend fun getGlass(@Query("g") query: String): Response<ModelGlobalCategorie>
    @GET("/api/json/v1/1/filter.php")
    suspend fun getCategory(@Query("c") query: String): Response<ModelGlobalCategorie>
    @GET("/api/json/v1/1/filter.php")
    suspend fun getIngredient(@Query("i") query: String): Response<ModelGlobalCategorie>
    @GET("/api/json/v1/1/filter.php")
    suspend fun getTipo(@Query("a") query: String): Response<ModelGlobalCategorie>
    @GET("/api/json/v1/1/search.php")
    suspend fun getSearch(@Query("f")query: String): Response<ModelDetail>
}
