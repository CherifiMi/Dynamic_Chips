package com.example.daynamicchipsdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.core.content.ContentProviderCompat.requireContext
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var chipGroup : ChipGroup

    private lateinit var chiptext : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chipGroup = findViewById(R.id.chip_group)

        val str = "I was born (to use the word loosely…) over ten thousand years ago inside one Winston Earnest, a law clerk: 41, unhappily married, three children, one deceased."

        val list = str.split(" ")
        list.forEach{
            addChip(it)
        }

        chipGroup.setOnCheckedChangeListener { group, selectedChipId ->
            val chip = group.findViewById<Chip>(selectedChipId)
            chiptext = chip.text.toString().toLowerCase(Locale.ROOT)

        }

    }

    private fun addChip(text: String){
        val chip = Chip(this)
        chip.text = text

        //chip.isCloseIconVisible = true

        //chip.setChipIconResource(R.drawable.ic_baseline_android_24)

        /*chip.setOnCloseIconClickListener{
            chipGroup.removeView(chip)
        }*/

        chipGroup.addView(chip)
    }
}