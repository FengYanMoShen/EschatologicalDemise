package net.eschatologicaldemise.gui;

import com.mojang.logging.LogUtils;
import org.slf4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EschatologicalDemiseGUI {
    static final Logger LOGGER = LogUtils.getLogger();
    private static final Font MONOSPACED = new Font("Monospaced", 0, 12);
    private static String GUIIconPath = "assets/Icon.jpg";// 程序窗口的图标
    private static final String SHUTDOWN_TITLE = "Eschatological Demise - shutting down!";// 关闭窗口时的标题
    public static void WindowEventLauncher(){
        ImageIcon icon = new ImageIcon(GUIIconPath);// 新建一个ImageIcon对象，指定图标文件的路径
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
}
