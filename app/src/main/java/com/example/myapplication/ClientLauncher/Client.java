package com.example.myapplication.ClientLauncher;

import com.example.myapplication.ClientLauncher.Core.*;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

 class Client extends Thread {
     private final InetAddress host;
     private final int port;
     private resource res ;

    private Socket socket;

    public Client(InetAddress host, int port,resource res) {
        this.host = host;
        this.port = port;
        this.res = res;

    }

    public void connection() {

        //Создаем клиентский сокет
        try {
            socket = new Socket(this.host, this.port);
            System.out.println(Thread.currentThread().getName());
            this.res.setAnswer(this.sendRequest(this.res.getMessage()));

        } catch (IOException e) {
            e.printStackTrace();

        }
    }

    //отправляем запрос
    private String sendRequest(String message) throws IOException {

        final int messageId;
        final String[] answer = new String[1];

        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {

                try {
                    MessageWriter writer = new MessageWriter(socket.getOutputStream());
                    writer.writeMessage(message);

                    //Получаем ответ
                    MessageReader reader = new MessageReader(socket.getInputStream());
                    answer[0] = reader.readMessage();

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        thread.run();


        return answer[0];
    }

    @Override
    public void run() {

         connection();
    }
}
