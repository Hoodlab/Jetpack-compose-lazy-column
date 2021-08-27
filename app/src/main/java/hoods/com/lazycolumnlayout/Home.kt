package hoods.com.lazycolumnlayout

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.semantics.heading
import androidx.compose.ui.semantics.semantics
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import hoods.com.lazycolumnlayout.data.Cat
import hoods.com.lazycolumnlayout.data.CatsRepo
import hoods.com.lazycolumnlayout.data.generateRandomCats

@Composable
fun Home(
    cats: List<Cat>,
    onAddCat: (Cat) -> Unit,
    onRemove: (Cat) -> Unit,
) {
    Scaffold(floatingActionButton = {
        FloatingActionButton(onClick = { onAddCat(generateRandomCats()) }) {
            Icon(imageVector = Icons.Default.Add, contentDescription = null)
        }
    }) { innerPadding ->
        LazyColumn(contentPadding = innerPadding) {
            item {
                Header(text = "Cats available for adoption")
            }
            items(cats) { cat ->
                CatListItem(cat = cat, onRemove = onRemove)
            }
        }
    }

}

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CatListItem(cat: Cat, onRemove: (Cat) -> Unit) {
    ListItem(
        modifier = Modifier
            .clickable { onRemove(cat) }
            .padding(8.dp),
        icon = {
            Image(
                painter = painterResource(id = cat.catImage),
                contentDescription = null,
                modifier = Modifier.clip(MaterialTheme.shapes.small)
            )
        },
        text = { Text(text = cat.name, style = MaterialTheme.typography.h6) },
        secondaryText = {
            Text(
                text = cat.gender,
                style = MaterialTheme.typography.body2,
                color = Color.Black.copy(.5f)
            )
        }
    )
}

@Composable
fun Header(
    text: String,
    modifier: Modifier = Modifier,
) {
    Surface(
        color = MaterialTheme.colors.onSurface.copy(.1f),
        contentColor = MaterialTheme.colors.primary,
        modifier = modifier.semantics { heading() }
    ) {
        Text(
            text = text,
            style = MaterialTheme.typography.subtitle2,
            modifier = modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
        )
    }
}


@Preview(showBackground = true)
@Composable
fun PreCatListItem() {
    val cat = remember {
        generateRandomCats()
    }
    CatListItem(cat = cat, {})
}

@Preview
@Composable
fun PrevHome() {
    val cats = remember {
        CatsRepo.getCats()
    }
    Home(cats, {}, {})
}









