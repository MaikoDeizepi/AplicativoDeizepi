package com.deizepi.aplicacaoaula

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)
        val listaGenero = arrayListOf("Selecione o Gênero", "Feminino", "Masculino", "Outros")
        val listaTema = arrayListOf("Selecione o tema", "Tema Escuro", "Tema Claro")
        val generoAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item,
            listaGenero
        )
        val temaAdapter = ArrayAdapter(
            this, android.R.layout.simple_spinner_dropdown_item,
            listaTema
        )
        spnCadastroCor.adapter = temaAdapter
        spnCadastroGenero.adapter = generoAdapter

        btnCadastroCadastrar.setOnClickListener {
            val nome = edtCadastroNome.text.toString().trim()
            val sobrenome = edtCadastroSobrenome.text.toString().trim()
            val email = edtCadastroEmail.text.toString().trim().toLowerCase()
            val senha = edtCadastroSenha.text.toString().trim()
            val genero = spnCadastroGenero.selectedItem.toString()
            val cor_app = spnCadastroCor.selectedItem.toString()

                if (nome.isEmpty()) {
                    edtCadastroNome.error = "Campo Obrigatório"
                    edtCadastroNome.requestFocus()
                } else if (sobrenome.isEmpty()) {
                    edtCadastroSobrenome.error = "Campo Obrigatório"
                    edtCadastroSobrenome.requestFocus()
                } else if (email.isEmpty()) {
                    edtCadastroEmail.error = "Campo Obrigatório"
                    edtCadastroEmail.requestFocus()
                } else if (senha.isEmpty()) {
                    edtCadastroSenha.error = "Campo Obrigatório"
                    edtCadastroSenha.requestFocus()
                } else if (genero == listaGenero[0]) {
                    Toast.makeText(this, "Escolha um Gênero", Toast.LENGTH_SHORT).show()
                } else if (cor_app == listaTema[0]) {
                    Toast.makeText(this, "Escolha um tema", Toast.LENGTH_SHORT).show()
                } else {
                    val sharedPrefs = getSharedPreferences(
                        "cadastro_$email",
                        Context.MODE_PRIVATE
                    )
                    val editPrefs = sharedPrefs.edit()
                    editPrefs.putString("NOME", nome)
                    editPrefs.putString("SOBRENOME", sobrenome)
                    editPrefs.putString("EMAIL", email)
                    editPrefs.putString("SENHA", senha)
                    editPrefs.putString("GENERO", genero)
                    editPrefs.putString("COR", cor_app)
                    editPrefs.apply()

                    if (cor_app == listaTema[1] ){
                        val mIntent = Intent(this, BlackMainActivity::class.java)
                       mIntent.putExtra("INTENT_EMAIL",email)
                        startActivity(mIntent)
                        finishAffinity()

                    }else{
                        val mIntent = Intent(this, MainActivity::class.java)
                        mIntent.putExtra("INTENT_EMAIL",email)
                        startActivity(mIntent)
                        finishAffinity()
                    }


                }
        }
    }
}