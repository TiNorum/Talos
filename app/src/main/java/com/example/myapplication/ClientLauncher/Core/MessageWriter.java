package com.example.myapplication.ClientLauncher.Core;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class MessageWriter {
    private static final int INITIAL_BUFFER_SIZE = 2048;

    // поток вывода
    private final DataOutputStream out;


    //Инициализируем поток вывода
    public MessageWriter(OutputStream os) {
        this.out = new DataOutputStream(os);
    }


    //Записываем сообщение
    public void writeMessage(final String message)
            throws IOException {

        ByteArrayOutputStream baos = new ByteArrayOutputStream(message.getBytes().length);
        DataOutputStream dos =  new DataOutputStream(baos);
        dos.writeUTF(message);

        synchronized (out) {
            baos.writeTo(out);
            out.flush();
        }

       // System.out.println("Message " + message + " sent.");
    }


}
