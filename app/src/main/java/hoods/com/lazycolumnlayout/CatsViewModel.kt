package hoods.com.lazycolumnlayout

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import hoods.com.lazycolumnlayout.data.Cat
import hoods.com.lazycolumnlayout.data.CatsRepo

class CatsViewModel : ViewModel() {
    var cats by mutableStateOf(CatsRepo.getCats())

    fun addCat(cat: Cat) {
        cats = cats + listOf(cat)
    }

    fun removeCat(cat: Cat) {
        cats = cats.toMutableList().also {
            it.remove(cat)
        }
    }
}