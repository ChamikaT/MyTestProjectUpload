/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package myChatRoom;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author asintha
 */
public class MessageReader  extends Thread{
    private ChatRoom room;
    private ObjectInputStream reader;
    public MessageReader(ChatRoom room, ObjectInputStream reader) {
        this.room=room;
        this.reader=reader;
    }
    public void run(){
        while(true){
            try {
                String msg=(String) reader.readObject();
                room.updateMessage(msg);
            } catch (IOException ex) {
                Logger.getLogger(MessageReader.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MessageReader.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
    
    
}