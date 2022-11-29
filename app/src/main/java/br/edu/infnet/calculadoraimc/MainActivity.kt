package br.edu.infnet.calculadoraimc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val infoTxt = findViewById<TextView>(R.id.infoTxt)
        infoTxt.visibility = View.INVISIBLE

        val pesoEt = findViewById<EditText>(R.id.pesoEt)

        val alturaEt = findViewById<EditText>(R.id.alturaEt)

        val btnCalcular = findViewById<Button>(R.id.btnCalcular)
        btnCalcular.setOnClickListener{

            var peso:Double = pesoEt.text.toString().toDouble()
            var altura:Double = alturaEt.text.toString().toDouble()

            var imc:Double = (peso) / (altura*altura)

            infoTxt.visibility = View.VISIBLE
            infoTxt.text = "O seu IMC é ${String.format("%.2f",imc)} e você está com ${imcResultado(imc)}"
        }
    }

    fun imcResultado(imc:Double):String{
         var resposta =""
        if(imc<16){
            resposta = "Magreza grave"
        } else if (imc > 16 && imc <17){
            resposta = "Magreza moderada"
        }else if (imc > 17 && imc <18.5){
            resposta = "Magreza leve"
        }else if (imc > 18.5 && imc <25){
            resposta = "Saudável"
        }else if (imc > 25 && imc <30){
            resposta = "Sobrepeso"
        }else if (imc > 30 && imc <35){
            resposta = "Obesidade Grau I"
        }else if (imc > 35 && imc <40){
            resposta = "Obesidade Grau II (severa)"
        }else{
            resposta = "Obesidade Grau III (mórbida)"
        }
        return resposta

    }
}