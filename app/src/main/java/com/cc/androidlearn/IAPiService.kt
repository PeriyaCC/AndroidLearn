package com.cc.androidlearn

import com.cc.androidlearn.presentation.posts.model.PostsResponse
import retrofit2.http.GET

interface IAPiService {

    fun fetchApi(userId: String) = arrayListOf<AndroidModel>()

    @GET("posts")
    suspend fun getBreedsList(): PostsResponse

}