package utils

import android.content.Context
import android.icu.lang.UCharacter
import android.util.Log
import android.widget.Toast
import models.Funcionario
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.uiThread
import org.json.JSONArray

/**
 * Created by 16254868 on 23/04/2018.
 */
fun repetirMotorista(loginUsuario:String, senhaUsuario:String, context: Context, f:(u: Funcionario)->Unit){

    var funcionario = Funcionario()

    UCharacter.GraphemeClusterBreak.T.doAsync {

        val url = ipServidorComPorta() +"/api/v1/autenticar/motorista"

        val map = HashMap<String, String>()
        map.put("login", loginUsuario)
        map.put("senha", senhaUsuario)

        val resultado = HttpConnection.post(url, map)

        Log.d("API", resultado)


        uiThread {

            val jsonarray = JSONArray(resultado)

            //Verificando se a senha ou usuário estão corretas
            if(jsonarray.isNull(0)){
                Toast.makeText(context, "Usuário ou senha incorreto", Toast.LENGTH_SHORT).show()
            }else{
                for (i in 0 until jsonarray.length()) {

                    val jsonobject = jsonarray.getJSONObject(i)

                    funcionario = Funcionario(jsonobject.getInt("id"), jsonobject.getString("nome"), jsonobject.getString("login"), jsonobject.getInt("ativo"),
                            jsonobject.getString("cpf"), jsonobject.getString("cnh"), jsonobject.getString("email"), jsonobject.getString("telefone"),
                            jsonobject.getString("celular"), jsonobject.getString("rg"), jsonobject.getString("sexo"), jsonobject.getString("datanasc"))

                    f.invoke(funcionario)

                }
            }
        }
    }
}