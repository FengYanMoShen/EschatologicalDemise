package net.eschatologicaldemise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {
    static Thread thread1 = new Thread();
    static Thread thread2 = new Thread();
    static Thread thread3 = new Thread();
    private static String programmer = "FengYanMoShen";
    private static final String SHUTDOWN_TITLE = "Eschatological Demise - shutting down!";

    private static String MainIconPath = "assets/Icon.jpg";

    static void author(String programmer){
        System.out.println(programmer);
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
                  /* 处理窗口关闭事件
                   * 调用Java的System类的exit方法，用于终止当前正在运行的Java虚拟机，
                   * 并传递一个退出状态码给操作系统。在这里，传递的状态码为0，表示正常退出。
                   */
                  System.exit(0);
              }
          });
    }

    public static void main(String[] args) {
        thread1.start();
        thread2.start();
        thread3.start();
        System.out.println("hello world!");

        author(programmer);
        WindowEventLauncher();
    }
}
