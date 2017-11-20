package com.tian.blog.util.chat;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ServerThread extends Thread {
    private Server server;
    private Socket socket;
    private Protocol protocol;
    private String userId;

    public ServerThread(Socket socket, Server server) {
        this.socket = socket;
        this.server = server;
        userId = socket.getInetAddress().getHostName();
        protocol = new Protocol(userId);
    }

    public void run() {
        PrintWriter printWriter = null;
        BufferedReader reader = null;
        String inputLine, outputLine;

        try {
            printWriter = new PrintWriter(socket.getOutputStream(), true);
            reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter.println("Server is opening.....");

            while ((inputLine = reader.readLine()) != null) {
                outputLine = protocol.processInput(inputLine);
                server.send(outputLine);
            }
        } catch (IOException e) {
            e.printStackTrace(System.err);
            close();
        }
    }

    public void close() {
        try {
            server.removeClient(socket);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace(System.err);
        }
    }

}
