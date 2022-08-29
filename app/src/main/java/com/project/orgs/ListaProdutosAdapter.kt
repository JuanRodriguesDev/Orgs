package com.project.orgs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListaProdutosAdapter(
    private val context: Context,
    private val produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {

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

}

private fun RecyclerView.ViewHolder.vincula(produto: Produto) {
    val name = itemView.findViewById<TextView>(R.id.name)
    name.text = produto.nome
    val description = itemView.findViewById<TextView>(R.id.descricao)
    description.text = produto.descricao
    val value = itemView.findViewById<TextView>(R.id.value)
    value.text = produto.value.toPlainString()
}
