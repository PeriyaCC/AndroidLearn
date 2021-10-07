package com.cc.androidlearn

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class GsonVMFactory : ViewModelProvider.Factory{

    init {
        getInstance()
    }

    companion object {
        @Volatile
        private var INSTANCE: IGsonRepo? = null

        fun getInstance() =
            INSTANCE ?: synchronized(GsonVMFactory::class.java) {
                INSTANCE ?: GsonRepo(
                    IAPiService(),
                    AndroidLearnPref(),
                    DataProvider
                ).also { INSTANCE = it }
            }

        fun destroyInstance() {
            INSTANCE = null
        }
    }

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return modelClass.getConstructor(IGsonRepo::class.java).newInstance(INSTANCE)
    }

}