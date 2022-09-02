package com.project.orgs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import java.math.BigDecimal
import java.text.NumberFormat
import java.util.*

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

    private val produtos = produtos.toMutableList()

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val view = inflater.inflate(R.layout.product_item, parent, false)

        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val produto = produtos[position]
        holder.vincula(produto)
    }

    override fun getItemCount(): Int = produtos.size

    fun atualiza(produtos: List<Produto>) {
        this.produtos.clear()
        this.produtos.addAll(produtos)
        notifyDataSetChanged()
    }



    private fun RecyclerView.ViewHolder.vincula(produto: Produto) {
        val name = itemView.findViewById<TextView>(R.id.product_item_name)
        name.text = produto.nome
        val description = itemView.findViewById<TextView>(R.id.product_item_descricao)
        description.text = produto.descricao
        val value = itemView.findViewById<TextView>(R.id.product_item_value)
        val formatador: NumberFormat = formatBRL()
        val valorEmMoeda: String = formatador.format(produto.value)
        value.text = valorEmMoeda
    }

    private fun formatBRL(): NumberFormat {
        val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
        return formatador
    }
}