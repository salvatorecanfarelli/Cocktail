package com.codgo.debby_cocktail.utilities

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.codgo.debby_cocktail.api.ModelCocktail
import com.codgo.debby_cocktail.api.ModelDetail
import com.codgo.debby_cocktail.api.ModelGlobalCategorie
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class CocktailViewModel : ViewModel() {

    var onSuccessCocktail = MutableLiveData<ModelCocktail>()
    var onError = MutableLiveData<Boolean>(false)
    var onSuccessDetail = MutableLiveData<ModelDetail>()
    var idCocktail = MutableLiveData<String>()
    var onSuccessRandom = MutableLiveData<ModelDetail>()
    var onSuccessCategory = MutableLiveData<ModelGlobalCategorie>()
    var onSuccessSearch = MutableLiveData<ModelDetail>()


    fun getAllCocktail(query : String){
        CoroutineScope(Dispatchers.IO).launch {
            val response = GlobalCallRest().globalGetAllCocktail(query)
            if(response.body() != null){
                onSuccessCocktail.postValue(response.body())

            } else {
                onError.postValue(true)
            }
        }
    }
    fun getDetail(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val dResponse = GlobalCallRest().globalGetDetail(query)
            if (dResponse.body() != null){
                onSuccessDetail.postValue(dResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }
    fun getRandomDrink(){
        CoroutineScope(Dispatchers.IO).launch {
            val rResponse = GlobalCallRest().globalGetRandomDrink()
            if (rResponse.body() != null){
                onSuccessRandom.postValue(rResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }
    fun getGlass(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val gResponse = GlobalCallRest().globalGetGlass(query)
            if(gResponse.body() != null){
                onSuccessCategory.postValue(gResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }

    fun getCategory(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val cResponse = GlobalCallRest().globalGetCategoty(query)
            if(cResponse.body() != null){
                onSuccessCategory.postValue(cResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }

    fun getIngredient(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val iResponse = GlobalCallRest().globalGetIngredient(query)
            if(iResponse.body() != null){
                onSuccessCategory.postValue(iResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }

    fun getTipo(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val tResponse = GlobalCallRest().globalGetTipo(query)
            if(tResponse.body() != null){
                onSuccessCategory.postValue(tResponse.body())
            } else {
                onError.postValue(true)
            }
        }
    }

    fun getSearch(query: String){
        CoroutineScope(Dispatchers.IO).launch {
            val sResponse = GlobalCallRest().globalGetSearch(query)
            if(sResponse.body() != null){
                onSuccessSearch.postValue(sResponse.body())
            } else{
                onError.postValue(true)
            }
        }
    }
}