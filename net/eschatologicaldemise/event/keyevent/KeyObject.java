package net.eschatologicaldemise.event.keyevent;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyObject extends KeyAdapter {
    /**
     * 构造一个 {@code KeyAdapter}.
     */
    protected KeyObject() {
        super();
    }

    /**
     * 当键入一个键时调用。
     * 当按下一个键后释放一个键时，会发生此事件。
     *
     * @param e
     */
    @Override
    public void keyTyped(KeyEvent e) {
        int a = e.getKeyCode();
        super.keyTyped(e);
    }

    /**
     * 按下某个键时调用。
     *
     * @param e
     */
    @Override
    public void keyPressed(KeyEvent e) {
        super.keyPressed(e);
    }

    /**
     * 当释放一个键时调用。
     *
     * @param e
     */
    @Override
    public void keyReleased(KeyEvent e) {
        super.keyReleased(e);
    }
}
