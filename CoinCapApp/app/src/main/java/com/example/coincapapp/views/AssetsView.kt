package com.example.coincapapp.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import coil3.compose.AsyncImage
import com.example.coincapapp.models.Asset
import com.example.coincapapp.viewModels.AssetsListViewModel
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.style.TextOverflow

@Composable
fun AssetsList(viewModel: AssetsListViewModel = hiltViewModel()){
    val assets by viewModel.assets.collectAsState()

    LazyColumn (
        modifier = Modifier
            .fillMaxHeight()
            .background(MaterialTheme.colorScheme.onBackground)
    ) {
        items(assets, key = {it.id}){ asset ->
                AssetContainer(asset)
        }

    }
}

@Composable
fun AssetContainer(asset: Asset){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        Box(
            modifier = Modifier.padding(horizontal = 8.dp)
        ) {
            if (LocalInspectionMode.current) {
                Icon(
                    imageVector = Icons.Filled.AccountCircle,
                    contentDescription = null,
                    tint = Color.White,
                    modifier = Modifier.size(30.dp)
                )
            } else {
                AsyncImage(
                    model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
                    contentDescription = null,
                    modifier = Modifier.size(30.dp)
                )
            }
        }

        Column(
            modifier = Modifier.weight(1f)
        ) {
            Text(
                text=asset.symbol,
                fontSize = 18.sp,
                color = Color.White
            )
            Text(
                text=asset.name,
                fontSize = 14.sp,
                color = Color.Gray,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }

        Spacer(modifier = Modifier.weight(1f))

        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(end = 16.dp)
        ) {
            Icon(
                imageVector = if (asset.percentage >= 0) Icons.Default.KeyboardArrowUp else Icons.Default.KeyboardArrowDown,
                contentDescription = null,
                tint = if (asset.percentage >= 0) Color.Green else Color.Red,
                modifier = Modifier.size(16.dp)
            )

            Text(
                text = "${asset.percentage}%",
                fontSize = 16.sp,
                modifier = Modifier.padding(start = 4.dp, end = 8.dp),
                color = if (asset.percentage >= 0) Color.Green else Color.Red
            )

            Text(
                text = "$${asset.price}%",
                fontSize = 14.sp,
                color = Color.White
            )
        }
    }
}

// Para ver toda la vista UI
//@Preview(
//    showBackground = true,
//    showSystemUi = true
//)
//
//@Composable
//fun AssetContainerPreview(){
//    Column (
//        verticalArrangement = Arrangement.Center,
//        modifier = Modifier.fillMaxSize()
//    ) {
//        AssetContainer()
//        Spacer(modifier = Modifier.size(16.dp))
//        AssetContainer()
//        Spacer(modifier = Modifier.size(16.dp))
//        AssetContainer()
//    }
//}

// Ver solo el componente
@Preview(
    showBackground = true,
    showSystemUi = true
)

@Composable
fun AssetContainerPreview(){
    AssetsList()
}