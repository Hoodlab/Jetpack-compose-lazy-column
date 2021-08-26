package hoods.com.lazycolumnlayout.data

import androidx.annotation.DrawableRes
import hoods.com.lazycolumnlayout.R

data class Cat(
    val name: String,
    val gender: String = "Male",
    @DrawableRes val catImage: Int,
)

private val catName = listOf(
    "Daffy",
    "Tweety",
    "Charlie",
    "Yogi",
    "Felix",
    "Shaggy",
    "Scooby",
    "Wanda",
    "Gary",
    "Oscar",
    "Elmo",
    "Bert",
    "Ernie",
    "Kermi",
    "River",
    "Rocky",
    "Summit",
    "Clover",
    "Aspen",
    "Birch",
    "Brook",
    "Cedar"
)

private val image = listOf(
    R.drawable.cat_1,
    R.drawable.cat_3,
    R.drawable.cat_4,
    R.drawable.cat_5,
    R.drawable.cat_6,
    R.drawable.cat_7,
    R.drawable.cat_8,
)

private fun cats(): List<Cat> {
    val cats = mutableListOf<Cat>()
    for ((index, cat) in catName.withIndex()) {
        if (index % 2 == 0) {
            cats.add(Cat(cat, "female", image.random()))
        } else {
            cats.add(Cat(cat, catImage = image.random()))
        }
    }
    return cats
}

object CatsRepo {
    fun getCats(): List<Cat> = cats()
}

fun generateRandomCats(): Cat {
    return cats().random()
}