package com.makaryostudio.lovebird.feature.diagnosis

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.makaryostudio.lovebird.R
import com.makaryostudio.lovebird.feature.hasil.HasilActivity
import com.makaryostudio.lovebird.model.Gejala

class DiagnosisAdapter internal constructor(private val context: Context) :
    RecyclerView.Adapter<DiagnosisAdapter.ViewHolder>() {

    var mCheckedGejala: ArrayList<Gejala> = ArrayList()
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

    private val intent = Intent(context, HasilActivity::class.java)

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

        holder.imgGejala.setImageResource(gejala.imageGejala)
        holder.titleGejala.text = gejala.gejalaDialami
        holder.textGejala.text = gejala.deskripsiGejala
        holder.cbGejala.isChecked = gejala.isChecked

        holder.cbGejala.setOnClickListener {

            if (!gejala.isChecked) {
                holder.cbGejala.isChecked = true
                gejala.isChecked = true
                mCheckedGejala.add(gejala)
                inputGejala.add(gejala.kodeGejala)

                //cek output
                for (element in mCheckedGejala) {
                    println(element)
                }

            } else {
                holder.cbGejala.isChecked = false
                gejala.isChecked = false
                mCheckedGejala.remove(gejala)
                inputGejala.remove(gejala.kodeGejala)

                if (mCheckedGejala.isEmpty()) {
                    Toast.makeText(context, "Pilih gejala yang dialami", Toast.LENGTH_SHORT).show()
                }
            }

            intent.putParcelableArrayListExtra("checked", mCheckedGejala)
            intent.putExtra("gejala", gejala)
        }
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var cbGejala: CheckBox = itemView.findViewById(R.id.checkbox_item_gejala)
        var imgGejala: ImageView = itemView.findViewById(R.id.image_item_gejala)
        var titleGejala: TextView = itemView.findViewById(R.id.text_item_gejala_title)
        var textGejala: TextView = itemView.findViewById(R.id.text_item_gejala_description)
    }

    fun cbr() {
        val hs1: Float
        val hs2: Float
        val hs3: Float
        val hs4: Float
        val hs5: Float
        val hs6: Float
        val hs7: Float


        var tb1 = 0f
        var tb2 = 0f
        var tb3 = 0f
        var tb4 = 0f
        var tb5 = 0f
        var tb6 = 0f
        var tb7 = 0f


        var tbp1 = 0f
        var tbp2 = 0f
        var tbp3 = 0f
        var tbp4 = 0f
        var tbp5 = 0f
        var tbp6 = 0f
        var tbp7 = 0f


        var penyakit = ""
        var solusi = ""
        var pencegahan = ""

        var persentaseCbr = 0f
        var bobotMax = 0f

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
        if (hs1 > persentaseCbr) {
            persentaseCbr = hs1
            penyakit = "Cacingan"
            solusi =
                "Obat alami yang umum digunakan untuk mengobati cacingan pada semua burung yaitu kulit mangga, wortel, biji lamtaro, biji jeruju, kelapa, krokot, daun pepaya, daun jambu dan masih banyak lainnya. Cara menggunakan obat alami untuk burung terkena cacingan yaitu dengan direbus atau memberikannya secara langsung."
            pencegahan =
                "Jaga kebersihan kandang dan selalu menjaga kandang agar tetap terkena sinar matahari sehingga virus tidak berkembang biak."
            bobotMax = tb1
        } else if (hs1 == persentaseCbr) {
            if (bobotMax < tb1) {
                persentaseCbr = hs1
                penyakit = "Cacingan"
                solusi =
                    "Obat alami yang biasa digunakan untuk mengobati cacingan pada semua burung yaitu kulit mangga, wortel, biji lamtaro, biji jeruju, kelapa, krokot, daun pepaya, daun jambu dan masih banyak lainnya. Cara menggunakan obat alami untuk burung terkena cacingan yaitu dengan direbus atau memberikannya secara langsung."
                pencegahan =
                    "Jaga kebersihan kandang dan selalu menjaga kandang agar tetap terkena sinar matahari sehingga virus tidak berkembang biak."
                bobotMax = tb1
            }
        }

        if (hs2 > persentaseCbr) {
            persentaseCbr = hs2
            penyakit = "Kutu Burung"
            solusi = "Pakai rebusan daun sirih atau air cucian beras untuk memandikan burung"
            pencegahan =
                "Sering mandikan dan jemur burung agar burung bebas dari kutu burung"
            bobotMax = tb2
        } else if (hs2 == persentaseCbr) {
            if (bobotMax < tb2) {
                persentaseCbr = hs2
                penyakit = "Kutu Burung"
                solusi = "Pakai rebusan daun sirih atau air cucian beras untuk memandikan burung"
                pencegahan =
                    "Sering mandikan dan jemur burung agar burung bebas dari kutu burung"
                bobotMax = tb2
            }
        }

        if (hs3 > persentaseCbr) {
            persentaseCbr = hs3
            penyakit = "Snot (pilek)"
            solusi =
                "Tumbuhan kitoloid dapat dimanfaatkan untuk mengobati snot pada burung. \n1. Petik satu buah bunga dari tumbuhan kitoloid. \n2. Cuci bunga dan rendam dalam air gelas selama 5-10 menit. \n3. Teteskan air rendaman bunga kitoloid pada paruh burung lakukan 3 kali sehari."
            pencegahan =
                "Penyakit ini disebabkan oleh virus dan cara menanggulanginya adalah menjaga kebersihan kandang dan segera obati burung yang sedang sakit tersebut."
            bobotMax = tb3
        } else if (hs3 == persentaseCbr) {
            if (bobotMax < tb3) {
                persentaseCbr = hs3
                penyakit = "Snot (pilek)"
                solusi =
                    "Tumbuhan kitoloid dapat dimanfaatkan untuk mengobati snot pada burung. \n1. Petik satu buah bunga dari tumbuhan kitoloid. \n2. Cuci bunga dan rendam dalam air gelas selama 5-10 menit. \n3. Teteskan air rendaman bunga kitoloid pada paruh burung lakukan 3 kali sehari."
                pencegahan =
                    "Penyakit ini disebabkan oleh virus dan cara menanggulanginya adalah menjaga kebersihan kandang dan segera obati burung yang sedang sakit tersebut."
                bobotMax = tb3
            }
        }

        if (hs4 > persentaseCbr) {
            persentaseCbr = hs4
            penyakit = "Berak Kapur"
            solusi =
                "Bersihkan tempat kotor tersebut menggunakan bioseptik. Jika burung sudah terinfeksi pisahkan dengan burung yang lain."
            pencegahan =
                "Sering membersihkan kandang, tempat makan dan minum."
            bobotMax = tb4
        } else if (hs4 == persentaseCbr) {
            if (bobotMax < tb4) {
                persentaseCbr = hs4
                penyakit = "Berak Kapur"
                solusi =
                    "Bersihkan tempat kotor tersebut menggunakan bioseptik. Jika burung sudah terinfeksi pisahkan dengan burung yang lain."
                pencegahan =
                    "Sering membersihkan kandang, tempat makan dan minum."
                bobotMax = tb4
            }
        }

        if (hs5 > persentaseCbr) {
            persentaseCbr = hs5
            penyakit = "Mencret Bakteri"
            solusi =
                "Air rebusan kulit buah naga dapat mengobati mencret pada burung. \n1. Rebus kulit buah naga \n2. Saring setelah mendidih dan berubah menjadi merah \n3. Berikan ramuan kepada burung sebagai air minum."
            pencegahan =
                "Penyakit ini diakibatkan tempat makan dan minum burung yang kotor sehingga cacing dapat berkembang biak. Jaga kebersihan tempat makan dan minum burung."
            bobotMax = tb5
        } else if (hs5 == persentaseCbr) {
            if (bobotMax < tb5) {
                persentaseCbr = hs5
                penyakit = "Mencret Bakteri"
                solusi =
                    "Air rebusan kulit buah naga dapat mengobati mencret pada burung. \n1. Rebus kulit buah naga \n2. Saring setelah mendidih dan berubah menjadi merah \n3. Berikan ramuan kepada burung sebagai air minum."
                pencegahan =
                    "Penyakit ini diakibatkan tempat makan dan minum burung yang kotor sehingga cacing dapat berkembang biak. Jaga kebersihan tempat makan dan minum burung."
                bobotMax = tb5
            }
        }

        if (hs6 > persentaseCbr) {
            persentaseCbr = hs6
            penyakit = "Bubul"
            solusi =
                "Bersihkan kaki burung yang terkena bubul dengan air. Lalu beri obat anti jamur seperti contoh betason N dll.Biarkan hingga 2 hari dan jangan dimandikan . setelah 2 hari cuci kaki burung dengan air hangat."
            pencegahan =
                "Penyakit ini disebabkan oleh bakteri. Bersihkan kandang secara rutin."
            bobotMax = tb6
        } else if (hs6 == persentaseCbr) {
            if (bobotMax < tb6) {
                persentaseCbr = hs6
                penyakit = "Bubul"
                solusi =
                    "Bersihkan kaki burung yang terkena bubul dengan air. Lalu beri obat anti jamur seperti contoh betason N dll.Biarkan hingga 2 hari dan jangan dimandikan . setelah 2 hari cuci kaki burung dengan air hangat."
                pencegahan =
                    "Penyakit ini disebabkan oleh bakteri. Bersihkan kandang secara rutin."
                bobotMax = tb6
            }
        }

        if (hs7 > persentaseCbr) {
            persentaseCbr = hs7
            penyakit = "Virus Burung"
            solusi =
                "Berikan obat antibiotik khusus untuk burung seperti Bionic+"
            pencegahan =
                "Virus ini menyerang daya tahan tubuh burung. Jaga kebersihan kandang serta menjaga kandang agar tetap terkena sinar matahari sehingga virus sulit berkembang biak."
        } else if (hs7 == persentaseCbr) {
            if (bobotMax < tb7) {
                persentaseCbr = hs7
                penyakit = "Virus Burung"
            }
        }

        println("Diagnosis Penyakit : $penyakit")
        println("Persentase CBR : $persentaseCbr")

        intent.putExtra("penyakit", penyakit)
        intent.putExtra("solusi", solusi)
        intent.putExtra("pencegahan", pencegahan)
        intent.putExtra("persentaseCBR", persentaseCbr.toString())

        context.startActivity(intent)
    }
}