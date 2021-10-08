package com.cc.androidlearn

import android.app.Application

private var application: AndroidLearnApp? = null

class AndroidLearnApp : Application(){

    companion object{
        fun getApplicationContext(): AndroidLearnApp {
            return application!!
        }
    }

    override fun onCreate() {
        super.onCreate()
        application = this
    }



}