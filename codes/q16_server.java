/*
 * Q16: TCP Client and Server Communication Using Sockets (Server)
 * Question: Write a client-server network socket program using ServerSocket and Socket classes for two-way message passing over TCP.
 */

// File 1: TCPServer.java
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class q16_server {
    public static void main(String[] args) {
        // Bind server to TCP port 6666 (try-with-resources auto-closes ServerSocket)
        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            System.out.println("Server is waiting for client on port 6666...");
            Socket socket = serverSocket.accept(); // Blocks until a client connects
            System.out.println("Client connected!");

            // Wrap socket streams for reading/writing UTF-8 strings
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Read message sent by the client
            String clientMsg = dis.readUTF();
            System.out.println("Received from Client: " + clientMsg);

            // Send acknowledgement back to the client
            dos.writeUTF("Hello Client, message received successfully!");
            socket.close();
        } catch (IOException e) {
            System.err.println("Server Error: " + e.getMessage());
        }
    }
}
