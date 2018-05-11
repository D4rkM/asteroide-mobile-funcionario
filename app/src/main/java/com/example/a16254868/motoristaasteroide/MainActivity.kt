package com.example.a16254868.motoristaasteroide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import android.content.Context
import android.widget.Toast
import models.Funcionario
import utils.repetirMotorista


class MainActivity : AppCompatActivity(){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val preferencias = getSharedPreferences("Funcionario", Context.MODE_PRIVATE)

        botaoLogar.setOnClickListener {

            if(txtLoginUsuario.text.toString().equals("")){

                txtLoginUsuario.setError("Esse campo não pode ficar em branco")

            }else if(txtSenhaUsuario.text.toString().equals("")){

                txtSenhaUsuario.setError("Esse campo não pode ficar em branco")

            }else{

                var funcionario = Funcionario()

                val login = txtLoginUsuario.text.toString()
                val senha = txtSenhaUsuario.text.toString()

                repetirMotorista(login, senha, applicationContext) {//Mandando dados para classe que contém a API

                    funcionario = it

                    if(funcionario.getAtivo() == 1){ //Verificando se o funcionario está ativo
                        preferencias.edit().putString("login", login).apply()
                        preferencias.edit().putString("senha", senha).apply()

                        val intent = Intent(applicationContext, HomeMotoristaActivity::class.java)

                        startActivity(intent)

                        finish()

                        Toast.makeText(applicationContext, "Usuário logado com sucesso", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(applicationContext, "Usuário ou senha incorreto", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }
}
