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
            var names = if (globalVar == 1) car1?.name else if (globalVar == 2) car2?.name else car3?.name
            var licenseplates = if (globalVar == 1) car1?.licenseplate else if (globalVar == 2) car2?.licenseplate else car3?.licenseplate
            var brands = if (globalVar == 1) car1?.brand else if (globalVar == 2) car2?.brand else car3?.brand

            delButton.visibility = View.VISIBLE
            updateButton.visibility = View.VISIBLE
            name.visibility = View.VISIBLE
            licensePlate.visibility = View.VISIBLE
            brand.visibility = View.VISIBLE




        }
    }
    private fun updateinfo (view: View){
        binding.apply {
            delButton.visibility = View.GONE
            updateButton.visibility = View.GONE
            name.visibility = View.GONE
            licensePlate.visibility = View.GONE
            brand.visibility = View.GONE
        }


    }
    private fun delinfo (view: View){

        binding.apply {
            delButton.visibility = View.GONE
            updateButton.visibility = View.GONE
            name.visibility = View.GONE
            licensePlate.visibility = View.GONE
            brand.visibility = View.GONE
        }

    }
}

