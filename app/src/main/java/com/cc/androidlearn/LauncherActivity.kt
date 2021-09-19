package com.cc.androidlearn

import android.app.Dialog
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.recyclerview.widget.LinearLayoutManager
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_launcher.*


class LauncherActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_launcher)
        initView()
        initClicks()
        loadData()
    }

    private fun initView() {
        rvAndroidVersions.apply {
            layoutManager = LinearLayoutManager(this@LauncherActivity)
            adapter = VersionsAdapter(::onItemClicked, ::showDeleteAlert)
        }
    }

    private fun initClicks() {

    }

    private fun onItemClicked(selectedItem: String?) {
        Toast.makeText(this, selectedItem, Toast.LENGTH_SHORT).show()
    }

    private fun loadData() {
        (rvAndroidVersions.adapter as VersionsAdapter).versionListItems =
            DataProvider.getAndroidVersions()
    }

    private fun showDeleteAlert(deleteItemPosition: Int) {
        //write code to show alert
    }

    private fun showCustomDialog() {
        with(Dialog(this)) {
            requestWindowFeature(Window.FEATURE_NO_TITLE)
            setContentView(R.layout.item_dialog)
            val etSample = findViewById<TextInputEditText>(R.id.etSample)

            findViewById<AppCompatButton>(R.id.btnAdd).setOnClickListener {
                if(etSample.text.toString().trim().isEmpty()){
                    etSample.error = "Sample is required" // change message as per the field!
                }else
                    dismiss()
            }

            window?.apply {
                setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            show()
        }
    }


}