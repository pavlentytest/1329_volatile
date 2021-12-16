package ru.samsung.itschool.mdev;

import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    Класс Thread или имплементация Runnable
    synchronized
    wait() - поток в режим ожидания
    notify() - возобновление потока в режиме ожидания
    join() - ждет завершения потока
     */

    public volatile static boolean flag = false;

    public static void main(String[] args) {
        new Main().start();

    }

    public void start() {
        new Thread(gui).start();
        System.out.println("Стартует интерфейс!");
        new Thread(logic).start();
        System.out.println("Стартует логика игры!");
    }

    Runnable gui = new Runnable() {
        @Override
        public void run() {
            // отрисовка интерфейса
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Остановка интерфейса");
            flag = true;
        }
    };

    Runnable logic = new Runnable() {
        @Override
        public void run() {
            while(!flag) {
                // Логика игры
            }
            System.out.println("Стоп логика!");
        }
    };


}
