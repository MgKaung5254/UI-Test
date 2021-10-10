package com.kmlinn.uitest

import android.content.res.Configuration
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.kmlinn.uitest.databinding.ActivityBookingBinding
import android.view.WindowManager

import android.util.DisplayMetrics


class BookingActivity: BaseActivity() {

    private lateinit var binding: ActivityBookingBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adjustFontScale(resources.configuration)

        binding = ActivityBookingBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val item = intent.getParcelableExtra<Car>("carItem")

        binding.carName.text = item?.name
        binding.carModel.text = item?.model
        binding.title.text = getString(R.string.booking_id, "1234565")


    }
}