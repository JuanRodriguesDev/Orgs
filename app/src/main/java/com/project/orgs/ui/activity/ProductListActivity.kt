package com.project.orgs.ui.activity

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.project.orgs.ListaProdutosAdapter
import com.project.orgs.R
import com.project.orgs.dao.ProdutosDao

import com.project.orgs.databinding.MainActivityBinding

class ProductListActivity: AppCompatActivity(R.layout.main_activity) {

    private val dao = ProdutosDao()
    private val adapter = ListaProdutosAdapter(context = this, produtos = dao.searchAll())

    private val binding by lazy {
        MainActivityBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        configRecyclerView()
        configFab()
    }

    override fun onResume() {
        super.onResume()
        adapter.atualiza(dao.searchAll())

    }

    private fun configFab() {
        val fab = binding.activityListBtnAdd
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
}