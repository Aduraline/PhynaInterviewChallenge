package com.phyna.customfab.dialog.base

import android.app.Activity
import android.os.Bundle
import android.view.Window
import androidx.appcompat.app.AppCompatDialog
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelStoreOwner

abstract class BaseDialog(private var activity: Activity): AppCompatDialog(activity) {
    private lateinit var viewModel: BaseViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //set up background dim
        requestWindowFeature(Window.FEATURE_NO_TITLE)
        window?.setBackgroundDrawableResource(android.R.color.transparent)
        window?.setDimAmount(0.5f)

        viewModel = ViewModelProvider(activity as ViewModelStoreOwner)[BaseViewModel::class.java]
    }

    fun loadCurrentTime(): MutableLiveData<String> {
        viewModel.getCurrentSystemTime()
        return viewModel.getCurrentTime()
    }
}
