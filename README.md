# CustomFab

Step 1. Add it in your root build.gradle at the end of repositories:

```
allprojects {
  repositories {
    ...
    maven { url 'https://jitpack.io' }
  }
}
```

Step 2. Add the dependency

```
dependencies {
  implementation 'com.github.Aduraline:PhynaInterviewChallenge:1.0.0'
}
```

Step 3. SDK Version
```
defaultConfig {
  ...
  minSdk 21
  targetSdk 31
  ...
}
```

Step 4. Initialize CustomFab

```
class YourApp: Application(), Application.ActivityLifecycleCallbacks {

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
```

Or do this in your Activity

```
FabLayout.init(activity, DialogType.NORMAL)
```
