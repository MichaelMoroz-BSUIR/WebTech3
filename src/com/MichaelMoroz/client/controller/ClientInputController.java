package com.MichaelMoroz.client.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClientInputController extends Thread {
    private final ClientController clientController;

    public ClientInputController(ClientController clientController) {
        this.clientController = clientController;
    }

    @Override
    public void run() {
        try {
            var reader = new BufferedReader(new InputStreamReader(System.in));
            while (clientController.isRunning()) {
                var response = reader.readLine();
                clientController.sendMessage(response);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
