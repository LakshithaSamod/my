/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netAssign3;

/**
 *
 * @author meeeeee
 */
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ThreadedDaytimeServer {

    public final static int SERVICE_PORT = 13;

    public static void main(String[] args) {

        ServerSocket server;
        Socket client;

        try {

            server = new ServerSocket(SERVICE_PORT);
            System.out.println("Server started on localhost:" + SERVICE_PORT);

            while (true) {

                client = server.accept();

                RequestProcessorThread thread = new RequestProcessorThread(client);

                Thread t = new Thread(thread);
                t.start();

            }

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
