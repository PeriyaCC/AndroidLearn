package com.cc.androidlearn.presentation.posts.domain

import com.cc.androidlearn.AndroidLearnPref
import com.cc.androidlearn.DataProvider
import com.cc.androidlearn.IAPiService

class PostsRepo(private val apiService: IAPiService,
                private val androidLearnPref: AndroidLearnPref,
                private val dataProvider : DataProvider
) : IPostsRepo {
}