package com.david.thread;

public class Jixiangrenshou {

//    @Test
//    public void test(){
//
//    }

    /**
     * 创建三个线程进行分段叠加
     * 每个线程叠加四次
     *
     */
    public static void main(String[] args) {
        new Thread(new Add(1)).start();
        new Thread(new Add(2)).start();
        new Thread(new Add(3)).start();
    }
}

class Add implements Runnable{
    //定义一个线程ID
    private int threadID;
    //需要进行叠加的数字
    private static int printNum = 0;
    //构造方法获取thread的ID
    public Add(int threadID){
        this.threadID = threadID;
    }
    @Override
    public void run() {
        //需要叠加的数字小于75继续叠加
        while (printNum  < 75){
            //Add.class表示  Add 对象 = new Add（）;
            //Add.class表示Add类的一个不确定对象
            synchronized (Add.class){
                System.out.println("当前的线程是:"+"---->"+threadID+"线程");
                int index = (printNum/5%3+1);
                System.out.println("当前的数字是:"+"---->"+printNum);
                System.out.println("当前的指针是:"+"---->"+index);
                //线程ID和指针相同时可以进入叠加for循环
                if(index == threadID){
                    for ( int i = 0 ; i < 5 ; i++){
                        System.out.println("线程"+threadID+":"+(++printNum));
                    }
                    //执行完毕，唤醒其他线程
                    Add.class.notify();
                }else {
                    System.out.println("我去换个线程!");
                    try {
                        Add.class.wait();
                        //该线程不和条件，进行等待其他线程
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

    }
}
