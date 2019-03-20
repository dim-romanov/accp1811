package ru.sstu.lessons.lesson19.v1;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Start server");
        System.out.println("Server accept");
        Socket socket = serverSocket.accept();//ожидание подключения
        System.out.println("Client connect");

        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
        while (true) {
            System.out.println("Client input...");
            String s = in.readLine();//ожидание данных
            System.out.println("Client: " + s);

            System.out.println("send message");

            out.println(s);//отправка данных
            //out.println("Hi Client");
            out.flush();
        //    socket.close();

        }
       // System.out.println("Stop server");
    }
}
