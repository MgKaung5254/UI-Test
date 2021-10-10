package com.kmlinn.uitest

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.kmlinn.uitest.databinding.ActivityMapsBinding

import android.graphics.Bitmap
import android.graphics.Canvas
import android.view.ViewGroup
import android.app.Activity

import android.util.DisplayMetrics

import android.widget.TextView

import android.view.LayoutInflater
import android.view.View

import androidx.annotation.DrawableRes
import com.google.android.gms.maps.model.*
import com.kmlinn.uitest.databinding.CustomMarkerLayoutBinding
import kotlinx.android.synthetic.main.custom_marker_layout.view.*

import com.google.android.gms.maps.model.BitmapDescriptorFactory

import com.google.android.gms.maps.model.MarkerOptions





class MapsActivity : BaseActivity(), OnMapReadyCallback {

    private lateinit var mMap: GoogleMap
    private lateinit var binding: ActivityMapsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        adjustFontScale(resources.configuration)
        binding = ActivityMapsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Obtain the SupportMapFragment and get notified when the map is ready to be used.
        val mapFragment = supportFragmentManager
            .findFragmentById(R.id.map) as SupportMapFragment
        mapFragment.getMapAsync(this)

        binding.go.setOnClickListener {
            val intentToResultsActivity = Intent(this, ResultsActivity::class.java)
            startActivity(intentToResultsActivity)
        }
    }

    override fun onMapReady(googleMap: GoogleMap) {
        mMap = googleMap

        val customMarkerLocationOne = LatLng(-34.2, 151.0)
        val customMarkerLocationTwo = LatLng(-34.0, 151.2)
        val customMarkerLocationThree = LatLng(-34.5, 151.1)

        mMap.addMarker(
            MarkerOptions().position(customMarkerLocationOne).icon(
                BitmapDescriptorFactory.fromBitmap(
                    createCustomMarker(this, R.drawable.ic_marker, "6")
                )
            )
        )
        mMap.addMarker(
            MarkerOptions().position(customMarkerLocationTwo).icon(
                BitmapDescriptorFactory.fromBitmap(
                    createCustomMarker(this, R.drawable.ic_marker, "2")
                )
            )
        )
        mMap.addMarker(
            MarkerOptions().position(customMarkerLocationThree).icon(
                BitmapDescriptorFactory.fromBitmap(
                    createCustomMarker(this, R.drawable.ic_marker, "3")
                )
            )
        )

        // Add a marker in Sydney and move the camera
        val sydney = LatLng(-34.0, 151.0)
        mMap.addMarker(MarkerOptions().position(sydney).title("Marker in Sydney"))
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(sydney, 10f))
    }

    private fun createCustomMarker(context: Context, @DrawableRes resource: Int, no: String?): Bitmap? {

        val marker: View =
            (context.getSystemService(LAYOUT_INFLATER_SERVICE) as LayoutInflater).inflate(
                R.layout.custom_marker_layout,
                null
            )
        marker.text.text = no
        val displayMetrics = DisplayMetrics()
        (context as Activity).windowManager.defaultDisplay.getMetrics(displayMetrics)
        marker.setLayoutParams(ViewGroup.LayoutParams(52, ViewGroup.LayoutParams.WRAP_CONTENT))
        marker.measure(displayMetrics.widthPixels, displayMetrics.heightPixels)
        marker.layout(0, 0, displayMetrics.widthPixels, displayMetrics.heightPixels)
        marker.buildDrawingCache()
        val bitmap = Bitmap.createBitmap(
            marker.measuredWidth,
            marker.measuredHeight,
            Bitmap.Config.ARGB_8888
        )
        val canvas = Canvas(bitmap)
        marker.draw(canvas)
        return bitmap
    }
}