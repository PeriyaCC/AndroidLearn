package com.cc.androidlearn

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_version.view.*

class VersionsAdapter : RecyclerView.Adapter<VersionsAdapter.VH>() {

    var versionListItems: ArrayList<String>? = null
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        VH(LayoutInflater.from(parent.context).inflate(R.layout.item_version, parent, false))

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(versionListItems?.get(position))
    }

    override fun getItemCount() = versionListItems?.size ?: 0

    class VH(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(data: String?) {
            with(itemView){
                tvTxt.text = data
            }
        }
    }
    
}