package com.tian.blog.util.chat;

import javax.swing.*;
import javax.swing.border.Border;
import java.awt.*;
import java.io.PrintWriter;

public class ChatApplet extends JApplet{
    private boolean isStandalone = false;
    JPanel jPanel1 = new JPanel();
    Border border1;
    BorderLayout borderLayout1 = new BorderLayout();
    JPanel jPanel2 = new JPanel();
    Border border2;
    BorderLayout borderLayout2 = new BorderLayout();
    JButton buttonSend = new JButton();
    JPanel jPanel3 = new JPanel();
    Border border3;
    BorderLayout borderLayout3 = new BorderLayout();
    BorderLayout borderLayout4 = new BorderLayout();
    JTextField textField = new JTextField();
    JPanel jPanel4 = new JPanel();
    Border border4;
    BorderLayout borderLayout5 = new BorderLayout();
    JScrollPane jScrollPane = new JScrollPane();
    JTextArea textMessages = new JTextArea();

    PrintWriter writer = null;

    public String getParameter(String key, String def) {
        return isStandalone ? System.getProperty(key, def) :
                (getParameter(key) != null ? getParameter(key) : def);
    }

    public ChatApplet() {}

    public void init() {
        
    }

}
