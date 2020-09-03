package com.deizepi.aplicacaoaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_calculadorade_imcbk.*

class CalculadoradeImcbkActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadorade_imcbk)


            btnImcCalcularbk.setOnClickListener(){
            val peso = edtImcPesobk.text.toString().toFloat()
            val altura = edtImcAlturabk.text.toString().toFloat()
            val alturaaoquadrado = (altura*altura)
            val imc = peso / alturaaoquadrado

            if (imc >= 19 && imc <=24){
               txvimcCalculobk.text = "Peso Ideal"
            }else if (imc >= 25 && imc <=29){
                txvimcCalculobk.text = "Sobrepeso"
            }else if (imc >= 30 && imc <=34){
                txvimcCalculobk.text = "Obesidade Grau 1"
            }else if (imc >= 35 && imc <=39){
                txvimcCalculobk.text = "Obesidade Grau 2"
            }else if (imc >= 40){
                txvimcCalculobk.text = "Obesidade Grau 3"
            }else{
                txvimcCalculobk.text = "Você está vivo?"
            }

        }

        btnImcLimparbk.setOnClickListener(){
            txvimcCalculobk.text = " "
        }
        btnImcVoltarbk.setOnClickListener(){
            AlertDialog.Builder(this)
                .setTitle("Atenção!!")
                .setMessage("Você realmente deseja Voltar?")
                .setPositiveButton("SIM") { _, _ ->
                    val mIntent = Intent(this, BlackMainActivity::class.java)
                    startActivity(mIntent)
                    finish()
                }
                .setNeutralButton("CANCELAR") { _, _ -> }
                .setCancelable(false)
                .create()
                .show()
        }

    }
}