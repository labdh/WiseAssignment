package com.example.wiseassignment.presentation.adapters


import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.wiseassignment.R
import com.example.wiseassignment.data.remote.dto.Drink
import com.example.wiseassignment.databinding.ProductItemBinding
import com.example.wiseassignment.presentation.drinkdetail.activities.ProductDetails

class ProductAdapter(var data: ArrayList<Drink>) :
    RecyclerView.Adapter<ProductAdapter.productViewholder>() {

    fun setSearchList(dataSearchList: ArrayList<Drink>) {
        data = dataSearchList
        notifyDataSetChanged()
    }


    class productViewholder(val productitemBinding: ProductItemBinding) : RecyclerView.ViewHolder(productitemBinding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= productViewholder(
             DataBindingUtil.inflate(
                 LayoutInflater.from(parent.context),
                 R.layout.product_item,
                 parent,false
             )
         )


    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: productViewholder, position: Int) {
        holder.productitemBinding.drink = data[position]
        holder.productitemBinding.viewDetail.setOnClickListener {
            val intent = Intent(it.context,ProductDetails::class.java)
            intent.putExtra("strname",data[position].strDrink)
            it.context.startActivity(intent)
        }
    }
}