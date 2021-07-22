package com.example.infiniterecyclerview

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val decoration =
            HorizontalSpaceDecoration(20, 0, this)

        val itemList: ArrayList<DataClass> = arrayListOf()
        itemList.add(DataClass("하나"))
        itemList.add(DataClass("둘"))
        itemList.add(DataClass("셋"))
        itemList.add(DataClass("넷"))
        itemList.add(DataClass("다섯"))
        itemList.add(DataClass("여섯"))
        val rvAdapter = RvAdapter()
        mainRv.apply {
            addItemDecoration(decoration)
            layoutManager = decoration.layoutManagerPercent(0.8)
            adapter = rvAdapter
            PagerSnapHelperCustom().attachToRecyclerView(this)
        }
        rvAdapter.setData(itemList)
        mainRv.scrollToPosition(itemList.size*500)
    }
}