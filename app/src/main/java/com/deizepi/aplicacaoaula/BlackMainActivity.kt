package com.deizepi.aplicacaoaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_black_main.*

class BlackMainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_black_main)


         btnBiscoitodaSortebk.setOnClickListener {
            val mIntent = Intent(this, BiscoitodaSortebkActivity::class.java)
            startActivity(mIntent)
        }

        btnCalculadordeIpvabk.setOnClickListener {
            val mIntent = Intent(this, CalculadoradeIpvabkActivity::class.java)
            startActivity(mIntent)
        }
        btnCalculadoraImcbk.setOnClickListener {
            val mIntent = Intent(this, CalculadoradeImcbkActivity::class.java)
            startActivity(mIntent)
        }

        btnMainBlackSair.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("Atenção!!")
                .setMessage("Você realmente deseja Sair?")
                .setPositiveButton("SIM") { _, _ ->
                    val mIntent = Intent(this, LoginActivity::class.java)
                    startActivity(mIntent)
                    finishAffinity()
                }
                .setNeutralButton("CANCELAR") { _, _ -> }
                .setCancelable(false)
                .create()
                .show()
        }


    }
}