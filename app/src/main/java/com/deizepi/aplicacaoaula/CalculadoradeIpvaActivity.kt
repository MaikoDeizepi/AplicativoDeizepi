package com.deizepi.aplicacaoaula

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_calculadorade_ipva.*

class CalculadoradeIpvaActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calculadorade_ipva)

        val listaEstado = arrayListOf(
            "Selecione a sua Cidade", //0
            "Mato Grosso do Sul",   // 1
            "Goiás",                //2
            "Mato Grosso",          //3
            "Distrito Federal",     //4
            "Sergipe",              //5
            "Paraíba",              //6
            "Alagoas",              //7
            "Pernambuco",           //8
            "Rio Grande do Norte",  //9
            "Ceará",                //10
            "Piauí",                //11
            "Maranhão",             //12
            "Bahia",                //13
            "Acre",                 //14
            "Tocantins",            //15
            "Amapá",                //16
            "Amazonas",             //17
            "Roraima",              //18
            "Rondônia",             //19
            "Espírito Santo",       //20
            " São Paulo",           //21
            "Rio de Janeiro",       //22
            "Minas Gerais",         //23
            "Santa Catarina",       //24
            "Rio Grande do Sul",    //25
            "Paraná",               //26
            "Pára"                  //27
        )
        val estadoAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item,
            listaEstado
        )
        spnEstados.adapter = estadoAdapter



        btnIpvaCalcular.setOnClickListener {
            val estados = spnEstados.selectedItem.toString()

            if (estados == listaEstado[24] || estados == listaEstado[20] || estados == listaEstado[5]
                || estados == listaEstado[6]|| estados == listaEstado[14]|| estados == listaEstado[15]
            ){
                val valorcarro =edtValorCarro.text.toString().toFloat()
                val ipva = (valorcarro * 2)/100
                txvValorIpva.text = ipva.toString()+" Reais"

            }else if (estados == listaEstado[7] || estados == listaEstado[8] || estados == listaEstado[9]
                || estados == listaEstado[10]|| estados == listaEstado[10]
                || estados == listaEstado[11]|| estados == listaEstado[12]|| estados == listaEstado[13]
                && estados == listaEstado[27]|| estados == listaEstado[1]|| estados == listaEstado[2]){
                val valorcarro =edtValorCarro.text.toString().toFloat()
                val ipva = (valorcarro * 2.5)/100
                txvValorIpva.text = ipva.toString()+" Reais"
            }else if (estados == listaEstado[25] || estados == listaEstado[21] || estados == listaEstado[16]
                || estados == listaEstado[17]|| estados == listaEstado[18]|| estados == listaEstado[19]){
                val valorcarro =edtValorCarro.text.toString().toFloat()
                val ipva = (valorcarro * 3)/100
                txvValorIpva.text = ipva.toString()+" Reais"
            }else if (estados == listaEstado[25]){
                val valorcarro =edtValorCarro.text.toString().toFloat()
                val ipva = (valorcarro * 3.5)/100
                txvValorIpva.text = ipva.toString()+" Reais"
            }else{
                val valorcarro =edtValorCarro.text.toString().toFloat()
                val ipva = (valorcarro * 4)/100
                txvValorIpva.text = ipva.toString()+" Reais"
            }
        }

        btnIpvaLimpar.setOnClickListener(){
            txvValorIpva.text = " "
        }
        btnIpvaVoltar.setOnClickListener(){
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