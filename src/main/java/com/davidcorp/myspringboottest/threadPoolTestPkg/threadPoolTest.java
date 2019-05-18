package com.davidcorp.myspringboottest.threadPoolTestPkg;

import java.util.concurrent.*;

public class threadPoolTest {
    public static void main(String[] args) {
//        Executor executor = null;// Executor框架的顶层接口，用来替代通常创建或启动线程的方法。
//        ExecutorService executorService = null;// 继承自Executor接口，提供了处理多线程的方法。
//        ScheduledExecutorService scheduledExecutorService = null;// 定时调度接口，继承自ExecutorService。
//        AbstractExecutorService abstractExecutorService = null;// 实现了ExecutorService的抽象类
//        ThreadPoolExecutor threadPoolExecutor = null;// 线程池中最核心的一个类，提供了线程池操作的基本方法。
//        Executors executors;// 线程池工厂类，可用于创建一系列有特定功能的线程池。
//        ArrayBlockingQueue arrayBlockingQueue;
//        LinkedBlockingDeque linkedBlockingDeque;

        ExecutorService service = new ThreadPoolExecutor(5, 10, 300, TimeUnit.MILLISECONDS,
                new ArrayBlockingQueue<Runnable>(5));
        //用lambda表达式编写方法体中的逻辑
        Runnable run = () -> {
            try {
                Thread.sleep(5000);
                System.out.println(Thread.currentThread().getName() + "正在执行");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        };
        for (int i = 0; i < 10; i++) {
            service.execute(run);
        }
        //这里一定要做关闭
        service.shutdown();
    }
}
