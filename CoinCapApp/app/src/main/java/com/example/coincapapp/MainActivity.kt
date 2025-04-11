package com.example.coincapapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.coincapapp.models.Asset
import com.example.coincapapp.ui.theme.CoinCapAppTheme
import com.example.coincapapp.views.AssetContainer

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            CoinCapAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
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
            }
        }
    }
}

//@Composable
//fun Greeting(name: String, modifier: Modifier = Modifier) {
//    Text(
//        text = "Hello $name!",
//        modifier = modifier
//    )
//}
//
//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//fun GreetingPreview() {
//    CoinCapAppTheme {
//        Greeting("Android")
//    }
//}