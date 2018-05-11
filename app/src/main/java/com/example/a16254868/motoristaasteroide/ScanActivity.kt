package com.example.a16254868.motoristaasteroide

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import com.google.zxing.Result

import kotlinx.android.synthetic.main.activity_scan2.*
import me.dm7.barcodescanner.zxing.ZXingScannerView
import org.jetbrains.anko.toast

class ScanActivity : AppCompatActivity(), ZXingScannerView.ResultHandler  {

    private var mScannerView: ZXingScannerView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_scan2)
        setSupportActionBar(toolbar)

        fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show()
        }

        mScannerView = ZXingScannerView(this)   // Programmatically initialize the scanner view
        setContentView(mScannerView)
    }

    public override fun onResume() {
        super.onResume()
        mScannerView!!.setResultHandler(this) // Register ourselves as a handler for scan results.
        mScannerView!!.startCamera()          // Start camera on resume
    }

    public override fun onPause() {
        super.onPause()
        mScannerView!!.stopCamera()           // Stop camera on pause
    }

    override fun handleResult(rawResult: Result) {
        // Do something with the result here
        // Log.v("tag", rawResult.getText()); // Prints scan results
        // Log.v("tag", rawResult.getBarcodeFormat().toString()); // Prints the scan format (qrcode, pdf417 etc.)

        //MainActivity.tvresult!!.setText(rawResult.text)
        toast(rawResult.text)

        intent = Intent(applicationContext, QRCodeMotoristaActivity::class.java)

        intent.putExtra("retorno", rawResult.text)

        startActivity(intent)

        //onBackPressed()

        // If you would like to resume scanning, call this method below:
        //mScannerView.resumeCameraPreview(this);
    }

}
