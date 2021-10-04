package com.cc.androidlearn

import android.os.Bundle
import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class GsonViewModel(private val bundle: Bundle?, private val dataProvider : DataProvider) : ViewModel() {

    val obDataToJson = MutableLiveData<String>()
    val obJsonToDataObj = MutableLiveData<AndroidModel>()

    val obListToJson = MutableLiveData<String>()
    val obJsonToList = MutableLiveData<ArrayList<AndroidModel>>()


    fun doConversion(){
        val gson = Gson()
        val data = AndroidModel("Android","12")
        val androidVersionList  = dataProvider.getAndroidVersions()

        //object conversion
        val dataToJson = gson.toJson(data)
        obDataToJson.value = dataToJson

        val jsonToDataObj = gson.fromJson(dataToJson, AndroidModel::class.java)
        obJsonToDataObj.value = jsonToDataObj


        //list conversion
        val listToJson = gson.toJson(androidVersionList) // arrayList to Json
        obListToJson.value = listToJson


        val myType = object : TypeToken<ArrayList<AndroidModel>>() {}.type
        val jsonToList = gson.fromJson<ArrayList<AndroidModel>>(listToJson, myType)
        obJsonToList.value = jsonToList


    }

    class Factory(private val bundle: Bundle?, private val dataProvider: DataProvider) :
        ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(GsonViewModel::class.java)) {
                return GsonViewModel(bundle, dataProvider) as T
            }
            throw IllegalArgumentException("Unknown ViewModel")
        }
    }

}