package com.example.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val edtTensao = findViewById<EditText>(R.id.ed_tensao)
        val edtCorrente = findViewById<EditText>(R.id.edt_corrente)
        val edtResistencia = findViewById<EditText>(R.id.edt_resistencia)
        val btnEnviar = findViewById<Button>(R.id.enviar)
        val txvSaudar = findViewById<TextView>(R.id.txv_salvar)


        btnEnviar.setOnClickListener {
            val edtTensao = edtTensao.text.toString()
            val edtCorrente = edtCorrente.text.toString()
            val edtResistencia = edtResistencia.text.toString()

            val tensao = edtTensao.toDoubleOrNull()
            val corrente = edtCorrente.toDoubleOrNull()
            val resistencia = edtResistencia.toDoubleOrNull()
            val resultado: Double
            if (tensao == null && resistencia != null && corrente != null) {
                resultado = resistencia * corrente
                txvSaudar.text = "Tensão: $resultado V"
            } else if (corrente == null && tensao != null && resistencia != null) {
                if (resistencia != 0.0) {
                    resultado = tensao / resistencia
                    txvSaudar.text = "Corrente: $resultado A"
                } else {
                    txvSaudar.text = "Resistência não pode ser zero!"
                }
            } else if (resistencia == null && tensao != null && corrente != null) {
                if (corrente != 0.0) {
                    resultado = tensao / corrente
                    txvSaudar.text = "Resistência: $resultado Ω"
                } else {
                    txvSaudar.text = "Corrente não pode ser zero!"
                }
            } else {
                txvSaudar.text = "Preencha exatamente dois campos!"
            }

        }
        }
    }
