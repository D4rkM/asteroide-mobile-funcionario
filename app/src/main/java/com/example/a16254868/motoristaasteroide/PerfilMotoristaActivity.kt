package com.example.a16254868.motoristaasteroide

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

import kotlinx.android.synthetic.main.activity_perfil_motorista.*
import kotlinx.android.synthetic.main.content_perfil_motorista.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import java.util.*


class PerfilMotoristaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_motorista)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val preferencias = getSharedPreferences("Funcionario", Context.MODE_PRIVATE)

        var funcionario = Funcionario()

        doAsync {

            val login = preferencias.getString("login", "")
            val senha = preferencias.getString("senha", "")

            //val url = "http://10.0.2.2/inf4m/asteroide-master/API/v1/login_api.php"

            val url = "http://10.107.144.9:3000/api/v1/autenticar/motorista"

            val map = HashMap<String, String>()
            map.put("login", login)
            map.put("senha", senha)

            val resultado = HttpConnection.post(url, map)

            Log.d("API", resultado)

            uiThread {

                val jsonarray = JSONArray(resultado)

                for (i in 0 until jsonarray.length()) {

                    val jsonobject = jsonarray.getJSONObject(i)

                    funcionario = Funcionario(jsonobject.getInt("id"), jsonobject.getString("nome"), jsonobject.getString("login"), jsonobject.getInt("ativo"),
                            jsonobject.getString("cpf"), jsonobject.getString("cnh"), jsonobject.getString("email"), jsonobject.getString("telefone"),
                            jsonobject.getString("celular"), jsonobject.getString("rg"), jsonobject.getString("sexo"), jsonobject.getString("datanasc"))

                    preencherCampos(funcionario)
                }
            }
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
