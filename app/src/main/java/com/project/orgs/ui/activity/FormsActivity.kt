package com.project.orgs.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import coil.load
import com.project.orgs.Produto
import com.project.orgs.R
import com.project.orgs.dao.ProdutosDao
import com.project.orgs.databinding.ActivityFormsBinding
import com.project.orgs.databinding.FormsImageBinding
import java.math.BigDecimal


class FormsActivity : AppCompatActivity(R.layout.activity_forms) {

    private val binding by lazy {
        ActivityFormsBinding.inflate(layoutInflater)
    }
    private var url: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configBtnSaveData()

        binding.activityFormsImage.setOnClickListener {
            val bindingFormsImage = FormsImageBinding.inflate(layoutInflater)
            bindingFormsImage.btnRefresh.setOnClickListener {
                val url = bindingFormsImage.formsImageUrl.text.toString()
                bindingFormsImage.formsImage.load(url)
            }
            AlertDialog.Builder(this)
                .setView(bindingFormsImage.root)
                .setPositiveButton("Confirmar") { _, _ ->
                   url = bindingFormsImage.formsImageUrl.text.toString()
                    binding.activityFormsImage.load(url)
                }
                .setNegativeButton("Cancelar"){ _, _ ->  }
                .show()
        }
    }

    private fun configBtnSaveData() {
        val btnSave = binding.acitivityFormsBtnSave
        val dao = ProdutosDao()
        btnSave.setOnClickListener {
            val newProduct = createProduct()
            dao.add(newProduct)
            finish()
        }
    }

    private fun createProduct(): Produto {
        val campoNome = binding.acitivityFormsName
        val nome = campoNome.text.toString()

        val campoDescricao = binding.acitivityFormsDescription
        val descricao = campoDescricao.text.toString()

        val campoValue = binding.acitivityFormsValue
        val textValue = campoValue.text.toString()

        val value = if (textValue.isBlank()) {
            BigDecimal.ZERO
        } else {
            BigDecimal(textValue)
        }

        return Produto(
            nome = nome,
            descricao = descricao,
            value = value,
            image = url
        )
    }
}

