package com.example.performanceopt.memoryleak;


import java.util.HashMap;

interface DownloadListener {
    void onSuc();

    void onFail();
}

public class DownloadManager {
    private DownloadManager() {
    }

    static class Inner {
        private static final DownloadManager ins = new DownloadManager();
    }

    public static DownloadManager getIns() {
        return Inner.ins;
    }

    private HashMap<String, DownloadListener> map = new HashMap();

    //模拟注册
    public void download(DownloadListener listener, String path) {
        map.put(path, listener);
        new Thread(() -> {
            //模拟下载
            listener.onSuc();
        }).start();
    }
}
