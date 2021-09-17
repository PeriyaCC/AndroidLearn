package com.cc.androidlearn

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
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
            adapter = VersionsAdapter()
        }
    }

    private fun initClicks() {
        //handle clicks!
    }

    private fun loadData() {
        (rvAndroidVersions.adapter as VersionsAdapter).versionListItems = DataProvider.getAndroidVersions()
    }


}