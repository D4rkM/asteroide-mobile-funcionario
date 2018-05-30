package com.example.a16254868.motoristaasteroide

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.uiThread
import org.json.JSONObject

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        botaoLogar.setOnClickListener {

            val login = txtLoginUsuario.text.toString()
            val senha = txtSenhaUsuario.text.toString()

             doAsync {
                val url = "http://10.0.2.2/inf4m/asteroide/API/v1/login_api.php"

                val map = HashMap<String, String>()
                map.put("login", login)
                map.put("senha", senha)


                val resultado = HttpConnection.post(url, map)


                Log.d("API", resultado)


                uiThread {

                    val json = JSONObject(resultado)

                    val login_state = json.getBoolean("login_state")

                    if(login_state == true){

                        val usuario = json.getJSONObject("usuario")

                        val nome = usuario.getString("nome")

                       // txt_resultado.text = "Usuario $nome logado com sucesso"




                        val intent = Intent(applicationContext, HomeMotoristaActivity::class.java)

                        startActivity(intent)

                        //tiro o login da memoria
                        finish()

                    }else{

                        //txt_resultado.text ="Login incorreto"
                    }

                }

            }


        }
    }
}
