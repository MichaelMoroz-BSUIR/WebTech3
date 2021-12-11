package com.MichaelMoroz.client;

import com.MichaelMoroz.client.controller.ClientController;

public class Client {
    public static void main(String[] args) {
        var clientController = new ClientController();
        clientController.start();
    }
}
