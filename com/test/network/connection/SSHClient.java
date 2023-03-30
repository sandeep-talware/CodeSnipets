package com.test.network.connection;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SSHClient {
    public static void main(String[] args) {
        try {
            String host = "remote.server.com";
            String user = "your_username";
            String password = "your_password";
            int port = 22;

            JSch jsch = new JSch();
            Session session = jsch.getSession(user, host, port);
            session.setPassword(password);
            session.setConfig("StrictHostKeyChecking", "no");
            session.connect();

            Channel channel = session.openChannel("shell");
            channel.setInputStream(System.in);
            channel.setOutputStream(System.out);
            channel.connect();

            session.disconnect();
        } catch (JSchException e) {
            e.printStackTrace();
        }
    }
}
