package hoods.com.lazycolumnlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import hoods.com.lazycolumnlayout.ui.theme.LazyColumnLayoutTheme

class MainActivity : ComponentActivity() {
    val catsViewModel by viewModels<CatsViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LazyColumnLayoutTheme {
                // A surface container using the 'background' color from the theme
                Surface(modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background) {
                    Home(
                        catsViewModel.cats,
                        onAddCat = { catsViewModel.addCat(it) },
                        onRemove = { catsViewModel.removeCat(it) }
                    )
                }
            }
        }
    }
}