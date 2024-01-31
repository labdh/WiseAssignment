package com.example.wiseassignment.presentation.adapters

import android.content.Context
import android.content.Intent
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wiseassignment.R
import com.example.wiseassignment.data.remote.Drink
import com.example.wiseassignment.data.remote.Drinkdto
import com.example.wiseassignment.data.remote.toingredient
import com.example.wiseassignment.data.remote.toinstruction
import com.example.wiseassignment.data.remote.tomeasures
import com.example.wiseassignment.domain.model.ingredient
import com.example.wiseassignment.domain.model.instruction
import com.example.wiseassignment.domain.model.measure
import com.example.wiseassignment.domain.model.product
import com.example.wiseassignment.presentation.drinkdetail.activities.ProductDetails

class ProductAdapter(val context : Context, var data: ArrayList<Drink>) :
    RecyclerView.Adapter<ProductAdapter.productViewholder>() {

    fun setSearchList(dataSearchList: ArrayList<Drink>) {
        data = dataSearchList
        notifyDataSetChanged()
    }


    class productViewholder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var img = itemView.findViewById<ImageView>(R.id.product_image)
        var name = itemView.findViewById<TextView>(R.id.product_name)
        var category = itemView.findViewById<TextView>(R.id.product_category)
        var details = itemView.findViewById<TextView>(R.id.view_detail)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): productViewholder {
        val view : View = LayoutInflater.from(context).inflate(R.layout.product_item,parent,false)
        return productViewholder(view)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    override fun onBindViewHolder(holder: productViewholder, position: Int) {
        val drink: Drink = data[position]
        holder.name.text = drink.strDrink
        holder.category.text = drink.strCategory
        if(drink.strDrinkThumb!=null) Glide.with(context).load(drink.strDrinkThumb).into(holder.img)

        var measure : ArrayList<String> = arrayListOf()
        var ingredient : ArrayList<String> = arrayListOf()
        var instruction : ArrayList<String> = arrayListOf()

        holder.details.setOnClickListener {

            getdata(drink , measure,ingredient,instruction)
            Log.e("Instruction",instruction.toString())
        val intent = Intent(context,ProductDetails::class.java)
        intent.putExtra("strname",drink.strDrink)
        intent.putExtra("strcategory",drink.strCategory)
        intent.putExtra("strthumb",drink.strDrinkThumb)
        intent.putExtra("measure",measure)
        intent.putExtra("ingredient",ingredient)
        intent.putExtra("instruction",instruction)
        context.startActivity(intent)
      }
    }
    fun getdata(drink:Drink,measure: ArrayList<String>,ingredient: ArrayList<String>,instruction: ArrayList<String>){
        for(m in drink.tomeasures().arrayList){
            if(m!=null) measure.add(m.toString())
        }
        for(m in drink.toingredient().arrayList){
            if(m!=null) ingredient.add(m.toString())
        }
        for(m in drink.toinstruction().arrayList){
            if(m!=null) instruction.add(m.toString())
        }
    }
}