package com.example.performanceopt.idlehandler;

import android.util.Log;

public class WebviewInitTask implements Runnable {

    @Override
    public void run() {
        Log.i("minfo", "初始化Webview");
    }
}
