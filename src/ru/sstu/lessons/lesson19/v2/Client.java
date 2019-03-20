package ru.sstu.lessons.lesson19.v2;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
//        InetAddress address = InetAddress.getByName("localhost");
        InetAddress address = InetAddress.getByName("127.0.0.1");//соединение с сервером
        System.out.println("Client start");
        Socket socket = new Socket(address, 8888);
        System.out.println("Client connect");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        while (true) {

            //out.println("111");
            System.out.println("write message");
            String s = bf.readLine();
            System.out.println("write message");

            Message m1 = new Message("Client 1", s);
            System.out.println("Send message");

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());//потоки для отправки объектов
            out.writeObject(m1);
            out.flush();

            ObjectInputStream in = new ObjectInputStream(socket.getInputStream());//потоки для получения объектов
            Message m = (Message) in.readObject();
            System.out.println("Server: " + m);

        }

        //System.out.println("Client stop");
    }
}

