package ru.sstu.lessons.lesson19.v4;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;


//модификация под отправку множественных сообщений
public class ServerClient {
    private List<Socket> sockets = new ArrayList<>();


    public void add(Socket e) {
        sockets.add(e);
        Thread th = new Thread(() -> run(e));
        th.start();

    }

    public void sendAll(Message m) {
        for (Socket socket : sockets) {
            try {
                ObjectOutputStream out = new ObjectOutputStream(socket.getOutputStream());
                out.writeObject(new Message(m.getAthour(), m.getMessage()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    private void run(Socket e) {
        try {
            while (true) {
                ObjectInputStream in = new ObjectInputStream(e.getInputStream());
                Message m = (Message) in.readObject();
                sendAll(m);
            }

        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e1) {
            e1.printStackTrace();
        }
    }


}
