package ru.sstu.lessons.lesson8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Util {
    public int readInt() {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            try {
                System.out.print("Введите число: ");
                String s = bufferedReader.readLine();
                int a = Integer.valueOf(s);
                return a;
            } catch (IOException e) {
                System.out.println("error");
                return 0;
            } catch (NumberFormatException e) {
                System.out.println("Неверный ввод");
            }
        }

    }
}
