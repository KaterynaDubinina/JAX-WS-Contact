package org.example.client.utils;

import org.example.client.api.DataClient;

import java.util.Scanner;

public class ClientRunner {

    public final Scanner scanner = new Scanner(System.in);

    public void runClient() throws Exception {
        onClient(makeRequest());
    }

    public String makeRequest() {
        return scanner.nextLine().trim();
    }

    public String getResponse(String request) throws Exception {
        DataClient client = new DataClient();
        return client.runClient(request);
    }

    public void onClient(String input) throws Exception {
        if (input.equals("get")) {
            getOutput(getResponse(input));
            runClient();
        }
    }

    public void getOutput(String response) {
        System.out.println(response);
    }
}
