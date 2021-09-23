package com.cc.androidlearn

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.activity_fragment_example.*


class FragmentExampleActivity : AppCompatActivity() {

    private val fragmentOne by lazy {
        FragmentOne()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_fragment_example)
        getInputs()
        initClicks()
        //doSendResultBack()
    }

    private fun getInputs() {
        //intent?.getLongExtra(Constants.Keys.data)
    }

    private fun initClicks() {
        arrayOf(btnAdd,btnRemove,btnReplace).forEach {
            it.setOnClickListener(onClick)
        }
    }

    private val onClick = View.OnClickListener {
        when(it){
            btnAdd -> {
                addFragment()
            }
            btnRemove -> {
                removeFragment()
            }
            btnReplace -> {
                replaceFragment(prepareFragmentWithBundle())
            }
        }
    }

    private fun doSendResultBack() {
        setResult(RESULT_OK, Intent().apply {
            putExtra(Constants.Keys.data, "data from FragmentExampleActivity")
        })
        finish()
    }

    private fun addFragment() {
        with(supportFragmentManager.beginTransaction()) {
            add(R.id.containerView, fragmentOne)
            commit()
        }
    }

    private fun addFragmentWithBackStack() {
        with(supportFragmentManager.beginTransaction()) {
            add(R.id.containerView, fragmentOne)
            addToBackStack(fragmentOne.tag)
            commit()
        }
    }

    private fun removeFragment() {
        with(supportFragmentManager.beginTransaction()) {
            remove(fragmentOne)
            commit()
        }
    }

    private fun replaceFragment(frag : Fragment) {
        with(supportFragmentManager.beginTransaction()) {
            replace(R.id.containerView, frag)
            commit()
        }
    }

    private fun prepareFragmentWithBundle(): Fragment {
        val frag = FragmentTwo()
        val bundle = Bundle()
        bundle.putString(Constants.Keys.data, "Test")
        frag.arguments = bundle
        return frag
    }

}