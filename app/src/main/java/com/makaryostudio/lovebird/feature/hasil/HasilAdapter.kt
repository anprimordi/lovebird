package com.makaryostudio.lovebird.feature.hasil

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.repository.model.Gejala
import com.makaryostudio.lovebird.repository.model.Penyakit
import kotlinx.android.synthetic.main.item_hasil.view.*

class HasilAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<HasilAdapter.ViewHolder>() {

    private var mListData: List<Penyakit>

    init {
        mListData = ArrayList()
        notifyDataSetChanged()
    }

    //constructor mListData
    fun loadListData(mListData: List<Penyakit>) {
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
        val penyakit = mListData[position]

//        val gejala = Intent()
//        gejala.getParcelableExtra<Gejala>("gejala")
        holder.textGejalaDialami.text = penyakit.gejalaDialami
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var textGejalaDialami: TextView = itemView.findViewById(R.id.text_hasil_gejala)
    }
}