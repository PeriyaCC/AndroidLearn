package com.cc.androidlearn

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment

class FragmentOne : Fragment(R.layout.fragment_one) {


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        requireContext().showToast("Fragment One")
    }

}