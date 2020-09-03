package com.deizepi.aplicacaoaula

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_biscoitoda_sorte.*

class BiscoitodaSorteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_biscoitoda_sorte)

        val biscoitodasorte = arrayListOf<String>(
            "A vida trará coisas boas se tiveres paciência.",
            "Demonstre amor e alegria em todas as oportunidades e verás que a paz nasce dentro de você.",
            "Não compense na ira o que lhe falta na razão",
            "Defeitos e virtudes são apenas dois lados da mesma moeda",
            "A maior de todas as torres começa no solo.",
            "Não há que ser forte. Há que ser flexível.",
            "Gente todo dia arruma os cabelos, por que não o coração?",
            "Há três coisas que jamais voltam; a flecha lançada, a palavra dita e a oportunidade perdida.",
            "A juventude não é uma época da vida, é um estado de espírito.",
            "Podemos escolher o que semear, mas somos obrigados a colher o que plantamos.",
            "É uma cilada, Bino!",
            "A pessoa que lê sua sorte entrou em greve. Não há biscoitos para você hoje.",
            "A gente já tentou colocar brinquedos aqui dentro, mas o Kinder Ovo processou.",
            " Na União Esquelética, a sorte lê o biscoito em você!"
        )

        btnbiscoitodescubra.setOnClickListener {
            txvBiscoitoSorte.text = biscoitodasorte.random()
        }
        btnbiscoitovoltar.setOnClickListener(){
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