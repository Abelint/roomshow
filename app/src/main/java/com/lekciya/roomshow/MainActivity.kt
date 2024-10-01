package com.lekciya.roomshow

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.lifecycle.lifecycleScope
import androidx.room.Room
import com.lekciya.roomshow.database.Item
import com.lekciya.roomshow.database.MainDB
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    lateinit var items : MutableList<Item>
    lateinit var adapter: CardAdapter
    lateinit var db : MainDB
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val name = findViewById<EditText>(R.id.et_name)
        val descr = findViewById<EditText>(R.id.et_description)
        val gmyak = findViewById<Button>(R.id.btn_add)
        val listView = findViewById<ListView>(R.id.lv_items)

        items = mutableListOf()
        db =  Room.databaseBuilder(
            this,
            MainDB::class.java,
            "firstdb"
        ).build()

        adapter = CardAdapter(this, items)
        Log.i("aaaaaaaa" , items.size.toString())
        listView.adapter = adapter
        adapter.notifyDataSetChanged()


        gmyak.setOnClickListener {
            val item = Item(null, name.text.toString(), descr.text.toString())

            CoroutineScope(Dispatchers.IO).launch {

                db.itemDao().insertItem(item)
                items.clear()

               // items = db.itemDao().getAllItems().toMutableList()
                val newlist = db.itemDao().getAllItems().toMutableList()
                items.addAll(newlist)
                Log.i("aaaaaaaa", items.toString())

            }
            adapter.notifyDataSetChanged()
        }
    }
}