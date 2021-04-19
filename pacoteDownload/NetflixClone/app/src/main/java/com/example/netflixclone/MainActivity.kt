package com.example.netflixclone

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        Handler(Looper.getMainLooper()).postDelayed({
                AbrirTelaLogin()
        },2000) // quanto tempo queremos que tela fique no ar.
    }

    private fun AbrirTelaLogin(){
        val intent = Intent(this,FormLogin::class.java )
        startActivity(intent)
        finish()
    }

}