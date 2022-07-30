package com.example.simpletodoapp

import CustomAdapter
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.SparseBooleanArray
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.EditText
import android.widget.ListView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val add = findViewById<Button>(R.id.add)
//        val delete = findViewById<Button>(R.id.delete)
        val clear = findViewById<Button>(R.id.clear)

        val editText = findViewById<EditText>(R.id.editText)

        // getting the recyclerview by its id
        val recyclerview = findViewById<RecyclerView>(R.id.recyclerview)

        // this creates a vertical layout Manager
        recyclerview.layoutManager = LinearLayoutManager(this)

        // ArrayList of class ListViewModel
        val data = ArrayList<ListViewModel>()

        val adapter = CustomAdapter(data)
        recyclerview.adapter = adapter

        add.setOnClickListener {
            data.add(
                ListViewModel(
                    R.drawable.ic_baseline_add_24,
                    editText.text.toString()
                )
            )
            adapter.notifyDataSetChanged()
            editText.text.clear()
        }

//        delete.setOnClickListener {
//            val position: SparseBooleanArray = listView.checkedItemPositions
//            val count = listView.count
//            var item = count - 1
//
//            while (item >= 0) {
//                if (position[item]) {
//                    adapter.remove(itemList[item])
//                }
//                item--
//            }
//            position.clear()
//            adapter.notifyDataSetChanged()
//        }
//

        clear.setOnClickListener {
            data.clear()
            adapter.notifyDataSetChanged()
        }

//        listView.setOnItemClickListener { adapterView, view, i, l ->
//            val position: SparseBooleanArray = listView.checkedItemPositions
//            android.widget.Toast.makeText(
//                this,
//                "You ${if (position[i]) "checked" else "unchecked"} the item -> " + itemList[i],
//                android.widget.Toast.LENGTH_SHORT
//            ).show()
//        }
    }
}