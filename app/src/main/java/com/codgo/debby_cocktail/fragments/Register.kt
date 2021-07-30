package com.codgo.debby_cocktail.fragments

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.codgo.debby_cocktail.R
import com.codgo.debby_cocktail.api.ModelLogin
import com.codgo.debby_cocktail.databinding.FragmentRegisterBinding
import com.codgo.debby_cocktail.utilities.SharedPreferences
import com.codgo.debby_cocktail.utilities.genericAlert


class Register : Fragment() {

    private lateinit var binding : FragmentRegisterBinding
    var confEmail : Boolean = false


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentRegisterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.regEmail.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            }

            override fun afterTextChanged(s: Editable?) {
                if (android.util.Patterns.EMAIL_ADDRESS.matcher(s.toString()).matches()){
                    confEmail = true
                }
            }
        })
        binding.register.setOnClickListener {
            if(confEmail && isPasswordValid(binding.regPass.text.toString()) && binding.confPass.text.toString().equals(binding.regPass.text.toString())){
                var arrayUsers = SharedPreferences.getArrayUser()
                arrayUsers.add(ModelLogin(binding.regEmail.text.toString(),binding.regPass.text.toString()))
                SharedPreferences.setArrayUser(arrayUsers)
                Navigation.findNavController(requireView()).setGraph(R.navigation.navlogin)
            }
            else if (!confEmail){
                genericAlert(cancelable = true, message = "Registrazione non riuscita. Email non valida.", textxButton = "OK")
            }
            else
                genericAlert(cancelable = true, message = "Registrazione non riuscita. Password non valida.", textxButton = "OK")
        }
    }

    fun isPasswordValid (pass : String): Boolean {
        val regexUpper = (".*[A-Z].*").toRegex()
        val regexLower = (".*[a-z]+.*").toRegex()
        val regexNum = (".*[0-9]+.*").toRegex()
        val regexSpecial = (".*[!?&^%$#@()].*").toRegex()
        return regexUpper.containsMatchIn(pass) && regexLower.containsMatchIn(pass) && regexNum.containsMatchIn(pass) && regexSpecial.containsMatchIn(pass)
    }

}