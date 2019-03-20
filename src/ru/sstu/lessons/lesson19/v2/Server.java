package ru.sstu.lessons.lesson19.v2;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ServerSocket serverSocket = new ServerSocket(8888);
        System.out.println("Start server");
        System.out.println("Server accept");
        Socket socket = serverSocket.accept();//ожидание подключения
        System.out.println("Client connect");

        while (true) {
            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());//потоки для получения объектов
            System.out.println("Client input...");
            Message m = (Message) in.readObject();
            System.out.println("Client: " + m);

            System.out.println("send message");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());//потоки для отправки объектов
            out.writeObject(new Message("Server", m.getMessage()));
            //out.println("Hi Client");
            out.flush();
            //    socket.close();

        }
        // System.out.println("Stop server");
    }
}
