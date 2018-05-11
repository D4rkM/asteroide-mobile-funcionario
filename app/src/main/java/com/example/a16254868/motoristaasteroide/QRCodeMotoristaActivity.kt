package com.example.a16254868.motoristaasteroide

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Color
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v4.app.ActivityCompat
import android.support.v4.content.ContextCompat
import android.support.v7.app.AppCompatActivity
import android.widget.Button
import com.example.a16254868.motoristaasteroide.R.id.btn

import kotlinx.android.synthetic.main.activity_qrcode_motorista.*
import kotlinx.android.synthetic.main.content_qrcode_motorista.*
import org.jetbrains.anko.textColor

class QRCodeMotoristaActivity : AppCompatActivity() {

    var permissao = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_qrcode_motorista)
        setSupportActionBar(toolbar)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        val retorno:String = intent.getStringExtra("retorno")

        if(retorno.equals("Passagem não validada")){

            txtValidacao.text = retorno
            txtValidacao.textColor = Color.parseColor("#9e1111")

        }else{
            txtValidacao.text = retorno
        }


        btn.setOnClickListener {

            if (ContextCompat.checkSelfPermission(this, Manifest.permission.CAMERA)
                    != PackageManager.PERMISSION_GRANTED) {

                ActivityCompat.requestPermissions(this,
                        arrayOf(Manifest.permission.CAMERA),
                        permissao)


            }else{
                val intent = Intent(this, ScanActivity::class.java)
                startActivity(intent)
                finish()
            }


        }

    }

    override fun onRequestPermissionsResult(requestCode: Int,
                                            permissions: Array<String>, grantResults: IntArray) {
        when (requestCode) {
            permissao -> {
                // If request is cancelled, the result arrays are empty.
                if ((grantResults.isNotEmpty() && grantResults[0] == PackageManager.PERMISSION_GRANTED)) {

                    val intent = Intent(this, ScanActivity::class.java)
                    startActivity(intent)
                    finish()


                } else {

                    // permission denied, boo! Disable the
                    // functionality that depends on this permission.

                }
                return
            }

        // Add other 'when' lines to check for other
        // permissions this app might request.

            else -> {
                // Ignore all other requests.
            }
        }
    }


}
