package com.makaryostudio.lovebird.feature.diagnosis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.EditText
import androidx.core.content.ContextCompat.startActivities
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.feature.hasil.HasilActivity
import com.makaryostudio.lovebird.repository.model.Gejala

class DiagnosisAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {

    private var mCheckedGejala: ArrayList<Gejala> = ArrayList()
    private var inputGejala: ArrayList<Int> = ArrayList()

    //Array Penyakit
    private var cacingan: ArrayList<Int> = arrayListOf(0, 1, 2, 3, 4)
    private var kutuBurung: ArrayList<Int> = arrayListOf(0, 4, 5, 6, 9)
    private var snot: ArrayList<Int> = arrayListOf(0, 7, 8, 11, 12)
    private var berakKapur: ArrayList<Int> = arrayListOf(0, 1, 10, 17)
    private var mencretBakteri: ArrayList<Int> = arrayListOf(0, 1, 2)
    private var bubul: ArrayList<Int> = arrayListOf(13, 14)
    private var virusBurung: ArrayList<Int> = arrayListOf(15, 16)

    private var mListData: List<Gejala>
    //private lateinit var textNamaBurung: EditText

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
        holder.mCbGejala.isChecked = gejala.isChecked

        holder.mCbGejala.setOnClickListener {
            val intent = Intent(context, HasilActivity::class.java)

            if (!gejala.isChecked) {
                holder.mCbGejala.isChecked = true
                gejala.isChecked = true
                mCheckedGejala.add(gejala)
                inputGejala.add(gejala.kodeGejala)

                //cek output
                for (element in mCheckedGejala) {
                    println(element)
                }

            } else {
                holder.mCbGejala.isChecked = false
                gejala.isChecked = false
                mCheckedGejala.remove(gejala)
                inputGejala.remove(gejala.kodeGejala)
            }

            intent.putExtra("checked", mCheckedGejala)
            intent.putExtra("gejala", gejala)
           // context.startActivity(intent)
        }
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var mCbGejala: CheckBox = itemView.findViewById(R.id.checkbox_gejala)
    }

    fun cbr() {
        var hs1: Float = 0f
        var hs2: Float = 0f
        var hs3: Float = 0f
        var hs4: Float = 0f
        var hs5: Float = 0f
        var hs6: Float = 0f
        var hs7: Float = 0f


        var tb1: Float = 0f
        var tb2: Float = 0f
        var tb3: Float = 0f
        var tb4: Float = 0f
        var tb5: Float = 0f
        var tb6: Float = 0f
        var tb7: Float = 0f


        var tbp1: Float = 0f
        var tbp2: Float = 0f
        var tbp3: Float = 0f
        var tbp4: Float = 0f
        var tbp5: Float = 0f
        var tbp6: Float = 0f
        var tbp7: Float = 0f


        var Penyakit: String = ""
        var persentaseCBR: Float = 0f
        var bobotMax: Float = 0f

        //Penyakit 1

        for (i in 0 until cacingan.size) {

            //total bobot
            tbp1 += mListData[cacingan[i]].bobot
            for (j in 0 until inputGejala.size) {

                if (cacingan[i] == inputGejala[j]) {
                    tb1 += mListData[cacingan[i]].bobot

                }
            }
        }

        //Penyakit 2
        for (i in 0 until kutuBurung.size) {

            //total bobot
            tbp2 += mListData[kutuBurung[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (kutuBurung[i] == inputGejala[j]) {
                    tb2 += mListData[kutuBurung[i]].bobot

                }
            }
        }


        //Penyakit 3
        for (i in 0 until snot.size) {

            //total bobot
            tbp3 += mListData[snot[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (snot[i] == inputGejala[j]) {
                    tb3 += mListData[snot[i]].bobot

                }
            }
        }


        //Penyakit 4
        for (i in 0 until berakKapur.size) {

            //total bobot
            tbp4 += mListData[berakKapur[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (berakKapur[i] == inputGejala[j]) {
                    tb4 += mListData[berakKapur[i]].bobot

                }
            }
        }

        //Penyakit 5
        for (i in 0 until mencretBakteri.size) {

            //total bobot
            tbp5 += mListData[mencretBakteri[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (mencretBakteri[i] == inputGejala[j]) {
                    tb5 += mListData[mencretBakteri[i]].bobot
                }
            }
        }


        //Penyakit 6
        for (i in 0 until bubul.size) {

            //total bobot
            tbp6 += mListData[bubul[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (bubul[i] == inputGejala[j]) {
                    tb6 += mListData[bubul[i]].bobot
                }
            }
        }


        //Penyakit 7
        for (i in 0 until virusBurung.size) {

            //total bobot
            tbp7 += mListData[virusBurung[i]].bobot
            for (j in 0 until inputGejala.size) {
                if (virusBurung[i] == inputGejala[j]) {
                    tb7 += mListData[virusBurung[i]].bobot

                }
            }
        }

        hs1 = (tb1 / tbp1) * 100
        hs2 = (tb2 / tbp2) * 100
        hs3 = (tb3 / tbp3) * 100
        hs4 = (tb4 / tbp4) * 100
        hs5 = (tb5 / tbp5) * 100
        hs6 = (tb6 / tbp7) * 100
        hs7 = (tb7 / tbp7) * 100
        println("Hasil : $hs1")
        println("TB : $tb1")
        println("TBP : $tbp1")
        println("Hasil : $hs2")
        println("TB : $tb2")
        println("TBP : $tbp2")
        println("Hasil : $hs3")
        println("TB : $tb3")
        println("TBP : $tbp3")
        println("Hasil : $hs4")
        println("TB : $tb4")
        println("TBP : $tbp4")
        println("Hasil : $hs5")
        println("TB : $tb5")
        println("TBP : $tbp5")
        println("Hasil : $hs6")
        println("TB : $tb6")
        println("TBP : $tbp6")
        println("Hasil : $hs7")
        println("TB : $tb7")
        println("TBP : $tbp7")

        //Searching paling besar
        if (hs1 > persentaseCBR) {
            persentaseCBR = hs1
            Penyakit = "Cacingan"
            bobotMax = tb1
        } else if (hs1 == persentaseCBR) {
            if (bobotMax < tb1) {
                persentaseCBR = hs1
                Penyakit = "Cacingan"
                bobotMax = tb1
            }
        }

        if (hs2 > persentaseCBR) {
            persentaseCBR = hs2
            Penyakit = "Kutu Burung"
            bobotMax = tb2
        } else if (hs2 == persentaseCBR) {
            if (bobotMax < tb2) {
                persentaseCBR = hs2
                Penyakit = "Kutu Burung"
                bobotMax = tb2
            }
        }

        if (hs3 > persentaseCBR) {
            persentaseCBR = hs3
            Penyakit = "Snot"
            bobotMax = tb3
        } else if (hs3 == persentaseCBR) {
            if (bobotMax < tb3) {
                persentaseCBR = hs3
                Penyakit = "Snot"
                bobotMax = tb3
            }
        }

        if (hs4 > persentaseCBR) {
            persentaseCBR = hs4
            Penyakit = "Berak Kapur"
            bobotMax = tb4
        } else if (hs4 == persentaseCBR) {
            if (bobotMax < tb4) {
                persentaseCBR = hs4
                Penyakit = "Berak Kapur"
                bobotMax = tb4
            }
        }

        if (hs5 > persentaseCBR) {
            persentaseCBR = hs5
            Penyakit = "Mencret Bakteri"
            bobotMax = tb5
        } else if (hs5 == persentaseCBR) {
            if (bobotMax < tb5) {
                persentaseCBR = hs5
                Penyakit = "Mencret Bakteri"
                bobotMax = tb5
            }
        }

        if (hs6 > persentaseCBR) {
            persentaseCBR = hs6
            Penyakit = "Bubul"
            bobotMax = tb6
        } else if (hs6 == persentaseCBR) {
            if (bobotMax < tb6) {
                persentaseCBR = hs6
                Penyakit = "Bubul"
                bobotMax = tb6
            }
        }

        if (hs7 > persentaseCBR) {
            persentaseCBR = hs7
            Penyakit = "Virus Burung"
            bobotMax = tb7
        } else if (hs7 == persentaseCBR) {
            if (bobotMax < tb7) {
                persentaseCBR = hs7
                Penyakit = "Virus Burung"
                bobotMax = tb7
            }
        }

        println("Diagnosa Penyakit : " + Penyakit)
        println("Persentase CBR : " + persentaseCBR)


        val intents = Intent(context, HasilActivity::class.java)
        intents.putExtra("penyakit", Penyakit)
        intents.putExtra("persentaseCBR", persentaseCBR.toString() )

        //startActivity(intents)

        context.startActivity(intents)
    }
}