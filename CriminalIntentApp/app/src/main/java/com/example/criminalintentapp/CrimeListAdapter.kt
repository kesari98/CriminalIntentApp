package com.example.criminalintentapp

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.example.criminalintentapp.databinding.ListItemCrimeBinding
import com.example.criminalintentapp.databinding.ListItemCrimePoliceBinding

class CrimeListAdapter(private val crimes: List<Crime>) : RecyclerView.Adapter<ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)

        return if (viewType == 1) {
            val binding = ListItemCrimePoliceBinding.inflate(inflater, parent, false)
            CrimePoliceHolder(binding)
        } else {
            val binding = ListItemCrimeBinding.inflate(inflater, parent, false)
            CrimeHolder(binding)
        }

    }


    override fun getItemCount(): Int {
        return crimes.size
    }

    override fun getItemViewType(position: Int): Int {
        return if(crimes[position].requiresPolice) {
            1
        } else {
            0
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val crime = crimes[position]
        when (holder.itemViewType) {
            1 -> {
                val policeHolder = holder as CrimePoliceHolder
                policeHolder.bind(crime)
            }

            0 -> {
                val crimeHolder = holder as CrimeHolder
                crimeHolder.bind(crime)
            }
        }
    }
}

class CrimeHolder(
    private val binding: ListItemCrimeBinding
) : ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}

class CrimePoliceHolder(
    private val binding: ListItemCrimePoliceBinding
) : ViewHolder(binding.root) {
    fun bind(crime: Crime) {
        binding.crimeTitle.text = crime.title
        binding.crimeDate.text = crime.date.toString()

        binding.root.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "${crime.title} clicked!",
                Toast.LENGTH_SHORT
            ).show()
        }
        binding.policeButton.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "Police Contacted",
                Toast.LENGTH_SHORT
            ).show()
        }
    }
}
