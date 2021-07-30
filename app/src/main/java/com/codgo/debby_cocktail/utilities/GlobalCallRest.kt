package com.codgo.debby_cocktail.utilities

class GlobalCallRest {
    suspend fun globalGetAllCocktail(query : String) = AdapterRest.clientEndpoints!!.getAllCocktail(query)
    suspend fun globalGetDetail(query: String) = AdapterRest.clientEndpoints!!.getDetail(query)
    suspend fun globalGetRandomDrink() = AdapterRest.clientEndpoints!!.getRandomDrink()
    suspend fun globalGetGlass(query: String) = AdapterRest.clientEndpoints!!.getGlass(query)
    suspend fun globalGetCategoty(query: String) = AdapterRest.clientEndpoints!!.getCategory(query)
    suspend fun globalGetIngredient(query: String) = AdapterRest.clientEndpoints!!.getIngredient(query)
    suspend fun globalGetTipo(query: String) = AdapterRest.clientEndpoints!!.getTipo(query)
    suspend fun globalGetSearch(query: String) = AdapterRest.clientEndpoints!!.getSearch(query)
}