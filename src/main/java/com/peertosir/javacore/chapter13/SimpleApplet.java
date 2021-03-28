package com.peertosir.javacore.chapter13;

import java.applet.Applet;
import java.awt.*;

public class SimpleApplet extends Applet {
    public void paint(Graphics g) {
        g.drawString("Simple applet", 20, 20);
    }
}
