package com.example.infiniterecyclerview

import android.content.Context
import android.graphics.Rect
import android.view.View
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class HorizontalSpaceDecoration(private val rightMargin: Int, private val bottomMargin: Int
                                , private val context: Context) : RecyclerView.ItemDecoration(){
    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView,
                                state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.right = rightMargin
        outRect.bottom = bottomMargin
    }

    fun layoutManagerPercent(percent: Double) : LinearLayoutManager {
        return object : LinearLayoutManager(context, HORIZONTAL, false) {
            override fun checkLayoutParams(lp: RecyclerView.LayoutParams?): Boolean {
                lp?.width = (width * percent).toInt()
                return true
            }
        }
    }
}