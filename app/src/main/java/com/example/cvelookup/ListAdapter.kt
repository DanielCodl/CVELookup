package com.example.cvelookup

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.cvelookup.database.CveDTO

class ListAdapter:RecyclerView.Adapter<ListAdapter.MyViewHolder>() {

    private var cveList = emptyList<CveDTO>()

    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)


        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
            return MyViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.custom_row, parent, false)
            )
        }

        override fun getItemCount(): Int {
            return cveList.size
        }

        override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
            val currentItem = cveList[position]
            holder.itemView.findViewById<TextView>(R.id.id_txt).text = currentItem.cveid
            holder.itemView.findViewById<TextView>(R.id.baseScore_txt).text =
                currentItem.baseScore.toString()
            holder.itemView.findViewById<TextView>(R.id.baseSeverity_txt).text =
                currentItem.baseSeverity
            holder.itemView.findViewById<TextView>(R.id.vectorString_txt).text =
                currentItem.vectorString
            holder.itemView.findViewById<TextView>(R.id.published_txt).text = currentItem.published
            holder.itemView.findViewById<TextView>(R.id.description_txt).text =
                currentItem.description
        }

        fun setData(cve: List<CveDTO>) {
            this.cveList = cve
            notifyDataSetChanged()
        }

}