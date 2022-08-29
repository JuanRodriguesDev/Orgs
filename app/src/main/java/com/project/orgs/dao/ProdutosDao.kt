package com.project.orgs.dao

import com.project.orgs.Produto

class ProdutosDao {

    fun add(produto: Produto){
        produtos.add(produto)
    }

    fun searchAll() : List<Produto> {
        return Companion.produtos.toList()

    }

    companion object {
        private val produtos = mutableListOf<Produto>()
    }

}