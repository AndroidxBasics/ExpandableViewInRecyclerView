package com.example.mylynx.expandablerecyclerview

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.text.Layout
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import android.widget.TextView
import android.support.v4.view.ViewCompat.setActivated



/**
 * Created by mylynx on 22.02.18.
 */

class RecyclerAdapterWalks(private var mWalkList: ArrayList<Walk>, private var context: Context):
        RecyclerView.Adapter<RecyclerAdapterWalks.WalkCardViewHolder>() {

    private var mExpandedPosition = -1


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): WalkCardViewHolder{
        var view = LayoutInflater.from(context).inflate(R.layout.card_walk, parent, false)
        return WalkCardViewHolder(view)
    }

    override fun onBindViewHolder(holder: WalkCardViewHolder?, position: Int) {
        holder!!.bindView(mWalkList[position])
    //    handle expansion in list
        val isExpanded: Boolean = position == mExpandedPosition
        holder.itemView.setOnClickListener {
            mExpandedPosition = if (isExpanded) -1 else holder.adapterPosition
            notifyDataSetChanged()
        }
        holder.mExpansion.visibility = if (isExpanded) View.VISIBLE else View.GONE
        holder.itemView.isActivated = isExpanded



    }


    override fun getItemCount(): Int {
        return mWalkList.size
    }

    class WalkCardViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        var mWalkRoute = itemView.findViewById<TextView>(R.id.txt_walk_route);
        var mWalkDuration =  itemView.findViewById<TextView>(R.id.txt_walk_duration);
        var mWalkDate =  itemView.findViewById<TextView>(R.id.txt_walk_date);
        var mWalkWeekday =  itemView.findViewById<TextView>(R.id.txt_walk_weekday);
        var mExpansion =  itemView.findViewById<RelativeLayout>(R.id.walk_card_expansion);
        var mAverageTime =  itemView.findViewById<TextView>(R.id.txt_walk_average);

        fun bindView(walk: Walk) {
            mWalkDuration.text = walk.duration.toString()
            mWalkDate.text =  walk.date.toString()
            mWalkWeekday.text = "Monday"
            mWalkRoute.text = "Moja droga"
            mAverageTime.text = "1h"
        }
    }

}