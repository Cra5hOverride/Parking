package buu.informatics.s59160965.parking

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.databinding.DataBindingUtil
import buu.informatics.s59160965.parking.databinding.ActivityMainBinding



class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var globalVar = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        Gone()
        binding.apply {
            car1Button.setOnClickListener {
                globalVar = 1
                addinfo(it)
            }
            car2Button.setOnClickListener {
                globalVar = 2
                addinfo(it)
            }
            car3Button.setOnClickListener {
                globalVar = 3
                addinfo(it)
            }
            updateButton.setOnClickListener{
                updateinfo(it)
            }
            delButton.setOnClickListener{
                delinfo(it)
            }

        }

    }

    private fun addinfo(view: View) {
        binding.apply {
            var cars = if (globalVar == 1) car1 else if (globalVar == 2) car2 else car3

            name.setText(cars?.name)
            brand.setText(cars?.brand)
            licensePlate.setText(cars?.licenseplate)

            Visible()
        }
    }
    private fun updateinfo (view: View){
        binding.apply {
            var cars = if (globalVar == 1) car1 else if (globalVar == 2) car2 else car3
            var button = if (globalVar == 1) car1Button else if (globalVar == 2) car2Button else car3Button

            cars?.name = name.text.toString()
            cars?.licenseplate = licensePlate.text.toString()
            cars?.brand = brand.text.toString()
            button.text = licensePlate.text.toString()
            invalidateAll()

            Gone()
        }


    }
    private fun delinfo (view: View){
        binding.apply {
            var cars = if (globalVar == 1) car1 else if (globalVar == 2) car2 else car3
            var button = if (globalVar == 1) car1Button else if (globalVar == 2) car2Button else car3Button

            cars?.licenseplate = ""
            cars?.brand = ""
            cars?.name = ""
            button.setText("ว่าง")
            Gone()

        }

    }
    private fun Gone(){
        binding.apply {
            delButton.visibility = View.GONE
            updateButton.visibility = View.GONE
            name.visibility = View.GONE
            licensePlate.visibility = View.GONE
            brand.visibility = View.GONE
        }
    }
    private fun Visible(){
        binding.apply {
            delButton.visibility = View.VISIBLE
            updateButton.visibility = View.VISIBLE
            name.visibility = View.VISIBLE
            licensePlate.visibility = View.VISIBLE
            brand.visibility = View.VISIBLE
        }
    }
}

