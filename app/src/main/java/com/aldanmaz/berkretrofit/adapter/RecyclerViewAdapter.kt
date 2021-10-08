package com.aldanmaz.berkretrofit.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aldanmaz.berkretrofit.R
import com.aldanmaz.berkretrofit.model.CryptoModel
import kotlinx.android.synthetic.main.row_layout.view.*


class RecyclerViewAdapter(private val cryptoList : ArrayList<CryptoModel>, private val listener : Listener) : RecyclerView.Adapter<RecyclerViewAdapter.RowHolder>() {

    interface Listener {
        fun onItemClick(cryptoModel: CryptoModel)
    }

    private val colors : Array<String> = arrayOf("#FBAD00","#9192aa","#acbbfe","#56bc8a","#a1bcd0","#dabf86","#99a893","#d7d6d6")

    class RowHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(cryptoModel: CryptoModel, colors: Array<String>, position:Int, listener : Listener ) {
           itemView.setOnClickListener {
               listener.onItemClick((cryptoModel))
           }
            itemView.setBackgroundColor(Color.parseColor(colors[position % 8]))
            itemView.text_name.text = cryptoModel.currency
            itemView.text_price.text = cryptoModel.price
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RowHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.row_layout,parent,false)
        return RowHolder(view)

    }

    override fun getItemCount(): Int {
     return cryptoList.size

    }

    override fun onBindViewHolder(holder: RowHolder, position: Int) {
        holder.bind(cryptoList[position],colors,position,listener)
    }


}