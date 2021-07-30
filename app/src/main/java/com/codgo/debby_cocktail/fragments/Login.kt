package com.codgo.debby_cocktail.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.codgo.debby_cocktail.MainActivity
import com.codgo.debby_cocktail.R
import com.codgo.debby_cocktail.SecondActivity
import com.codgo.debby_cocktail.databinding.FragmentLoginBinding
import com.codgo.debby_cocktail.utilities.SharedPreferences
import com.codgo.debby_cocktail.utilities.genericAlert


class Login : Fragment() {

    private lateinit var binding : FragmentLoginBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.login.setOnClickListener {
            val userShared = SharedPreferences.getArrayUser()
            var login = false
            userShared.forEach {
                var logEmail = it.email == binding.email.text.toString()
                var logPass = it.password == binding.password.text.toString()
                if (logEmail && logPass) {
                    login = true
                }
            }
            if (login){
                startActivity(Intent(requireContext(),SecondActivity::class.java))
                requireActivity().finish()
            }
            else
            { genericAlert(cancelable = true, message = "User not found. Please register now.", textxButton = "OK")}

        }

        binding.register.setOnClickListener {
            Navigation.findNavController(requireView()).navigate(R.id.action_login3_to_register2)
        }
    }

}