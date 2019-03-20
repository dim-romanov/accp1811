package ru.sstu.lessons.lesson19.v1;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;


public class Client {
    public static void main(String[] args) throws IOException {
//        InetAddress address = InetAddress.getByName("localhost");
        InetAddress address = InetAddress.getByName("127.0.0.1");
        System.out.println("Client start");
        Socket socket = new Socket(address, 8888);//соединение с сервером
        System.out.println("Client connect");
        PrintWriter out = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));//получение данных от сервера
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));//отправка данных серверу
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));//данные из консоли
        while (true) {

            //out.println("111");
            out.println(bf.readLine());//отправка данных
            out.flush();

            String s = in.readLine();//ожидание данных
            System.out.println("Server: " + s);


        }

        //System.out.println("Client stop");
    }
}

