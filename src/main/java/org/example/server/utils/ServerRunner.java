package org.example.server.utils;

import org.example.server.service.DataServicePublisher;

import java.util.Scanner;

public class ServerRunner {

    private static final Scanner scanner = new Scanner(System.in);
    private final static String STOP_SERVER_KEY = "0\uFE0F\u20E3";

    public void runServer() {
        onPublish();
        stopServer(startServer());
    }

    private void onPublish() {
        new DataServicePublisher().publish();
    }

    private String startServer() {
        System.out.print("\uD83D\uDD1B Сервер запущено...\n" +
                "Щоб зупинити сервер натисніть " + STOP_SERVER_KEY + ": ");
        return scanner.nextLine().trim();
    }

    private void stopServer(String input) {
        while (!input.equals("0")) {
            System.out.print("\uD83D\uDD04 Сервер працює..." +
                    "\nЩоб зупинити сервер натисніть " + STOP_SERVER_KEY + ": ");
            input = scanner.nextLine().trim();
        }
        System.out.println("\u274E Сервер зупинено.");
        scanner.close();
        System.exit(0);
    }
}