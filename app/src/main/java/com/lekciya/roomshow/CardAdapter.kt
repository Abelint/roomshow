package com.lekciya.roomshow

import android.content.Context
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.lekciya.roomshow.database.Item

class CardAdapter(private val context: Context, private val list: List<Item>) : BaseAdapter() {
    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var view = convertView

        view = View.inflate(context,R.layout.card, parent)

        val tv1 = view.findViewById<TextView>(R.id.textView)
        val tv2 = view.findViewById<TextView>(R.id.textView2)

        val current = list[position]

        tv1.text = current.name
        tv2.text = current.description


        return view


    }

}