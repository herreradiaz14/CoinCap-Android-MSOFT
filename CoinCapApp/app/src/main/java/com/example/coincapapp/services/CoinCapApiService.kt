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
    suspend fun getAssets(): AssetsResponse{
        // Borrar el apiKey antes de commit
        val apiKey = "ffab......"
        val response: HttpResponse = client.get(urlString="http://rest.coincap.io/v3/assets?apiKey=$apiKey")
        return response.body()
    }
}