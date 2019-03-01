package ru.sstu.lessons.lesson12;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        System.out.println("Файлы");

        File file = new File("test1.txt");
        if (file.exists()) {
            System.out.println("exists");

            boolean b = file.delete();
            if (b) {
                System.out.println("file delete");
            } else {
                System.out.println("no delete file");
            }
        } else {
            System.out.println("no exsist");

            try {
                file.createNewFile();
                System.out.println("file create");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        File f = new File("test.txt");
        System.out.println(f.getName());
        System.out.println(f.getAbsolutePath());
        System.out.println(f.getParent());
        System.out.println(new Date(f.lastModified()));

        File d = new File("test");
        d.mkdir();

        File d2 = new File("test2/test/test");
        d2.mkdirs();
        File f3 = new File(d2.getAbsolutePath() + "/f1.ttx");
        try {
            f3.createNewFile();
            System.out.println(f3.getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
        // d.delete();
        // d2.deleteOnExit();
        System.out.println();
        File d3 = new File("/");
        File[] files = d3.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isFile()) {
                System.out.print("f ");
            } else {
                System.out.print("d ");
            }
            System.out.println(files[i].getName());
        }

        File f4 = new File("people.dat");
        for (int j = 0; j < 10; j++) {
            File d5 = new File("test2/a" + System.nanoTime());
            d5.mkdir();
            for (int i = 0; i < 10; i++) {
                File d4 = new File(d5.getAbsolutePath() + "/test" + i + ".ttt");
                try {
                    d4.createNewFile();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        f4.renameTo(new File("C:/test2/people.dat"));

        Path p1 = Paths.get("text.txt");
        Path p2 = Paths.get("test", "test2", "a.txt");
        System.out.println(p2);
        Path p3 = Paths.get("C:\\Users\\gubin.WIN-TVN29L2TUDD.001\\IdeaProjects\\accp1811\\test.txt");
        Iterator<Path> it = p3.iterator();
//        while (it.hasNext()){
//            Path p = it.next();
//
//        }

        for (Path p : p3) {
            System.out.println(p);
        }

        Files.exists(p3);
        try {
            String name = "a.txt";
            Path p4 = Paths.get(name);
            Files.createFile(p4);

            Files.getAttribute(p4,"");

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(Paths.get("a.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.delete(Paths.get("test2"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        List<String> strings = new ArrayList<>();
        strings.add("a");
        strings.add("a");
        strings.add("a");
        strings.add("a11111");
        try {
            Files.write(Paths.get("t.txt"), strings, StandardOpenOption.CREATE);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            strings = Files.readAllLines(Paths.get("t.txt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walkFileTree(Paths.get(""), new MyVisitor("ttt"));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Files.walkFileTree(Paths.get(""), new DeleteFileVisitor());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
