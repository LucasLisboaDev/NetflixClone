package com.example.netflixclone

import android.content.Intent
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.example.netflixclone.databinding.ActivityListaFilmesKotlinBinding
import com.google.firebase.auth.FirebaseAuth

class ListaFilmesKotlin : AppCompatActivity() {

    private lateinit var binding: ActivityListaFilmesKotlinBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListaFilmesKotlinBinding.inflate(layoutInflater)
        setContentView(binding.root)



    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflate = menuInflater
        inflate.inflate(R.menu.menu_principal,menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        when(item.itemId){
            R.id.deslogar -> {
                                   FirebaseAuth.getInstance().signOut()
                            }
                         }

        return super.onOptionsItemSelected(item)
    }

    private fun VoltarTelaLogin(){
        val intent = Intent(this, FormLogin::class.java  )
        startActivity(intent)
        finish()
    }
}