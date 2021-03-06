package com.example.a16254868.motoristaasteroide

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem

import kotlinx.android.synthetic.main.activity_home_motorista.*
import kotlinx.android.synthetic.main.content_home_motorista.*

class HomeMotoristaActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_motorista)
        setSupportActionBar(toolbar)

        imgMotorista.setOnClickListener {

            val intent = Intent(this, PerfilMotoristaActivity::class.java)

            startActivity(intent)

        }

        imgQRCode.setOnClickListener {

            val intent = Intent(this, QRCodeMotoristaActivity::class.java)

            startActivity(intent)

        }

        imgNotificaoMotorista.setOnClickListener {

            val intent = Intent(this, NotificacaoMotoristaActivity::class.java)

            startActivity(intent)

        }

        imgLocalizacao.setOnClickListener {
            val intent = Intent(this,  LocalizacaoMotoristaActivity::class.java)

            startActivity(intent)
        }

        /*@Override
        public boolean onCreateOptionsMenu(Menu menu) {
            getMenuInflater().inflate(R.menu.home, menu);
            return true;
        }

        @Override
        public boolean onOptionsItemSelected(MenuItem item) {
            int id = item.getItemId();

            if(id == R.id.lojas){
                Toast.makeText(this, "asdddddddddddddddddddddd", Toast.LENGTH_SHORT).show();
            }
            return super.onOptionsItemSelected(item);
        }*/







    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return true
    }



}
