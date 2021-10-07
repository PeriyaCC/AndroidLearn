package com.cc.androidlearn

interface IGsonRepo {
    fun getAndroidVersions() : ArrayList<AndroidModel>
    fun sample() : ArrayList<AndroidModel>
}