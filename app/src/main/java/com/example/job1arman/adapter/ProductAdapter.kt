package com.example.job1arman.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.job1arman.Product
import com.example.job1arman.R

class ProductAdapter (private val product: List<Product>):RecyclerView.Adapter<ProductAdapter.ProductViewHolder>() {
    inner class ProductViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {

        val productImg = itemView.findViewById<ImageView>(R.id.productImage)
        val producName = itemView.findViewById<TextView>(R.id.nameTxt)
        val productPrice = itemView.findViewById<TextView>(R.id.productPrice)
        val productDescription = itemView.findViewById<TextView>(R.id.descriptionTxt)
        val productId = itemView.findViewById<TextView>(R.id.idTxt)


        fun bind(product: Product){
            producName.text = product.title
            productPrice.text = "$${product.price}"
            productDescription.text = product.description
            productId.text = product.id.toString()
            Glide.with(itemView).load(product.images[0])
                .into(productImg)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.product_list,parent,false)
        return ProductViewHolder(view)


    }

    override fun getItemCount(): Int {
        return product.size
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = product[position]
        holder.bind(product)

    }
}