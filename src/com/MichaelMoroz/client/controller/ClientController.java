package com.MichaelMoroz.client.controller;

import com.MichaelMoroz.server.controller.ServerController;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class ClientController extends Thread {
    private PrintWriter printWriter;
    private boolean running = true;

    @Override
    public void run() {
        try {
            Socket socket = new Socket(InetAddress.getLocalHost(), ServerController.PORT);
            var input = new ClientInputController(this);
            input.start();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            printWriter = new PrintWriter(new OutputStreamWriter(socket.getOutputStream()));
            String request;
            while ((request = bufferedReader.readLine()) != null) {
                System.out.println(request);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        running = false;
    }

    public void sendMessage(String message) {
        printWriter.println(message);
        printWriter.flush();
    }

    public boolean isRunning() {
        return running;
    }
}
