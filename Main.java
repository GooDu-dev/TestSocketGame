import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import java.awt.Dimension;
import java.awt.Label;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.io.IOException;

import java.net.ServerSocket;
import java.net.Socket;

public class Main{
    private JFrame frame = new JFrame("Text");
    private static Main mframe;
    private ServerSocket serverSocket;
    private Server server;
    public Main(){
        frame.setSize(new Dimension(400, 600));
        frame.setLayout(new BoxLayout(frame.getContentPane(), BoxLayout.Y_AXIS));
        frame.setVisible(true);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String[] args) {
        mframe = new Main();
        mframe.createMultiplayerMenu();
    }
    public static void printText(String text){
        System.out.println(text);
    }
    public void createMultiplayerMenu(){
        clearScreen();
        JButton hostButton = new JButton("Host");
        JButton joinButton = new JButton("Join");
        hostButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                hostMenu();
            }
        });
        joinButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // TODO Auto-generated method stub
                joinMenu();
            }
        });
        frame.getContentPane().add(hostButton);
        frame.getContentPane().add(joinButton);
    }
    public void hostMenu(){
        clearScreen();
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel port = new JLabel("Port : ");
        panel.add(port);
        JLabel portNubmer = new JLabel("1234");
        panel.add(portNubmer);
        frame.getContentPane().add(panel);
        
        // start Server
        try{
            serverSocket = new ServerSocket(1234);
            server = new Server(serverSocket);
            new Thread(server).start();
            // create player1
            JTextField _textField = new JTextField();
            Client player = new Client(1234, mframe, _textField);
            // System.out.println(player);
            // Client player2 = new Client(1234, mframe, _textField);
            // Client.clients2.add(player2);
            System.out.println("All : "+Client.clients2);
            //mframe.playGame();
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    public void joinMenu(){
        clearScreen();
        JPanel panel = new JPanel();
        panel.setSize(new Dimension(400, 300));
        panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));
        JLabel port = new JLabel("Port : ");
        panel.add(port);
        JTextField field = new JTextField();
        panel.add(field);
        frame.getContentPane().add(panel);

        // join server
        field.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent evt) {
                // TODO Auto-generated method stub
                try{    
                    field.removeActionListener(this);
                    System.out.println("All : "+Client.clients2);
                    Client player2 = new Client(Integer.parseInt(field.getText()), mframe, field);
                    System.out.println("Field Text : "+field.getText());
                    System.out.println("mFrame : "+mframe);
                    System.out.println("Field : "+field);
                    System.out.println(Client.clients2);
                    // Client.clients2.add(player2);
                    System.out.println("All : "+Client.clients2);
                }    
                catch(NumberFormatException e){
                    System.out.println(e);
                }
            }
        });

    }
    public void playGame(){
        clearScreen();
        System.out.println(Client.clients2);
        frame.getContentPane().add(new Label("Play Game"));
        System.out.println(Client.clients2);
    }
    public void clearScreen() {
        frame.getContentPane().removeAll();
        frame.getContentPane().revalidate();
        frame.getContentPane().repaint();
    }
    public JFrame getFrame(){
        return frame;
    }
    public void showText(String text){
        System.out.println(text);
    }
}