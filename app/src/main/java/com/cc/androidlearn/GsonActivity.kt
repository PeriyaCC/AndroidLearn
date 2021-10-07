package com.cc.androidlearn

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.AbstractSavedStateViewModelFactory
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_gson.*
import java.lang.Exception

class GsonActivity : AppCompatActivity() {

    private val tag = "GsonActivity"
    private lateinit var gsonViewModelFactory: GsonViewModel.Factory

    private val gsonModel by lazy {
        ViewModelProvider(this, gsonViewModelFactory).get(GsonViewModel::class.java)
    }

    private val gsonViewModel by viewModels<GsonViewModel2>() { GsonVMFactory() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gson)

        DataProvider.getAndroidVersions()

        tvTxt.gone()

        try{
            //do something
        }catch (ex : Exception){
            // handle exception
        }

        kotlin.runCatching {
            //do something
        }.onSuccess {
            //handle success
        }.onFailure {
            //handle failure
        }

        gsonViewModelFactory = GsonViewModel.Factory(savedInstanceState, DataProvider)
        subscribeToObservers()
        gsonViewModel.doConversion()
    }

    private fun subscribeToObservers() {

        gsonViewModel.obDataToJson.observe(this, {
            Log.d(tag, "dataToJson $it")
        })

        gsonViewModel.obJsonToDataObj.observe(this, {
            Log.d(tag, "jsonToDataObj ${it.name}")
            showToast(it.name)
        })

        gsonViewModel.obListToJson.observe(this, {
            Log.d(tag, "listToJson $it")
        })

        gsonViewModel.obJsonToList.observe(this, {
            Log.d(tag, "jsonToList ${it[0].name}")
        })
    }

}