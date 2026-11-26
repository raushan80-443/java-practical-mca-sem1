/*
 * Q15: Retrieve Host Name and IP Address Using InetAddress Class
 * Question: Obtain network information such as local and remote Host Name and IP Address using the Java java.net.InetAddress package.
 */

import java.net.InetAddress;
import java.net.UnknownHostException;

public class q15 {
    public static void main(String[] args) {
        try {
            // Get Local Machine Address (hostname + local IP)
            InetAddress localHost = InetAddress.getLocalHost();
            System.out.println("Local Host Name : " + localHost.getHostName());
            System.out.println("Local IP Address: " + localHost.getHostAddress());

            System.out.println("----------------------------------------");

            // Resolve a remote domain name to its IP address via DNS
            String domain = "www.ggu.ac.in";
            InetAddress remoteHost = InetAddress.getByName(domain);
            System.out.println("Domain Name     : " + domain);
            System.out.println("Remote IP Addr  : " + remoteHost.getHostAddress());

        } catch (UnknownHostException e) {
            // Thrown if host cannot be resolved (e.g., offline or invalid domain)
            System.err.println("Could not resolve host: " + e.getMessage());
        }
    }
}
