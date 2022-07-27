package com.example.simpletodoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.add)
        val delete = findViewById<Button>(R.id.delete)
        val clear = findViewById<Button>(R.id.clear)

        val editText = findViewById<EditText>(R.id.editText)
        val listView = findViewById<ListView>(R.id.listView)

        var itemList = arrayListOf<String>()
        var adapter = ArrayAdapter<String>(
            this,
            android.R.layout.simple_list_item_multiple_choice,
            itemList
        )

        add.setOnClickListener {
            itemList.add(editText.text.toString())
            listView.adapter =  adapter
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }

        delete.setOnClickListener {
            val position: SparseBooleanArray = listView.checkedItemPositions
            val count = listView.count
            var item = count - 1

            while (item >= 0) {
                if (position[item]) {
                    adapter.remove(itemList[item])
                }
                item--
            }
            position.clear()
            adapter.notifyDataSetChanged()
        }

        clear.setOnClickListener {
            itemList.clear()
            adapter.notifyDataSetChanged()
        }

        listView.setOnItemClickListener { adapterView, view, i, l ->
            val position: SparseBooleanArray = listView.checkedItemPositions
            android.widget.Toast.makeText(
                this,
                "You ${if (position[i]) "checked" else "unchecked"} the item -> " + itemList[i],
                android.widget.Toast.LENGTH_SHORT
            ).show()
        }

    }
}