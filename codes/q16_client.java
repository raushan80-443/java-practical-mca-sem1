/*
 * Q16: TCP Client and Server Communication Using Sockets (Client)
 * Question: Write a client-server network socket program using ServerSocket and Socket classes for two-way message passing over TCP.
 */

// File 2: TCPClient.java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

public class q16_client {
    public static void main(String[] args) {
        // Connect to TCPServer running on localhost:6666
        try (Socket socket = new Socket("localhost", 6666)) {
            // Streams for two-way communication with the server
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
            DataInputStream dis = new DataInputStream(socket.getInputStream());

            // Send message to server
            dos.writeUTF("Hello Server!");

            // Wait for and display server's reply
            String serverMsg = dis.readUTF();
            System.out.println("Received from Server: " + serverMsg);
        } catch (IOException e) {
            System.err.println("Client Error: " + e.getMessage());
        }
    }
}
