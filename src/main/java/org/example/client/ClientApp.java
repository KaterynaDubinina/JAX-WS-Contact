package org.example.client;

//пакет дає можливість створення графічного інтерфейсу
import org.example.client.utils.WindowDesign;

import javax.swing.*;

public class ClientApp {

    public static void main(String[] args) {

        //метод invokeLater забезпечує виконання графічних операції в окремому потоку
        //щоб уникнути проблем із синхронізацією та оновленням інтерфейсу
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                WindowDesign window = new WindowDesign();
                window.setVisible(true);
            }
        });
    }
}