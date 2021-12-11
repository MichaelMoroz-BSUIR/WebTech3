package com.MichaelMoroz.server;

import com.MichaelMoroz.server.controller.ServerController;

public class Server {
    public static void main(String[] args) {
        var server = new ServerController();
        server.start();
    }
}
