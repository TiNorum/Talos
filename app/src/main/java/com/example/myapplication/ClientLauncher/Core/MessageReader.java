package com.example.myapplication.ClientLauncher.Core;

import java.io.*;

public class MessageReader {
    //Длина заголовка сообщения

    private final BufferedReader dis;

    public MessageReader(InputStream is) {
        this.dis = new BufferedReader(new InputStreamReader(is));
    }

    public String readMessage() throws IOException {

        //Считываем сообщение
        String message = dis.readLine();

        System.out.println("Message " + message + " received.");

        return message;
    }



}
