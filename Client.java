import java.awt.Label;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import javax.swing.JLabel;
import javax.swing.JTextField;

import java.net.Inet4Address;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Client{

    protected Main mframe;
    protected JTextField field;
    
    protected static Map<Socket, Client> clients = new HashMap<Socket, Client>();
    protected static ArrayList<Client> clients2 = Collections.synchronizedList(new);
    protected static int count = 0;

    private Socket client;
    private int port;
    private BufferedReader response;
    private PrintWriter request;

    public Client(int port, Main mframe, JTextField field){
        try{
            client = new Socket("127.0.0.1", port);
            response = new BufferedReader(new InputStreamReader(client.getInputStream()));
            request = new PrintWriter(client.getOutputStream());
            this.port = port;
            this.mframe = mframe;
            this.field = field;
            System.out.println("This : "+this);
            clients.put(client, this);
            Client.getClients2().add(this);
            count++;
            System.out.println(this+"\n"+clients2+"\n Count : "+count);
            field.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // TODO Auto-generated method stub
                    mframe.getFrame().getContentPane().add(new JLabel(clients2.toString()));
                    // for(Client c : clients.values()){
                    //     c.mframe.playGame();
                    // }
                    // for(User u : User.users.values()){
                    //     new Thread(u).start();
                    // }
                    for(Client c2 : clients2){
                        c2.mframe.playGame();
                    }
                    request.println("1");
                }
            });
            //field.getActionListeners()[0].actionPerformed(new ActionEvent(field, ActionEvent.ACTION_PERFORMED, null));
        }
        catch(IOException e){
            System.out.println(e);
        }
    }

    public Main getMframe() {
        return mframe;
    }

    public JTextField getField() {
        return field;
    }

    public static Map<Socket, Client> getClients() {
        return clients;
    }

    public static ArrayList<Client> getClients2() {
        if(clients2 == null) clients2 = new ArrayList<Client>();
        return clients2;
    }

    public Socket getClient() {
        return client;
    }

    public int getPort() {
        return port;
    }

    public BufferedReader getResponse() {
        return response;
    }

    public PrintWriter getRequest() {
        return request;
    }
    

}