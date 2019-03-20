package ru.sstu.lessons.lesson19;

import ru.sstu.lessons.lesson19.v4.Server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Date;
import java.util.List;

//веб-сервер
public class ServerHttp {
    public static void main(String[] args) throws IOException {
        ServerSocket serverSocket = new ServerSocket(80);
        while (true) {
            Socket socket = serverSocket.accept();
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String s = in.readLine();
            String url = "";
            while (s!=null&&!s.equals("")) {
                System.out.println("-" + s + "-");
                if (s.startsWith("GET")) {
                    url = s.substring(4);
                    url = url.substring(0, url.indexOf(" "));
                    System.out.println(url);
                }
                s = in.readLine();
            }
            System.out.println("213");
            PrintWriter writer = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));

//            writer.println("<h1>Hi</h1>");
//            writer.println("<h1>" + new Date() + "</h1>");

            if (url.equals("/") || url.equals("/index.html")) {
                writer.println("HTTP/1.0 200 OK \r\n");
                List<String> strings = Files.readAllLines(Paths.get("src/ru/sstu/lessons/lesson19/index.html"));
                for (String ss : strings) {
                    writer.println(ss);
                }
            } else if (url.equals("/about.html")) {
                writer.println("HTTP/1.0 200 OK \r\n");
                List<String> strings = Files.readAllLines(Paths.get("src/ru/sstu/lessons/lesson19/about.html"));
                for (String ss : strings) {
                    writer.println(ss);
                }
            } else {
                writer.println("HTTP/1.0 404 ERROR \r\n");
            }
            writer.flush();
            socket.close();
        }
    }
}
