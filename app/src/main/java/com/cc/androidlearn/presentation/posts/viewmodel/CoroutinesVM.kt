package com.cc.androidlearn.presentation.posts.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesVM : ViewModel(){


    fun performDelayAction(){
        viewModelScope.launch {
            withContext(Dispatchers.IO){
                delay(100)
                // do action
            }
        }
    }

    suspend fun performDelayAction2() =  withContext(Dispatchers.IO){
        delay(100)
        // do action
    }

}