package com.ttendo.todoapp

import android.annotation.SuppressLint
import android.content.Context
import android.media.Image
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MyAdapter(val context: Context,val list:ArrayList<ChatModel>):BaseAdapter() {
    //get number of elements in a  list
    override fun getCount(): Int {
        return list.size
    }

    //get single element from a list,p0 is the index
    override fun getItem(p0: Int): Any {
        return list[p0]
    }

    //get the id of element from a list
    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

    //get the ui and loads it on the list view
    @SuppressLint("MissingInflatedId")
    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        val view = LayoutInflater.from(context).inflate(R.layout.list_view_layout,null)

        val productName = view.findViewById<TextView>(R.id.product)
        val price = view.findViewById<TextView>(R.id.price)
        val addToCartBtn = view.findViewById<Button>(R.id.cart_button)
        val image = view.findViewById<ImageView>(R.id.icon)

        productName.text = list[p0].productName
        price.text = list[p0].price
        addToCartBtn.setId(list[p0].addToCartBtn)
        image.setImageResource(list[p0].image)

        return view;
    }
}