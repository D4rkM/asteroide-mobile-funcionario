package com.example.a16254868.motoristaasteroide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import org.json.JSONArray
import org.json.JSONObject
import java.io.Serializable
import android.R.id.edit
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager



class MainActivity : AppCompatActivity() {

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
                doAsync {

                    val login = txtLoginUsuario.text.toString()
                    val senha = txtSenhaUsuario.text.toString()

                    val url = "http://10.107.144.9:3000/api/v1/autenticar/motorista"

                    val map = HashMap<String, String>()
                    map.put("login", login)
                    map.put("senha", senha)

                    val resultado = HttpConnection.post(url, map)

                    Log.d("API", resultado)

                    uiThread {

                        var ativo = ""

                        val jsonarray = JSONArray(resultado)

                        for (i in 0 until jsonarray.length()) {

                            val jsonobject = jsonarray.getJSONObject(i)
                            ativo = jsonobject.getString("ativo");

                            if(ativo.equals("1")){

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
    }
}
