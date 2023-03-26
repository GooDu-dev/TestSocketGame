import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.lang.reflect.Field;
import java.net.Socket;

import java.util.Map;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.util.HashMap;

public class User implements Runnable{

    private Socket client;

    protected static Map<Socket, User> users = new HashMap<Socket, User>();

    private BufferedReader request;
    private PrintWriter response;

    public User(Socket client){
        try{
            this.client = client;
            request = new BufferedReader(new InputStreamReader(client.getInputStream()));
            response = new PrintWriter(client.getOutputStream());
            users.put(client, this);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        while(client.isConnected()){
            Map<Socket, Client> players = Client.clients;
            // ! Error Here : clients does not add all client in Game
            // try{
            //     String text = players.get(client).getField().getText();
            //     if(text == Server.currentWord){
            //         Client.clients.get(client).mframe.getFrame().getContentPane().add(new JLabel("Congratulations"));
            //     }
            // }
            // catch(Exception e){
            //     System.out.println(Client.clients);
            //     continue;
            // }
            // try{
            //     request.readLine();
            //     for(Client c : Client.clients2){
            //         c.getMframe().playGame();
            //     }
            // }
            // catch(IOException e){
            //     System.out.println(e);
            // }
        }
    }
}