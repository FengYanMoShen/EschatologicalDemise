package net.eschatologicaldemise.cilent.gui;

import java.awt.*;

public class EschatologicalDemiseGUI {

    protected static final Font MONOSPACED = new Font("Monospaced", 0, 12);
    protected static final String TITLE = "Eschatological Demise";
    protected static String GUIIconPath = "assets/Icon.jpg";// 程序窗口的图标
    protected static final String SHUTDOWN_TITLE = "Eschatological Demise - shutting down!";// 关闭窗口时的标题


    public void EschatologicalDemiseGUI(){
        new WindowLauncher();

    }


}
