package com.example.shoppinglist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.cardview.view.*

class Adapter(private val ItemList: List<ItemList>) : RecyclerView.Adapter<Adapter.ViewHolder>() {

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        val ItemName: TextView = v.ItemName
        val ItemPrice: TextView = v.ItemPrice
        val ItemQuantity: TextView = v.ItemQuantity
        val ItemDesc: TextView = v.ItemDescription
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.cardview, parent, false)

        return ViewHolder(v)
    }

    override fun getItemCount() = ItemList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = ItemList[position]

        holder.ItemName.text = currentItem.ItemName
        holder.ItemPrice.text = currentItem.ItemPrice
        holder.ItemQuantity.text = currentItem.ItemQuantity
        holder.ItemDesc.text = currentItem.ItemDescription
    }
}