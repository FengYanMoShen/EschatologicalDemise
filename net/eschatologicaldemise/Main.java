package net.eschatologicaldemise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    static Thread thread1 = new Thread();// 添加一个新线程
    static Thread thread2 = new Thread();// 添加一个新线程
    static Thread thread3 = new Thread();// 添加一个新线程
    private static String programmer = "FengYanMoShen";// 程序员："FengYanMoShen"

    private static final String SHUTDOWN_TITLE = "Eschatological Demise - shutting down!";// 关闭窗口时的标题

    private static String MainIconPath = "assets/Icon.jpg";// 程序窗口的图标

    static void author(String programmer){
        System.out.println(programmer);// 打印 programmer
    }

    static void WindowEventLauncher(){

        ImageIcon icon = new ImageIcon(MainIconPath);// 新建一个ImageIcon对象，指定图标文件的路径
        Image image = icon.getImage();// 获取ImageIcon的Image对象

        JFrame jFrame = new JFrame("Eschatological Demise");// 新建窗口和添加窗口的标题
          jFrame.setIconImage(image);// 设置窗口的图标
          jFrame.setSize(800, 600);// 设置窗口大小
          jFrame.setLocationRelativeTo(null);// 将窗口居中显示
          jFrame.setVisible(true);// 设置窗口可见
          //jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);// 开启全屏模式
          //jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭时程序终止
          jFrame.addWindowListener(new WindowAdapter() {
              public void windowClosing(WindowEvent e) {
                  jFrame.setTitle(SHUTDOWN_TITLE); // 修改窗口标题成"Eschatological Demise - shutting down!"
                  System.exit(0);// 处理窗口关闭事件,终止当前正在运行的Java虚拟机，并传递一个退出状态码0给操作系统，表示正常退出。
              }
          });
    }

    public static void main(String[] args) {
        thread1.start();// 线程1启动
        thread2.start();// 线程2启动
        thread3.start();// 线程3启动
        System.out.println("hello world!");// 打印 programmer

        author(programmer);
        WindowEventLauncher();
    }
}
