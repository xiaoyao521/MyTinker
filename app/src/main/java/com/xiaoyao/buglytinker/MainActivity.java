package com.xiaoyao.buglytinker;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * @作者 luckly
 * @创建日期 2019/9/2 9:35
 * @类描述
 */
public class MainActivity extends AppCompatActivity {
    public static final String TAG = "MainActivity";
    Timer timer;

    //appid : ef91caaecb
    //app key:  ca9c6c9d-db92-4eed-ac9c-e12caa6ebb5c
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                String bug = bug();
                Log.e(TAG, bug);
            }
        }, 1100);
    }

    private String bug() {
        String str = null;
        Log.e(TAG, "get string length:" + str.length());
        return "This is not  Bug ";
    }
}
