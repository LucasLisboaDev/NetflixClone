package com.example.netflixclone

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.netflixclone.databinding.ActivityFormLoginBinding
import com.google.firebase.FirebaseNetworkException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException

class FormLogin : AppCompatActivity() {

    private lateinit var binding: ActivityFormLoginBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityFormLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar!!.hide()
        VerificarUsuarioLogado()

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

           var erro = it

           when{
               erro is FirebaseAuthInvalidCredentialsException -> mensagem_erro.setText(" E-mail ou senha estão incorretos.")
               erro is FirebaseNetworkException -> mensagem_erro.setText(" Sem conexão com a internet.")
               else -> mensagem_erro.setText("Erro ao logar usuário.")

           }

       }

    }

    private fun VerificarUsuarioLogado(){
        val usuarioLogado = FirebaseAuth.getInstance().currentUser

        if (usuarioLogado != null){
            IrParaTelaDeFilmes()
        }
    }


    private fun IrParaTelaDeFilmes(){
        val intent = Intent(this,ListaFilmesKotlin::class.java)
        startActivity(intent)
        finish()
    }
}