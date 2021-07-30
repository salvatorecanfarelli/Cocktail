package com.codgo.debby_cocktail.utilities

import android.content.Context
import android.content.SharedPreferences
import androidx.core.content.edit
import com.codgo.debby_cocktail.api.ModelLogin
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

const val MODEL_LOGIN ="model_login"
const val ARRAY_LOGIN ="array_login"
const val NAME = "RegisterLogin"
const val MODE = Context.MODE_PRIVATE

class SharedPreferences {
    companion object {
        lateinit var preferences: SharedPreferences

        fun init(context: Context) {
            preferences = context.getSharedPreferences(NAME, MODE)
        }


        fun putUserModel(value: ModelLogin) {
            preferences.edit {
                putString(MODEL_LOGIN, Gson().toJson(value))
            }
        }


        fun getUserModel(): ModelLogin {
            var modelLog = preferences.getString(MODEL_LOGIN, "")
            return if (modelLog.isNullOrBlank()) {
                ModelLogin()
            } else {
                Gson().fromJson(modelLog, ModelLogin::class.java)
            }
        }

        fun setArrayUser(value : ArrayList<ModelLogin>){
            preferences.edit{
                putString(ARRAY_LOGIN, Gson().toJson(value))
            }

        }

        fun getArrayUser() : ArrayList<ModelLogin>{
            var modelReg = preferences.getString(ARRAY_LOGIN, "")
            return if (modelReg.isNullOrBlank()) {
                ArrayList()
            } else {
                //Gson().fromJson<ArrayList<ModelLogin>>(modelReg, ModelLogin::class.java)
                Gson().fromJson(modelReg, object : TypeToken<ArrayList<ModelLogin>>(){}.type)
            }

        }

    }
}