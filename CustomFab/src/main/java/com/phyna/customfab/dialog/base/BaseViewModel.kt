package com.phyna.customfab.dialog.base

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import java.text.SimpleDateFormat
import java.util.*

class BaseViewModel: ViewModel() {
    private var currentTime: MutableLiveData<String> = MutableLiveData()

    fun getCurrentTime(): MutableLiveData<String> {
        return currentTime
    }

    @SuppressLint("SimpleDateFormat")
    fun getCurrentSystemTime() {
        val sdf = SimpleDateFormat("hh:mm:ss dd MMM yyyy")
        val currentDate = sdf.format(Date())
        currentTime.postValue(currentDate)
    }
}
