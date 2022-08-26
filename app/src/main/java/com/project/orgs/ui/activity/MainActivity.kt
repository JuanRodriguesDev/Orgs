package com.project.orgs.ui.activity

import android.app.Activity
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.project.orgs.ListaProdutosAdapter
import com.project.orgs.Produto
import com.project.orgs.R
import java.math.BigDecimal

class MainActivity: AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.main_activity)

        val recyclerView = findViewById<RecyclerView>(R.id.recyclerView)
        recyclerView.adapter = ListaProdutosAdapter(context = this, produtos = listOf(
            Produto(nome = "Test",
                descricao = "test desc",
                value = BigDecimal("19.99")),
            Produto(nome = "Test 2",
                descricao = "test desc 2 ",
                value = BigDecimal("500.00")),
            Produto(nome = "Test 3",
                descricao = "test desc",
                value = BigDecimal("1202.00"))
        ))
//        recyclerView.layoutManager = LinearLayoutManager(this)
    }

}

//        val name = findViewById<TextView>(R.id.name)
//        name.text = ("cesta de fruta")
//        val description = findViewById<TextView>(R.id.description)
//        description.text = ("Laranja, Manga e Uva")
//        val value = findViewById<TextView>(R.id.value)
//        value.text = ("R$ 19,99")