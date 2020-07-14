package com.example.myapplication.ClientLauncher.Core;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;

public class MessageReader {
    //Длина заголовка сообщения

    private final DataInputStream dis;

    public MessageReader(InputStream is) {
        this.dis = new DataInputStream(is);
    }

    public String readMessage() throws IOException {

        //Считываем сообщение
        String message = dis.readUTF();

        //System.out.println("Message " + message + " received.");

        return message;
    }



}
