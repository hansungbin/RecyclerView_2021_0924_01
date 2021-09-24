package com.example.recyclerview_2021_0924_01

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.recyclerview_2021_0924_01.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding : ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view =binding.root
        setContentView(view)

        // Set the LayoutManager that this RecyclerView will use.
        binding.recyclerViewItems.layoutManager = LinearLayoutManager(this)

        // Adapter class is initialized and list is passed in the param.
        val itemAdapter = ItemAdapter(this, getItemsList())

        // adapter instance is set to the recyclerview to inflate the items.
        binding.recyclerViewItems.adapter = itemAdapter
    }

    /**
     * Function is used to get the Items List which is added in the list.
     */
//    private fun getItemsList(): ArrayList<String> {
//        val list = ArrayList<String>()
//
//        for (i in 1..15) {
//            list.add("Item $i")
//        }
//
//        return list
//    }

    private fun getItemsList(): ArrayList<DataModel> {
        val list = ArrayList<DataModel>()

        list.add(DataModel("Item 1 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 2 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item 3 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 4 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item 5 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 6 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 7 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item 8 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 9 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item 10 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))
        list.add(DataModel("Item 11 ViewType 1", ItemAdapter.VIEW_TYPE_ONE))
        list.add(DataModel("Item 12 ViewType 2", ItemAdapter.VIEW_TYPE_TWO))

        return list
    }
}