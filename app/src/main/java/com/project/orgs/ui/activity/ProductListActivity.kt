package com.project.orgs.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.orgs.ListaProdutosAdapter
import com.project.orgs.R
import com.project.orgs.dao.ProdutosDao

class ProductListActivity: AppCompatActivity(R.layout.main_activity) {
    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.searchAll())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        configRecyclerView()
        configFab()
        alertAction()

    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.searchAll())

    }

    private fun configFab() {
        val fab = findViewById<FloatingActionButton>(R.id.activity_list_btnAdd)
        fab.setOnClickListener {
            formProduct()
        }
    }

    private fun formProduct() {
        val intent = Intent(this, FormsActivity::class.java)
        startActivity(intent)
    }

    private fun configRecyclerView() {
        val recyclerView = findViewById<RecyclerView>(R.id.activity_list_recyclerView)
        recyclerView.adapter = adapter
    }

    private fun alertAction() {
        AlertDialog.Builder(this)
            .setTitle("Test Title")
            .setMessage("Test message")
            .setPositiveButton("Confirmar") { _, _ ->  }

            .setNegativeButton("Cancelar"){ _, _ ->  }
            .show()
    }

}