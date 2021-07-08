package com.lorena.calculadaoraimc

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.lorena.calculadaoraimc.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(this.layoutInflater)
        setContentView(binding.root)

        val bt_calcular = binding.butcalcimc
        val message = binding.message


        // criando um botao calcuar
        bt_calcular.setOnClickListener {

            //capturando dados do campo de texto e convertendo para string
            val editpeso = binding.editPeso.text.toString()
            val editaltura = binding.editAltura.text.toString()


            //validando o campo
            // se edit peso estiver vazio
            if (editpeso.isEmpty()) {
                message.setText("informe seu peso")
            } else if (editaltura.isEmpty()) {
                message.setText("informe sua altura")

            } else {

                CalculodeIMC()

            }
        }
    }

    private fun CalculodeIMC() {

        val pesoID = binding.editPeso
        val alturaID = binding.editAltura

        val peso = java.lang.Float.parseFloat(pesoID.text.toString())
        val altura = java.lang.Float.parseFloat(alturaID.text.toString())
        val resultado = binding.message
        val imc = peso / (altura * altura)

        val Mensagem = when {
            imc <= 18.5 -> "Peso Baixo"
            imc <= 24.9 -> "Peso normal"
            imc <= 29.9 -> "Sobre peso"
            imc <= 34.9 -> "obesidade (grau I)"
            imc <= 39.9 -> "obesidade (grau II)"
            else -> "Obesidade mórbida (grau III)"
        }

        resultado.setText("IMC: $imc \n $Mensagem")

    }
}

