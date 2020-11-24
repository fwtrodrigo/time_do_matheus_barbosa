package br.com.timedomatheus.entities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import br.com.timedomatheus.R
import com.squareup.picasso.Picasso

class ProdutoAdapter(private val listaProdutos: List<Produto>) :
    RecyclerView.Adapter<ProdutoAdapter.itemProduto>() {


    class itemProduto(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var ivProduto: ImageView = itemView.findViewById(R.id.ivProduto)
        var tvPreco: TextView = itemView.findViewById(R.id.tvPreco)
        var tvDescricao: TextView = itemView.findViewById(R.id.tvDescricao)
        var tvQuantidade: TextView = itemView.findViewById(R.id.tvQuantidade)
        var ivLogo: ImageView = itemView.findViewById(R.id.imageView1)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): itemProduto {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_produto, parent, false)
        return itemProduto(itemView)
    }

    override fun onBindViewHolder(holder: ProdutoAdapter.itemProduto, position: Int) {
        val produto = listaProdutos[position]

        Picasso.get().load("https://promoios.com.br/img/produtos/${produto.url}").into(holder.ivProduto)
        holder.tvPreco.text = produto.valor
        holder.tvDescricao.text = produto.nome_prod
        holder.tvQuantidade.text = produto.vol_prod
        Picasso.get().load("https://promoios.com.br/${produto.logo_emp}").into(holder.ivLogo)

    }

    override fun getItemCount() = listaProdutos.size
}
