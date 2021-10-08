package com.cc.androidlearn.presentation.posts.view

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import com.cc.androidlearn.R
import com.cc.androidlearn.presentation.posts.viewmodel.CoroutinesVM
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CoroutinesActivity : AppCompatActivity() {

    private val coroutinesVM by viewModels<CoroutinesVM>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_coroutines)
    }


    fun performDelayAction(){
        lifecycleScope.launch {
            withContext(Dispatchers.IO){
                delay(100)
                // do action
            }
        }
    }

    fun performDelayAction2(){
        //coroutinesVM.performDelayAction2()
        coroutinesVM.performDelayAction()
    }

    fun asyncAwait(){

    }

}