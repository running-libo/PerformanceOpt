package com.example.performanceopt.memoryleak;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import androidx.activity.ComponentActivity;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

public class ThirdActivity extends ComponentActivity {

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);

        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        new MyHandler().sendEmptyMessageDelayed(2, 5000);

        //线程造成内存泄漏，使用lambda替换内名内部类
        new Thread(() -> {
            try {
                Thread.sleep(200000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        });

        //DownloadManager为静态单例
        DownloadManager.getIns().download(new DownloadListener() {
            @Override
            public void onSuc() {

            }

            @Override
            public void onFail() {

            }
        }, "path");
    }

    static class MyHandler extends Handler {
        @Override
        public void handleMessage(@NonNull Message msg) {
            super.handleMessage(msg);
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        handler.removeCallbacksAndMessages(null); //activity退出时移除消息队列所有消息和callback
    }
}
