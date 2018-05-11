package com.example.a16254868.motoristaasteroide

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_perfil_motorista.*
import kotlinx.android.synthetic.main.content_perfil_motorista.*
import models.Funcionario
import utils.repetirMotorista


class PerfilMotoristaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_motorista)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val preferencias = getSharedPreferences("Funcionario", Context.MODE_PRIVATE)

        val login = preferencias.getString("login", "")
        val senha = preferencias.getString("senha", "")

        var funcionario = Funcionario()

        repetirMotorista(login, senha, applicationContext) {

            funcionario = it

            preencherCampos(funcionario)
        }
    }

    fun preencherCampos(funcionario: Funcionario){
        nomeMotorista.text = funcionario.getNome()
        cpfMotorista.text = funcionario.getCpf()
        cnhMotorista.text = funcionario.getCnh()
        emailMotorista.text = funcionario.getEmail()
        telMotorista.text = funcionario.getTelefone()
        celMotorista.text = funcionario.getCelular()
        rgMotorista.text = funcionario.getRg()
        sexoMotorista.text = funcionario.getSexo()
        dtNascMotorista.text = funcionario.getDataNasc()
    }

}
