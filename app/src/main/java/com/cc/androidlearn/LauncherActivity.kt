package com.cc.androidlearn

import android.app.Activity
import android.app.Dialog
import android.content.Intent
import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.Window
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatButton
import androidx.core.os.bundleOf
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
        btnOpenAct.setOnClickListener {

          /*  val intent = Intent(this, FragmentExampleActivity::class.java)
            intent.putExtra(Constants.Keys.data, "someData")
            startActivity(intent)
            finish()*/

            val intent = Intent(this, FragmentExampleActivity::class.java)
            resultLauncher.launch(intent)
        }
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
                if (etSample.text.toString().trim().isEmpty()) {
                    etSample.error = "Sample is required" // change message as per the field!
                } else
                    dismiss()
            }

            window?.apply {
                setSoftInputMode(android.view.WindowManager.LayoutParams.SOFT_INPUT_STATE_VISIBLE)
                setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
            }
            show()
        }
    }


    var resultLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                val data: Intent? = result.data
                Toast.makeText(
                    this,
                    data?.extras?.getString(Constants.Keys.data),
                    Toast.LENGTH_SHORT
                ).show()
            }
        }


}