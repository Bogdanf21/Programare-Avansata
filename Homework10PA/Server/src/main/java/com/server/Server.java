package com.server;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int PORT = 8100;
    static ServerSocket serverSocket = null;

    Server() throws IOException {
        try {
            serverSocket = new ServerSocket(PORT);
            while (true) {
                if(!serverSocket.isClosed()) {
                    System.out.println("Waiting for a client...");
                    Socket socket = serverSocket.accept();
                    ClientThread clientThread = new ClientThread(socket);
                    clientThread.start();
                }
                else
                    break;
            }
        } catch (IOException e) {
            if(e.getMessage().equalsIgnoreCase("Socket closed"))
                System.out.println(e.getMessage());
            else
            e.printStackTrace();
        } finally {
            serverSocket.close();
        }
    }
    public static void stopServer() throws IOException {
        serverSocket.close();
    }


    public static void main(String[] args) throws IOException {
            Server server = new Server();


    }
}
