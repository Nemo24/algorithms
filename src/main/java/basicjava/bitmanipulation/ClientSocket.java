package basicjava.bitmanipulation;

import java.io.IOException;
import java.net.*;

/**
 * Created by mahesh.govind on 2/14/16.
 */
public class ClientSocket {
    int port ;
    DatagramSocket socket = null;

    ClientSocket(int port){
        this.port = port;
        try {
            socket = new DatagramSocket(new InetSocketAddress("127.0.0.1",port));

        } catch (SocketException e) {
            e.printStackTrace();
        }

    }
    public void sendMessage(String msg) throws SocketException {
        byte [] buf              = msg.getBytes();
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(buf, buf.length, new InetSocketAddress(InetAddress.getLocalHost(), 9093));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket.send(packet);
            System.out.printf("The send string %s \n",new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    public void sendMessage2(byte [] buf) throws SocketException {
        DatagramPacket packet = null;
        try {
            packet = new DatagramPacket(buf, buf.length, new InetSocketAddress(InetAddress.getLocalHost(), 9093));
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
        try {
            socket.send(packet);
            System.out.printf("The send string %s \n",new String(buf));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public int getByteAInteger( byte input ){
        int tmp = 0;

        tmp |=input;
        return tmp;

    }
}