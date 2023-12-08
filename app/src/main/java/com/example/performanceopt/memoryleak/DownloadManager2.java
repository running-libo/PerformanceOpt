package com.example.performanceopt.memoryleak;

import java.util.ArrayList;
import java.util.List;

public class DownloadManager2 {
    private static DownloadManager2 instance;
    private List<DownloadListener> mListeners = new ArrayList<>();

    public interface DownloadListener {
        void done();
    }

    public static DownloadManager2 getInstance(){
        if (instance == null) {
            instance = new DownloadManager2();
        }
        return instance;
    }

    public void register(DownloadListener downloadListener){
        if (!mListeners.contains(downloadListener)) {
            mListeners.add(downloadListener);
        }
    }

    public void unregister(DownloadListener downloadListener){
        if (mListeners.contains(downloadListener)) {
            mListeners.remove(downloadListener);
        }
    }
}
