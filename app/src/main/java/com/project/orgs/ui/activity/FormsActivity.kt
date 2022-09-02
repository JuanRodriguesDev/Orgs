package com.project.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import com.project.orgs.Produto
import com.project.orgs.R
import com.project.orgs.dao.ProdutosDao
import java.math.BigDecimal


class FormsActivity : AppCompatActivity(R.layout.activity_forms) {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configBtnSaveData()
        alertAction()
    }

    private fun configBtnSaveData() {
        val btnSave = findViewById<Button>(R.id.acitivity_forms_btnSave)
        val dao = ProdutosDao()
        btnSave.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Produto {
        val campoNome = findViewById<EditText>(R.id.acitivity_forms_name)
        val nome = campoNome.text.toString()

        val campoDescricao = findViewById<EditText>(R.id.acitivity_forms_description)
        val descricao = campoDescricao.text.toString()

        val campoValue = findViewById<EditText>(R.id.acitivity_forms_value)
        val textValue = campoValue.text.toString()

        val value = if (textValue.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(textValue)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            value = value
        )
    }
    private fun alertAction() {
        AlertDialog.Builder(this)
            .setView(R.layout.forms_image)
            .setPositiveButton("Confirmar") { _, _ ->  }

            .setNegativeButton("Cancelar"){ _, _ ->  }
            .show()
    }

}

