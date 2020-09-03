package com.deizepi.aplicacaoaula

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnBiscoitodaSorte.setOnClickListener {
            val mIntent = Intent(this, BiscoitodaSorteActivity::class.java)
            startActivity(mIntent)
        }

        btnCalculadordeIpva.setOnClickListener {
            val mIntent = Intent(this, CalculadoradeIpvaActivity::class.java)
            startActivity(mIntent)
        }
        btnCalculadoraImc.setOnClickListener {
            val mIntent = Intent(this, CalculadoradeImcActivity::class.java)
            startActivity(mIntent)
        }

        btnMainSair.setOnClickListener(){
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