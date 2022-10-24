/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netAssign3;

/**
 *
 * @author meeee
 */
import netAssign3.RequestProcessorThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolDaytimeServer {

    public static final int SERVICE_PORT = 13;

    public static void main(String[] args) {

        ExecutorService executorService = Executors.newFixedThreadPool(200);

        ServerSocket server;
        Socket client;

        try {

            server = new ServerSocket(SERVICE_PORT);
            System.out.println("Server started on localhost:" + SERVICE_PORT);

            while (true) {

                client = server.accept();

                RequestProcessorThread thread = new RequestProcessorThread(client);

                executorService.execute(thread);

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
