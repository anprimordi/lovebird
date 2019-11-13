package com.makaryostudio.lovebird.feature.diagnosis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {

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
            .inflate(R.layout.item_gejala, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mListData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val gejala = mListData[position]

        holder.mCbGejala.text = gejala.gejalaDialami
        holder.mCbGejala.isChecked = gejala.checked

        if (holder.mCbGejala.isChecked) {
            val intent = Intent()
//            intent.putExtra("checked", holder.mCbGejala.isChecked)
            intent.putExtra("gejala", gejala)
            context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCbGejala: CheckBox = itemView.findViewById(R.id.checkbox_gejala)
    }
}