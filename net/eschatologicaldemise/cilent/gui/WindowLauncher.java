package net.eschatologicaldemise.cilent.gui;

import net.eschatologicaldemise.event.mouseevent.MouseEvent;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class WindowLauncher {

    MouseEvent mouseEvent=new MouseEvent();

    public WindowLauncher(){
        ImageIcon icon = new ImageIcon(EschatologicalDemiseGUI.GUIIconPath);// 新建一个ImageIcon对象，指定图标文件的路径
        Image image = icon.getImage();// 获取ImageIcon的Image对象

        //标题
        JLabel lblNewLabel_1 = new JLabel("dogfight_Z");
        lblNewLabel_1.setForeground(Color.WHITE);
        lblNewLabel_1.setFont(new Font("宋体", Font.BOLD | Font.ITALIC, 50));



        JFrame EschatologicalDemiseFrame = new JFrame(EschatologicalDemiseGUI.TITLE);// 新建窗口和添加窗口的标题
        {   EschatologicalDemiseFrame.setIconImage(image);// 设置窗口的图标
            EschatologicalDemiseFrame.setSize(800, 600);// 设置窗口大小
            EschatologicalDemiseFrame.setLocationRelativeTo(null);// 将窗口居中显示
            EschatologicalDemiseFrame.setVisible(true);// 设置窗口可见
            //EschatologicalDemiseFrame.setExtendedState(JFrame.MAXIMIZED_BOTH);// 开启全屏模式
            //EschatologicalDemiseFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 设置窗口关闭时程序终止
   //         EschatologicalDemiseFrame.addmouseEvent();// Oop,bug!



            EschatologicalDemiseFrame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent e) {
                    EschatologicalDemiseFrame.setTitle(EschatologicalDemiseGUI.SHUTDOWN_TITLE); // 修改窗口标题成"Eschatological Demise - shutting down!"
                    System.exit(0);// 处理窗口关闭事件,终止当前正在运行的Java虚拟机，并传递一个退出状态码0给操作系统，表示正常退出。
                }
            });
        }

    }
    String title;
    public WindowLauncher(String title ,ImageIcon icon) {
        this(title);
    }

    public WindowLauncher(String title) {

    }
}
