package com.example.performanceopt.memoryleak;

import android.content.Context;
import android.os.Bundle;
import androidx.activity.ComponentActivity;
import androidx.annotation.Nullable;

public class StaticLeakActivity extends ComponentActivity implements DownloadManager2.DownloadListener {

    // 静态的内部类
    private static OutterClass.Inner inner;
    private static Context context;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //静态变量导致内存泄漏
        context = this;

        //静态成员导致内存泄漏
        OutterClass outterClass = new OutterClass();
        inner = outterClass.new Inner();

        //单例导致内存泄漏
        DownloadManager2.getInstance().register(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        // 忘记 unregister
//         DownloadManager2.getInstance().unregister(this);
    }

    @Override
    public void done() {

    }
}
