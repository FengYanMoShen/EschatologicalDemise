package net.eschatologicaldemise.cilent;

import net.eschatologicaldemise.gui.EschatologicalDemiseGUI;

public class Main {
    static Thread thread1 = new Thread();// 添加一个新线程
    static Thread thread2 = new Thread();// 添加一个新线程
    static Thread thread3 = new Thread();// 添加一个新线程
    private static String programmer = "FengYanMoShen";// 程序员："FengYanMoShen"

    static void author(String programmer){
        System.out.println(programmer);// 打印 programmer
    }

    public static void main(String[] args) {

        thread1.start();// 线程1启动
        thread2.start();// 线程2启动
        thread3.start();// 线程3启动
        System.out.println("hello world!");
        author(programmer);// 打印 programmer

        EschatologicalDemiseGUI.WindowEventLauncher();
    }
}
