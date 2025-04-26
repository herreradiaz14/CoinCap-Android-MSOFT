package com.example.coincapapp.services

import com.example.coincapapp.models.AssetsResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import io.ktor.client.statement.HttpResponse
import javax.inject.Inject

class CoinCapApiService @Inject constructor(
    private val client: HttpClient
) {
    // Borrar el apiKey antes de commit
    val apiKey = "ffab4e2f346a6fc24e7537ce4e0495c81eea0cbf1a78a4d39fec59d0d2d0e92f"
    val baseUrl = "http://rest.coincap.io/v3"

    suspend fun getAssets(): AssetsResponse{
        val response: HttpResponse = client.get(urlString="$baseUrl/assets?apiKey=$apiKey")
        return response.body()
    }
}