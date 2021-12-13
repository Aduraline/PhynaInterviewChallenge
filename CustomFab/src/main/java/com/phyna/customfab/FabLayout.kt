package com.phyna.customfab

import android.annotation.SuppressLint
import android.app.Activity
import android.content.res.ColorStateList
import android.view.ViewGroup
import com.google.android.material.floatingactionbutton.FloatingActionButton
import android.widget.RelativeLayout
import androidx.core.view.ViewCompat
import android.graphics.Point
import android.view.Display
import com.phyna.customfab.data.InstallationPreferences
import com.phyna.customfab.dialog.CustomDialog
import com.phyna.customfab.dialog.DialogType
import kotlinx.coroutines.runBlocking
import java.text.SimpleDateFormat
import java.util.*

object FabLayout {
    fun init(activity: Activity, screen: DialogType?) {
        val display: Display = activity.windowManager.defaultDisplay
        val size = Point()
        display.getSize(size)
        val yPosition = size.y - 200
        val xPosition = size.x - 200

        //setting up rootview
        val root: ViewGroup = activity.window.decorView as ViewGroup

        //creating FAB
        val fab = FloatingActionButton(activity)
        setFab(activity, fab, xPosition, yPosition)

        //FAB onclick
        fab.setOnClickListener {
            when(screen) {
                DialogType.NORMAL -> {
                    CustomDialog(activity).show()
                }
                DialogType.CALL -> {

                }
                DialogType.CHAT -> {

                }
                else -> {
                    CustomDialog(activity).show()
                }
            }
        }

        //add FAB to rootView
        root.addView(fab)

        runBlocking { storeInstallation(activity) }
    }

    private fun setFab(activity: Activity, fab: FloatingActionButton, width: Int, height: Int) {
        fab.id = ViewCompat.generateViewId()

        val params = RelativeLayout.LayoutParams(150, 150)
        params.setMargins(width, height, 0, 0)

        fab.layoutParams = params
        fab.setImageResource(R.drawable.bot)
        fab.imageTintList = (ColorStateList.valueOf(activity.resources.getColor(R.color.white)))
        fab.backgroundTintList = (ColorStateList.valueOf(activity.resources.getColor(R.color.primaryColor)))
    }

    @SuppressLint("SimpleDateFormat")
    private suspend fun storeInstallation(activity: Activity) {
        val installation = InstallationPreferences(activity)

        val sdf = SimpleDateFormat("dd MMM yyyy")
        val currentDate = sdf.format(Date())

        installation.saveInstallationTime(currentDate)
    }
}
