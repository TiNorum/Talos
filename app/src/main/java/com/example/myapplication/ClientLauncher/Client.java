package com.example.myapplication.ClientLauncher;


import com.example.myapplication.ClientLauncher.Core.MessageReader;
import com.example.myapplication.ClientLauncher.Core.MessageWriter;
import com.example.myapplication.ClientLauncher.Core.resource;


import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

public class Client extends Thread {
     private final InetAddress host;
     private final int port;
     private resource res ;
    private Socket socket;

    public Client(InetAddress host, int port, resource res) {
        this.host = host;
        this.port = port;
        this.res = res;
    }

    public void connection() throws InterruptedException {

        //Создаем клиентский сокет
        try {
            socket = new Socket(this.host, this.port);
            System.out.println(Thread.currentThread().getName());
            sendRequest();
        } catch (IOException e) {
            e.printStackTrace();

        }
    }



    //отправляем запрос
    private void sendRequest() throws IOException, InterruptedException {

        final int messageId;


        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                MessageWriter writer = null;
                try {
                    writer = new MessageWriter(socket.getOutputStream());

                    writer.writeMessage(res.getMessage());

                    //Получаем ответ
                    MessageReader reader = new MessageReader(socket.getInputStream());
                    res.setAnswer(reader.readMessage());

                } catch (IOException e) {
                    e.printStackTrace();
                }



            }
        });

        thread.start();
        thread.join();


    };

    @Override
    public void run() {

        try {
            connection();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
