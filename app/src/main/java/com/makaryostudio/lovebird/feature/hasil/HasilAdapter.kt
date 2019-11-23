package com.makaryostudio.lovebird.feature.hasil

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.model.Gejala

class HasilAdapter : RecyclerView.Adapter<HasilAdapter.ViewHolder>() {

    private var mListData: List<Gejala>

    init {
        mListData = ArrayList()
        notifyDataSetChanged()
    }

    //constructor mListData
    fun loadListData(mListData: List<Gejala>) {
        this.mListData = mListData
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_hasil, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gejala = mListData[position]

        holder.textGejalaDialami.text = gejala.gejalaDialami
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textGejalaDialami: TextView = itemView.findViewById(R.id.text_hasil_gejala)
    }
}