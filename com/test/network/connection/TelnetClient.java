package com.test.network.connection;
import java.io.*;
import java.net.Socket;

public class TelnetClient {
    public static void main(String[] args) {
        try {
            String serverName = "remote.server.com";
            int port = 23;
            String username = "your_username";
            String password = "your_password";

            Socket socket = new Socket(serverName, port);
            InputStream inStream = socket.getInputStream();
            OutputStream outStream = socket.getOutputStream();

            BufferedReader reader = new BufferedReader(new InputStreamReader(inStream));
            PrintWriter writer = new PrintWriter(outStream, true);

            String response = reader.readLine();
            System.out.println(response);

            writer.println(username);
            response = reader.readLine();
            System.out.println(response);

            writer.println(password);
            response = reader.readLine();
            System.out.println(response);
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
