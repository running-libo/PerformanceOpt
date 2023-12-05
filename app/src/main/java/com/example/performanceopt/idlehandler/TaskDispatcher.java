package com.example.performanceopt.idlehandler;

import android.os.Looper;
import android.os.MessageQueue;
import java.util.LinkedList;
import java.util.Queue;

public class TaskDispatcher {

    private Queue<Runnable> delayTasks = new LinkedList<>();

    private MessageQueue.IdleHandler idleHandler = () -> {
        if (delayTasks.size() > 0) {
            Runnable task = delayTasks.poll();
            if (task != null) {
                task.run();
            }
        }
        return !delayTasks.isEmpty();  //只要task任务不为空，就继续执行初始化
    };

    public TaskDispatcher addTask(Runnable task) {
        delayTasks.add(task);
        return this;
    }

    public void start() {
        Looper.myQueue().addIdleHandler(idleHandler);
    }
}
