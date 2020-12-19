package com.coxtunes.carouselmenu

import `in`.goodiebag.carouselpicker.CarouselPicker
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager.OnPageChangeListener


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val carouselPicker1 = findViewById<View>(R.id.carousel1) as CarouselPicker
        val carouselPicker2 = findViewById<View>(R.id.carousel2) as CarouselPicker
        val carouselPicker3 = findViewById<View>(R.id.carousel3) as CarouselPicker


        // Case 1 : To populate the picker with images
        val imageItems: MutableList<CarouselPicker.PickerItem> = ArrayList()
        imageItems.add(CarouselPicker.DrawableItem(R.drawable.ic_launcher_background))
        imageItems.add(CarouselPicker.DrawableItem(R.drawable.ic_launcher_background))
        imageItems.add(CarouselPicker.DrawableItem(R.drawable.ic_launcher_background))

        //Create an adapter
        val imageAdapter = CarouselPicker.CarouselViewAdapter(this, imageItems, 0)
        carouselPicker1.adapter = imageAdapter

        //Case 2 : To populate the picker with text
        val textItems: MutableList<CarouselPicker.PickerItem> = ArrayList()
        //20 here represents the textSize in dp, change it to the value you want.
        textItems.add(CarouselPicker.TextItem("hi", 20))
        textItems.add(CarouselPicker.TextItem("hi", 20))
        textItems.add(CarouselPicker.TextItem("hi", 20))

        val textAdapter = CarouselPicker.CarouselViewAdapter(this, textItems, 0)
        carouselPicker2.adapter = textAdapter

        //Case 3 : To populate the picker with both images and text
        val mixItems: MutableList<CarouselPicker.PickerItem> = ArrayList()
        mixItems.add(CarouselPicker.DrawableItem(R.drawable.ic_launcher_background))
        mixItems.add(CarouselPicker.TextItem("hi", 20))
        mixItems.add(CarouselPicker.DrawableItem(R.drawable.ic_launcher_background))
        mixItems.add(CarouselPicker.TextItem("hi", 20))

        val mixAdapter = CarouselPicker.CarouselViewAdapter(this, mixItems, 0)
        carouselPicker3.adapter = mixAdapter

        // Scroll listener when change (we only use carousel 1)
        carouselPicker1.addOnPageChangeListener(object : OnPageChangeListener {
            override fun onPageScrolled(
                position: Int,
                positionOffset: Float,
                positionOffsetPixels: Int
            ) {
            }

            override fun onPageSelected(position: Int) {
                //position of the selected item
                Toast.makeText(this@MainActivity, position.toString(), Toast.LENGTH_SHORT).show()
            }

            override fun onPageScrollStateChanged(state: Int) {}
        })

    }
}