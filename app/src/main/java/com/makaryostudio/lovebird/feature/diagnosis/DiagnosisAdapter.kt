package com.makaryostudio.lovebird.feature.diagnosis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.feature.hasil.HasilActivity
import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {

    private var mCheckedGejala: ArrayList<Gejala> = ArrayList()
    private var inputGejala : ArrayList<Int> = ArrayList()
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

        holder.mCbGejala.text = gejala.gejalaDialami.toString()
        holder.mCbGejala.isChecked = gejala.isChecked

        holder.mCbGejala.setOnClickListener {
            val intent = Intent(context, HasilActivity::class.java)

            if (!gejala.isChecked) {
                holder.mCbGejala.isChecked = true
                gejala.isChecked = true
                mCheckedGejala.add(gejala)
                inputGejala.add(gejala.kodeGejala)

            } else {
                holder.mCbGejala.isChecked = false
                gejala.isChecked = false
                mCheckedGejala.remove(gejala)
                inputGejala.remove(gejala.kodeGejala)
            }

            intent.putExtra("checked", mCheckedGejala)
            intent.putExtra("gejala", gejala)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCbGejala: CheckBox = itemView.findViewById(R.id.checkbox_gejala)
    }
}