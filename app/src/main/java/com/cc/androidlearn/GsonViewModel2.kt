package com.cc.androidlearn

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.coroutines.launch

class GsonViewModel2(private val iGsonRepo: IGsonRepo) : ViewModel() {

    val obDataToJson = MutableLiveData<String>()
    val obJsonToDataObj = MutableLiveData<AndroidModel>()

    val obListToJson = MutableLiveData<String>()
    val obJsonToList = MutableLiveData<ArrayList<AndroidModel>>()

    val obResult = MutableLiveData<Result<ArrayList<AndroidModel>>>()

    fun doConversion(){

        viewModelScope.launch {

        }

        val gson = Gson()
        val data = AndroidModel("Android","12")
        val androidVersionList  = iGsonRepo.getAndroidVersions()

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

    fun getSampleList(){
        val newList = iGsonRepo.sample()
        if(newList.isEmpty())
            obResult.value = Result.Failure("No versions available")
        else
            obResult.value = Result.Success(newList)
    }

}