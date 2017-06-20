/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myclient;

import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asintha
 */
public class MyClient {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        try {
            Socket socket=new Socket("127.0.0.1", 5050);
            
            HashMap<InetAddress, Socket> map = new HashMap<>();
            
            InetAddress address = socket.getInetAddress();
            map.put(address, socket);
            
            onlineList list = new onlineList(map);
            list.setVisible(true);
            list.setTitle("Online list (user) ");

            
        } catch (UnknownHostException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(MyClient.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
