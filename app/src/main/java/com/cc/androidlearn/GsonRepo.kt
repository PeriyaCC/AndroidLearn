package com.cc.androidlearn

import java.util.*

class GsonRepo(private val apiService: IAPiService,
               private val androidLearnPref: AndroidLearnPref,
               private val dataProvider : DataProvider
               ) : IGsonRepo{

    override fun getAndroidVersions() = dataProvider.getAndroidVersions()

    override fun sample(): ArrayList<AndroidModel> {
        val userId = androidLearnPref.userId()
        val list = apiService.fetchApi(userId)
       return mergeList(dataProvider.getAndroidVersions(), list)
    }

    private fun mergeList(androidVersions: ArrayList<AndroidModel>, newlist: ArrayList<AndroidModel>): ArrayList<AndroidModel> {
         androidVersions.addAll(newlist)
        return androidVersions
    }
}