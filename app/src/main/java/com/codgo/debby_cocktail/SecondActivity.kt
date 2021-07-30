package com.codgo.debby_cocktail

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import com.codgo.debby_cocktail.databinding.SecondActivityBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView

class SecondActivity: AppCompatActivity(), BottomNavigationView.OnNavigationItemSelectedListener{
    val binding by lazy {
        SecondActivityBinding.inflate(layoutInflater)
    }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.bottomnav.setOnNavigationItemSelectedListener(this)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.lista -> Navigation.findNavController(this, R.id.conteiner_view).setGraph(R.navigation.navcocktail)
            R.id.random -> Navigation.findNavController(this, R.id.conteiner_view).setGraph(R.navigation.navrandom)
            R.id.categorie -> Navigation.findNavController(this, R.id.conteiner_view).setGraph(R.navigation.navcategorie)
        }
        return true
    }
}