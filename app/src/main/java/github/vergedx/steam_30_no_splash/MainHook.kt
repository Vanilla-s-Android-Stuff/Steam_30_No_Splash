package github.vergedx.steam_30_no_splash

import android.app.Activity
import de.robv.android.xposed.IXposedHookLoadPackage
import de.robv.android.xposed.XC_MethodReplacement
import de.robv.android.xposed.XposedHelpers
import de.robv.android.xposed.callbacks.XC_LoadPackage

class MainHook : IXposedHookLoadPackage {
    override fun handleLoadPackage(lpparam: XC_LoadPackage.LoadPackageParam?) {
        if (lpparam?.packageName != "com.valvesoftware.android.steam.community") return

        XposedHelpers.findAndHookMethod(
            "expo.modules.splashscreen.singletons.SplashScreen", lpparam.classLoader,
            "show", Activity::class.java, "expo.modules.splashscreen.SplashScreenImageResizeMode",
            Class::class.java, Boolean::class.javaPrimitiveType, object : XC_MethodReplacement() {
                override fun replaceHookedMethod(param: MethodHookParam) {
                    return
                }
            }
        )
    }
}
