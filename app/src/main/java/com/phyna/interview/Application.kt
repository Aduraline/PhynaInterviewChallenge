package com.phyna.interview

import android.app.Activity
import android.app.Application
import android.os.Bundle
import com.phyna.customfab.dialog.DialogType
import com.phyna.customfab.FabLayout

class PhynaChallenge: Application(), Application.ActivityLifecycleCallbacks {

    override fun onCreate() {
        super.onCreate()
        registerActivityLifecycleCallbacks(this);
    }

    override fun onActivityCreated(p0: Activity, p1: Bundle?) {
        FabLayout.init(p0, DialogType.NORMAL)
    }

    override fun onActivityStarted(p0: Activity) {
        FabLayout.init(p0, DialogType.NORMAL)
    }

    override fun onActivityResumed(p0: Activity) {
        FabLayout.init(p0, DialogType.NORMAL)
    }

    override fun onActivityPaused(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivityStopped(p0: Activity) {
        TODO("Not yet implemented")
    }

    override fun onActivitySaveInstanceState(p0: Activity, p1: Bundle) {
        TODO("Not yet implemented")
    }

    override fun onActivityDestroyed(p0: Activity) {
        TODO("Not yet implemented")
    }
}