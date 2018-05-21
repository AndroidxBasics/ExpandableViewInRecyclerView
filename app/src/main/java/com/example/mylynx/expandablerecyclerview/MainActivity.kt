package com.example.mylynx.expandablerecyclerview

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*
import com.google.common.collect.Lists.newArrayList

class MainActivity : AppCompatActivity() {

    var adapter: RecyclerAdapterWalks? = null
    var walksList: ArrayList<Walk>? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        walksList = newArrayList(

                Walk(10, 30),
                Walk(40, 50),
                Walk(50, 50)

        )

        adapter = RecyclerAdapterWalks(walksList!!, this)
        layoutManager = LinearLayoutManager(this)

        recyclerViewId.adapter = adapter
        recyclerViewId.layoutManager = layoutManager

    }
}
