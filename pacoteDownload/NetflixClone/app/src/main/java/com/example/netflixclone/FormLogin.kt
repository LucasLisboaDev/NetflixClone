package com.example.netflixclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflixclone.databinding.ActivityFormLoginBinding
import com.google.firebase.auth.FirebaseAuth

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()

        binding.txtTelaCadastro.setOnClickListener{
            val intent = Intent( this, FormCadastro::class.java)
            startActivity(intent)

        }

        binding.btEntrar.setOnClickListener {

            val email = binding.editEmail.text.toString()
            val senha = binding.editSenha.text.toString()
            val mensagem_erro = binding.mensagemError

            if (email.isEmpty() || senha.isEmpty()){
                mensagem_erro.setText("Preencha todos os campos")
            }else{
                        AutenticarUsuario()

            }
        }

    }

    private fun AutenticarUsuario(){

        val email = binding.editEmail.text.toString()
        val senha = binding.editSenha.text.toString()
        val mensagem_erro = binding.mensagemError

       FirebaseAuth.getInstance().signInWithEmailAndPassword(email,senha).addOnCompleteListener {
           if (it.isSuccessful){
               Toast.makeText(this, "Login efetuado com sucesso", Toast.LENGTH_SHORT).show()
                IrParaTelaDeFilmes()
           }
       }.addOnFailureListener {
            mensagem_erro.setText("Erro ao logar usuário")
       }

    }
    private fun IrParaTelaDeFilmes(){
        val intent = Intent(this,ListaFilmesKotlin::class.java)
        startActivity(intent)
        finish()
    }
}