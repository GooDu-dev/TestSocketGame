import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class Server implements Runnable{

    protected static ArrayList<String> words = new ArrayList<String>();

    protected static String currentWord="Hello";

    private ServerSocket serverSocket;
    private Socket client;

    public Server(ServerSocket serverSocket){
        this.serverSocket = serverSocket;
    }
    public void start(){
        try{
            client = serverSocket.accept();
            new User(client);
        }
        catch(IOException e){
            System.out.println(e);
        }
    }
    @Override
    public void run() {
        // TODO Auto-generated method stub
        start();
    }
}