package ru.sstu.lessons.lesson19.v4;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

//модификация под отправку множественных сообщений
public class Client {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        InetAddress address = InetAddress.getByName("127.0.0.1");

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        System.out.print("Enter your name:");
        String name = bf.readLine();

        System.out.println("Client start");
        Socket socket = new Socket(address, 8888);//соединение с сервером
        System.out.println("Client connect");

        Thread thread = new Thread(() -> {
            while (true) {
                try {
                    ObjectInputStream in = null;
                    in = new ObjectInputStream(socket.getInputStream());
                    Message m = (Message) in.readObject();
                    System.out.println("<" + m.getAthour() + "> : " + m.getMessage());
                } catch (IOException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();

        while (true) {

            System.out.print("write message: ");
            String s = bf.readLine();

            Message m1 = new Message(name, s);

            ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
            out.writeObject(m1);
            out.flush();
        }


        //System.out.println("Client stop");
    }
}

