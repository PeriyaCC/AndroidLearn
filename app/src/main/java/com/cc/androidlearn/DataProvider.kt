package com.cc.androidlearn

object DataProvider {


    fun getAndroidVersions(): ArrayList<AndroidModel> {
        return arrayListOf(AndroidModel("Oreo","8"),AndroidModel("Noughat","7"),AndroidModel("Pie","9"))
    }


}