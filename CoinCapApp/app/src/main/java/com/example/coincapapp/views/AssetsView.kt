package com.example.coincapapp.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.CheckCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.example.coincapapp.models.Asset

@Composable
fun AssetContainer(asset: Asset){
    Row(
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.fillMaxWidth()
    ) {
//        Icon(
//            imageVector = Icons.Filled.CheckCircle,
//            contentDescription = null,
//            tint = Color.Red,
//            modifier = Modifier.padding(horizontal = 8.dp)
//        )

        AsyncImage(
            model = "https://assets.coincap.io/assets/icons/${asset.symbol.lowercase()}@2x.png",
            contentDescription = null
        )

        Column {
            Text(
                text=asset.symbol,
                fontSize = 18.sp
            )
            Text(
                text=asset.name,
                fontSize = 14.sp
            )
        }

        Spacer(modifier = Modifier.weight(1f))

//        Icon(
//            imageVector = Icons.Filled.KeyboardArrowUp,
//            contentDescription = null,
//            tint = Color.Green
//        )
        Text(
            text = "${asset.percentage}%",
            fontSize = 16.sp,
            modifier = Modifier.padding(horizontal = 16.dp),
            color = if (asset.percentage >= 0) Color.Green else Color.Red
        )

        Text(
            text = asset.price,
            fontSize = 14.sp,
            modifier = Modifier.padding(horizontal = 16.dp)
        )
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
    Column (
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxSize()
    ) {
        AssetContainer(
            Asset(
                id = "1",
                name = "Bitcoin",
                symbol = "BTC",
                price = "$6525",
                percentage = 5.0
            )
        )
        Spacer(modifier = Modifier.size(16.dp))
        AssetContainer(
            Asset(
                id = "2",
                name = "Tether",
                symbol = "USDT",
                price = "$100",
                percentage = -15.0
            )
        )
    }
}