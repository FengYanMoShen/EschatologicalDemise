package net.eschatologicaldemise.event.mouseevent;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class MouseEvent extends JFrame implements MouseListener, MouseMotionListener {
    private int x1, y1, x2, y2,x3,y3; // 鼠标坐标
    private Graphics g; // 画笔

    public MouseEvent() {
        JPanel panel = new JPanel(); // 创建一个画板
        panel.setBackground(Color.WHITE); // 设置画板背景色为白色
        add(panel); // 将画板添加到窗口中
        addMouseListener(this); // 注册鼠标监听器
        addMouseMotionListener(this); // 注册鼠标移动监听器
        g = getGraphics(); // 获取画笔对象
    }

     /**
     * Invoked when the mouse button has been clicked (pressed
     * and released) on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseClicked(java.awt.event.MouseEvent e) {
        // 鼠标点击事件
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON1) { // 如果是左键点击
            x2 = e.getX(); // 获取鼠标点击时的横坐标
            y2 = e.getY(); // 获取鼠标点击时的纵坐标
            g.drawLine(x3, y3, x2, y2); // 用画笔画一条线段，连接右键按下和左键点击的坐标点
        }
        // 鼠标点击事件
    }

    /**
     * Invoked when a mouse button has been pressed on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mousePressed(java.awt.event.MouseEvent e) {
        if (e.getButton() == java.awt.event.MouseEvent.BUTTON3) { // 如果是右键按下
            x3 = e.getX(); // 获取鼠标按下时的横坐标
            y3 = e.getY(); // 获取鼠标按下时的纵坐标
        }
        // 鼠标按下事件
        x1 = e.getX(); // 获取鼠标按下时的横坐标
        y1 = e.getY(); // 获取鼠标按下时的纵坐标
    }

    /**
     * Invoked when a mouse button has been released on a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseReleased(java.awt.event.MouseEvent e) {
        // 鼠标释放事件
    }

    /**
     * Invoked when the mouse enters a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseEntered(java.awt.event.MouseEvent e) {
        // 鼠标进入事件
    }

    /**
     * Invoked when the mouse exits a component.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseExited(java.awt.event.MouseEvent e) {
        // 鼠标退出事件
    }

    /**
     * Invoked when a mouse button is pressed on a component and then
     * dragged.  {@code MOUSE_DRAGGED} events will continue to be
     * delivered to the component where the drag originated until the
     * mouse button is released (regardless of whether the mouse position
     * is within the bounds of the component).
     * <p>
     * Due to platform-dependent Drag&amp;Drop implementations,
     * {@code MOUSE_DRAGGED} events may not be delivered during a native
     * Drag&amp;Drop operation.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseDragged(java.awt.event.MouseEvent e) {
        // 鼠标拖动事件
        x2 = e.getX(); // 获取鼠标拖动时的横坐标
        y2 = e.getY(); // 获取鼠标拖动时的纵坐标
        g.drawLine(x1, y1, x2, y2); // 用画笔画一条线段，连接两个坐标点
        x1 = x2; // 更新x1为x2，为下一次画线做准备
        y1 = y2; // 更新y1为y2，为下一次画线做准备
    }

    /**
     * Invoked when the mouse cursor has been moved onto a component
     * but no buttons have been pushed.
     *
     * @param e the event to be processed
     */
    @Override
    public void mouseMoved(java.awt.event.MouseEvent e) {
        // 鼠标移动事件
    }
}
