package com.project.orgs

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.load
import java.lang.System.load
import java.text.NumberFormat
import com.project.orgs.databinding.ProductItemBinding
import com.project.orgs.extensions.tryLoadImage
import java.util.*

class ListaProdutosAdapter(
    private val context: Context,
    produtos: List<Produto>
) : RecyclerView.Adapter<ListaProdutosAdapter.ViewHolder>() {


    private val produtos = produtos.toMutableList()

    class ViewHolder(private val binding: ProductItemBinding) : RecyclerView.ViewHolder(binding.root) {
        fun vincula(produto: Produto) {
            val name = binding.productItemName
                name.text = produto.nome
            val description =binding.productItemDescricao
            description.text = produto.descricao
            val value = binding.productItemValue
            val formatador: NumberFormat = formatBRL()
            val valorEmMoeda: String = formatador.format(produto.value)
            value.text = valorEmMoeda
            binding.imageView.tryLoadImage(produto.image)


        }
        private fun formatBRL(): NumberFormat {
            val formatador: NumberFormat = NumberFormat.getCurrencyInstance(Locale("pt", "br"))
            return formatador
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(context)
        val binding = ProductItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
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


}