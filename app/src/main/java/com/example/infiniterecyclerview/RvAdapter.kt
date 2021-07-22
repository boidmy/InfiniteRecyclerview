package com.example.infiniterecyclerview

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.rv_item.view.*

class RvAdapter : RecyclerView.Adapter<ViewHolder>() {

    var itemList: List<DataClass> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindView(itemList[position%itemList.size])
    }

    override fun getItemCount(): Int {
        return itemList.size * 1000
    }

    fun setData(itemList: List<DataClass>) {
        this.itemList = itemList
        notifyDataSetChanged()
    }
}

class ViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
) {

    private val numberTxt = itemView.numberTxt
    fun bindView(item: DataClass) {
        numberTxt.text = item.number
    }
}