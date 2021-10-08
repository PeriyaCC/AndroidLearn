package com.cc.androidlearn.presentation.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.cc.androidlearn.AndroidLearnPref
import com.cc.androidlearn.DataProvider
import com.cc.androidlearn.NetworkModule
import com.cc.androidlearn.presentation.posts.domain.IPostsRepo
import com.cc.androidlearn.presentation.posts.domain.PostsRepo

class CoroutinesVMFactory : ViewModelProvider.Factory{

    init {
        getInstance()
    }

    companion object {
        @Volatile
        private var INSTANCE: IPostsRepo? = null

        fun getInstance() =
            INSTANCE ?: synchronized(CoroutinesVMFactory::class.java) {
                INSTANCE ?: PostsRepo(
                    NetworkModule().makeApiService(),
                    AndroidLearnPref(),
                    DataProvider
                ).also { INSTANCE = it }
            }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IPostsRepo::class.java).newInstance(INSTANCE)
    }

}