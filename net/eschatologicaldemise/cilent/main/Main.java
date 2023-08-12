package net.eschatologicaldemise.cilent.main;

import net.eschatologicaldemise.cilent.gui.EschatologicalDemiseGUI;

public class Main {
    static Thread thread1, thread2, thread3;// 添加3个新线程

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

        new EschatologicalDemiseGUI();
    }
}
