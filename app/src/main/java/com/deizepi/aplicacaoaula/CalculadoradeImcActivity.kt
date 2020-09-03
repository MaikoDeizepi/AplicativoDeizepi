package com.deizepi.aplicacaoaula

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_calculadorade_imc.*

class CalculadoradeImcActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadorade_imc)

        btnImcCalcular.setOnClickListener(){
            val peso = edtImcPeso.text.toString().toFloat()
            val altura = edtImcAltura.text.toString().toFloat()
            val alturaaoquadrado = (altura*altura)
            val imc = peso / alturaaoquadrado

            if (imc >= 19 && imc <=24){
               txvimcCalculo.text = "Peso Ideal"
            }else if (imc >= 25 && imc <=29){
                txvimcCalculo.text = "Sobrepeso"
            }else if (imc >= 30 && imc <=34){
                txvimcCalculo.text = "Obesidade Grau 1"
            }else if (imc >= 35 && imc <=39){
                txvimcCalculo.text = "Obesidade Grau 2"
            }else if (imc >= 40){
                txvimcCalculo.text = "Obesidade Grau 3"
            }else{
                txvimcCalculo.text = "Você está vivo?"
            }

        }

        btnImcLimpar.setOnClickListener(){
            txvimcCalculo.text = " "

        }
        btnImcVoltar.setOnClickListener(){

            AlertDialog.Builder(this)
                .setTitle("Atenção!!")
                .setMessage("Você realmente deseja Voltar?")
                .setPositiveButton("SIM") { _, _ ->
                    val mIntent = Intent(this, MainActivity::class.java)
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
