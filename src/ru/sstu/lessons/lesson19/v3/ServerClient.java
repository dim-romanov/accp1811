package ru.sstu.lessons.lesson19.v3;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class ServerClient {
    private List<Socket> sockets = new ArrayList<>();


    public void add(Socket e) {
        sockets.add(e);
        Thread th = new Thread(() -> run(e));//при подключении создается поток для оптравки и получения сообщений
        th.start();

    }

    private void run(Socket e) {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(e.getInputStream());
                Message m = (Message) in.readObject();
                ObjectOutputStream out = new ObjectOutputStream(e.getOutputStream());
                out.writeObject(new Message("Server", m.getMessage()));
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


}
