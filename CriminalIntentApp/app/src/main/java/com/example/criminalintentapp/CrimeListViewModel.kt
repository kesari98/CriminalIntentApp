package com.example.criminalintentapp

import androidx.lifecycle.ViewModel
import java.util.Date
import java.util.UUID

class CrimeListViewModel : ViewModel() {

    val crimes = mutableListOf<Crime>()

    init {
        //populating the list with 100 random objects
        for (i in 0 until 100) {
            val crime = Crime(
                id = UUID.randomUUID(),
                title = "Crime #$i",
                date = Date(),
                isSolved = i % 2 == 0,
                requiresPolice = i%2 !=0
            )
            crimes += crime
        }
    }
}