package com.tian.blog.util.chat;

import com.sun.xml.internal.ws.policy.privateutil.PolicyUtils;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

public class Server {
    private ServerSocket socket = null;
    private int port = 4444;
    private boolean listenning = true;
    Vector clientSockets = new Vector();

    public Server() throws Exception {
        try {
            socket = new ServerSocket();
        } catch (IOException e) {
            System.err.println("Server failed:" + port);
            e.printStackTrace(System.err);
            System.exit(-1);
        }

        System.out.println("Server port : " + port);
        while (listenning) {
            addClient(socket.accept());
        }
        socket.close();
    }

    public void addClient(Socket socket) throws IOException {
        new ServerThread(socket, this).start();
        clientSockets.add(socket);
        send("Server : " + socket.getInetAddress().getHostAddress() + "send message");
        System.out.println("Client size : " + clientSockets.size());
    }

    public void removeClient(Socket socket) throws IOException {
        send("Server : " + socket.getInetAddress().getHostName() + "");
        clientSockets.remove(socket);
        System.out.println("Client size : " + clientSockets.size());
    }

    public void send(String msg) throws IOException{
        Socket socket = null;
        for (int i = 0;i < clientSockets.size(); i++) {
            socket = (Socket) clientSockets.get(i);
            PrintWriter pw = new PrintWriter(socket.getOutputStream(), true);
            pw.println(msg);
        }
    }

    public static void main(String[] args) throws Exception{
        new Server();
    }
}
