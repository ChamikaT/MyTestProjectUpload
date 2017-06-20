/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myChatRoom;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asintha
 */
public class MyServer {

    public static HashMap<InetAddress, Socket> map;

    /**
     * @param args the command line arguments
     */

    public static void main(String[] args) {
        
        
        try {
            ServerSocket serverSocket = new ServerSocket(5050);
            System.out.println("server starting...");

            map = new HashMap<>();

            onlineList list = new onlineList(map);
            list.setVisible(true);
            list.setTitle("Online list (ServerADK) ");

//while loop
            Socket socket = serverSocket.accept();
            InetAddress address = socket.getInetAddress();
            map.put(address, socket);
            list.updateList(map);
            

        } catch (IOException ex) {
            Logger.getLogger(MyServer.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
     
}
