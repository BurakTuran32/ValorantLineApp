package com.example.valorantlineapp.data.remote

import com.example.valorantlineapp.data.entity.AgentData
import com.example.valorantlineapp.data.entity.MapData
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {

    @GET("agents")
    suspend fun getAgent(
        @Query("language") language : String,
        @Query("isPlayableCharacter") isPlayableCharacter: Boolean
    ) : AgentData

    @GET("maps")
    suspend fun getMap(): MapData
}