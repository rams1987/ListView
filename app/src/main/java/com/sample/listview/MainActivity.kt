package com.sample.listview
//https://demonuts.com/android-listview-kotlin/
//https://www.stechies.com/add-sound-play-button-click/

import android.media.MediaPlayer
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.ListView
import android.widget.Toast
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private var lv: ListView? = null
    private var customAdapter: CustomAdapter? = null
    private var imageModelArrayList: ArrayList<ImageModel>? = null
    private val myImageList = intArrayOf(R.drawable.benz, R.drawable.bike, R.drawable.car, R.drawable.carrera, R.drawable.ferrari, R.drawable.harly, R.drawable.lamborghini, R.drawable.silver)
    private val myImageNameList = arrayOf("Benz", "Bike", "Car", "Carrera", "Ferrari", "Harly", "Lamborghini", "Silver")

    // Why are we using ? in kotlin.
    private var mediaPlayer: MediaPlayer? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        lv = findViewById(R.id.listView) as ListView

        imageModelArrayList = populateList()
        Log.d("hjhjh", imageModelArrayList!!.size.toString() + "")
        customAdapter = CustomAdapter(this, imageModelArrayList!!)
        lv!!.adapter = customAdapter

        lv!!.onItemClickListener = AdapterView.OnItemClickListener { adapterView, view, position, id ->
            Toast.makeText(this, "Click on " + imageModelArrayList!![position], Toast.LENGTH_SHORT).show()
            mediaPlayer = MediaPlayer.create(this, R.raw.lion)
            mediaPlayer!!.start()

        }

    }

    private fun populateList(): ArrayList<ImageModel> {

        val list = ArrayList<ImageModel>()

        for (i in 0..7) {
            val imageModel = ImageModel()
            imageModel.setNames(myImageNameList[i])
            imageModel.setImage_drawables(myImageList[i])
            list.add(imageModel)
        }

        return list
    }


}