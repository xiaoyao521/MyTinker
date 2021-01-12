package com.xiaoyao.buglytinker;

import android.annotation.TargetApi;
import android.app.Application;
import android.content.Context;
import android.os.Build;

import androidx.multidex.MultiDex;

import com.tencent.bugly.Bugly;
import com.tencent.bugly.beta.Beta;

import static com.tencent.bugly.beta.tinker.TinkerManager.getApplication;
import static com.xiaoyao.buglytinker.Constant.BUGLY_ID;
import static com.xiaoyao.buglytinker.Constant.BUGLY_ID_DEBUG;

/**
 * @作者 luckly
 * @创建日期 2019/9/2 10:14
 */
public class MyApplication extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        //初始化
        Bugly.init(this, BuildConfig.DEBUG ? BUGLY_ID_DEBUG : BUGLY_ID, BuildConfig.DEBUG);
        //Bugly.setIsDevelopmentDevice(getApplicationContext(), true);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
        // you must install multiDex whatever tinker is installed!
        MultiDex.install(base);
        // 安装tinker
        // 此接口仅用于反射Application方式接入。
        Beta.installTinker();
    }

    @TargetApi(Build.VERSION_CODES.ICE_CREAM_SANDWICH)
    public void registerActivityLifecycleCallback(Application.ActivityLifecycleCallbacks callbacks) {
        getApplication().registerActivityLifecycleCallbacks(callbacks);
    }
}
