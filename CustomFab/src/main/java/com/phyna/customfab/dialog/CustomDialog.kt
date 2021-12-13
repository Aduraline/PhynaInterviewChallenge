package com.phyna.customfab.dialog

import android.annotation.SuppressLint
import android.app.Activity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.Observer
import androidx.lifecycle.asLiveData
import com.bumptech.glide.Glide
import com.phyna.customfab.R
import com.phyna.customfab.data.InstallationPreferences
import com.phyna.customfab.databinding.CustomDialogBinding
import com.phyna.customfab.dialog.base.BaseDialog

class CustomDialog(private var activity: Activity): BaseDialog(activity){
    private lateinit var binding: CustomDialogBinding

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.inflate(LayoutInflater.from(context), R.layout.custom_dialog, null, false);
        setContentView(binding.root);

        //loading image
        Glide.with(context)
            .load(R.drawable.icon)
            .into(binding.img)

        val installationPreferences = InstallationPreferences(activity)
        installationPreferences.installationTime.asLiveData().observe(activity as LifecycleOwner, Observer {
            if(it!=null) {
                binding.installationTime.text = "Library installed on $it"
            }
        })

        loadCurrentTime().observe(activity as LifecycleOwner, {
            if(it!=null && it.isNotEmpty()) {
                binding.currentTime.text = "Current time: \n$it"
            }
        })
    }
}
