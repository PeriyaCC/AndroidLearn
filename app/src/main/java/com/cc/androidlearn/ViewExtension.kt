package com.cc.androidlearn

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.tabs.TabLayout

fun Context.showToast(msg : String){
    Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
}

fun View.gone(){
    this.visibility = View.GONE
}

fun View.hide(){
    this.visibility = View.INVISIBLE
}

fun View.show(){
    this.visibility = View.VISIBLE
}


fun TabLayout.applyStyle(){

}