/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package netAssign3;

/**
 *
 */
import java.io.*;
import java.net.Socket;
import java.util.Date;

public class RequestProcessorThread implements Runnable {

    private final Socket client;

    public RequestProcessorThread(Socket client) {
        this.client = client;
    }

    @Override
    public void run() {

        try {

            Date daytime = new Date();
            DataOutputStream out = new DataOutputStream(client.getOutputStream());

            out.writeUTF(daytime.toString());
            out.flush();

            out.close();
            client.close();

            System.out.println("Client served:" + client);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
