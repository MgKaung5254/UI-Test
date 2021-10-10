package com.kmlinn.uitest

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.kmlinn.uitest.databinding.CarListRowBinding

class CarListAdapter(
    private val items: List<Car>,
    private val context: Context,
    private val listener: OnItemClickListener
) : RecyclerView.Adapter<CarListAdapter.CarListViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CarListViewHolder {
        val view = CarListRowBinding.inflate(LayoutInflater.from(context), parent, false)
        return CarListViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: CarListViewHolder, position: Int) {
        val newsItem = items[position]
        holder.apply { bind(newsItem) }
    }

    inner class CarListViewHolder(private val binding: CarListRowBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(item: Car) {
            binding.apply {
                carItem = item
                binding.carCard.setOnClickListener { listener.onItemClick(item) }
            }
        }
    }

    interface OnItemClickListener {
        fun onItemClick(item: Car)
    }

}