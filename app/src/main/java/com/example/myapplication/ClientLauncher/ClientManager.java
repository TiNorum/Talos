package com.example.myapplication.ClientLauncher;

import com.example.myapplication.ClientLauncher.Core.resource;
import com.example.myapplication.Instruments.Constants;

import java.net.InetAddress;
import java.net.UnknownHostException;

public class ClientManager {

    private ClientManager() {
    }

    public static String send_server(String message) throws UnknownHostException, InterruptedException {
        resource r = new resource(message + "+");
        InetAddress host = InetAddress.getByName(Constants.HOST);
        Client client = new Client(host, Constants.PORT, r);
        client.start();

        client.join();

        return r.getAnswer();
    }
}
