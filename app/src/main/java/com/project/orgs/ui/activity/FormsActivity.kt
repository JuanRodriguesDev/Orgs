package com.project.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import com.project.orgs.Produto
import com.project.orgs.R
import java.math.BigDecimal


class FormsActivity : AppCompatActivity(R.layout.activity_forms) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val btnSave = findViewById<Button>(R.id.btnSave)
        btnSave.setOnClickListener {
            val campoNome = findViewById<EditText>(R.id.nome)
            val nome = campoNome.text.toString()
           val campoDescricao = findViewById<EditText>(R.id.descricao)
            val descricao = campoDescricao.text.toString()
            val campoValue = findViewById<EditText>(R.id.value)
            val textValue = campoValue.text.toString()
            val value = if(textValue.isBlank()) {
                BigDecimal.ZERO
            }else{
                BigDecimal(textValue)
            }

           val newProduct = Produto(
                nome = nome,
                descricao = descricao,
                value = value
            )

            Log.i("FormsActivity", "$newProduct")
        }
    }
}

