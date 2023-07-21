package net.eschatologicaldemise;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Main {

    static void WindowEventLauncher(){
        // 创建一个ImageIcon对象，指定图标文件的路径
        ImageIcon icon = new ImageIcon("D:/61.jpg");

        // 获取ImageIcon的Image对象
        Image image = icon.getImage();



        JFrame jFrame = new JFrame("1");// 设置窗口的标题
        jFrame.setIconImage(image);// 设置窗口的图标

        jFrame.setVisible(true);//显示窗口
        jFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);// 全屏模式
        jFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                // 处理窗口关闭事件
                System.exit(0);// 窗口关闭
            }
        });
    }

    public static void main(String[] args) {
        System.out.println("hello world!");
        WindowEventLauncher();
    }
}
