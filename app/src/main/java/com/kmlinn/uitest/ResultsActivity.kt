package com.kmlinn.uitest

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.kmlinn.uitest.databinding.ActivityResultBinding

class ResultsActivity: BaseActivity(), CarListAdapter.OnItemClickListener {

    private lateinit var binding: ActivityResultBinding
    private lateinit var mAdapter: CarListAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adjustFontScale(resources.configuration)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.list.setHasFixedSize(true)
        binding.list.layoutManager = LinearLayoutManager(this)

        val carList: List<Car> = listOf(
            Car("Mazada 3", "SMS1000Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Honda Shuttle Hybrid", "SMN7000B", "7 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Ssangyong Tivoli", "SMN1234Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY"),
            Car("Toyota Sienta Hybrid", "SMN2334Z", "5 Seater", "Fr.$3.00/hr", "$0.40/km", "0.5KM AWAY")
        )
        mAdapter = CarListAdapter(carList, this, this)
        binding.list.adapter = mAdapter

        binding.results.text = getString(R.string.cars_found, carList.size)

    }

    override fun onItemClick(item: Car) {

        val intentToBookingActivity = Intent(this, BookingActivity::class.java)
        intentToBookingActivity.putExtra("carItem", item)
        startActivity(intentToBookingActivity)
    }
}