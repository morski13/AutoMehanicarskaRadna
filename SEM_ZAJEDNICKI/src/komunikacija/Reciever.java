/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package komunikacija;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.logging.Logger;
import java.util.logging.Level;
import java.net.Socket;

/**
 *
 * @author Korisnik
 */
public class Reciever {
    private Socket socket;

    public Reciever(Socket socket) {
        this.socket = socket;
    }
    
    public Object primi(){
        try{
        ObjectInputStream in = new ObjectInputStream(socket.getInputStream());
        return in.readObject();
        } catch(Exception ex){
            Logger.getLogger(Sender.class.getName()).log(Level.SEVERE,null,ex);
        }
        return null;
    }


}
