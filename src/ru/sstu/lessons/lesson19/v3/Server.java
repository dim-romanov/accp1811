package ru.sstu.lessons.lesson19.v3;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

//реализация множественного подключения
public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Start server");
        System.out.println("Server accept");
        ServerClient serverClient = new ServerClient();
        while (true) {
            Socket socket = serverSocket.accept();//ожидание подключения
            System.out.println("Client connect");
            serverClient.add(socket);

        }


        // System.out.println("Stop server");
    }
}
