package com.tian.blog.util.chat;

import java.io.IOException;
import java.net.Socket;

public class Client {
    Socket socket = null;
    private String host;
    private boolean connected = false;

    public boolean isConnected() {return connected;}

    public Client(ChatApplet applet) throws IOException {

    }
}
