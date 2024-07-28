package server;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import client.*;

public class Server implements Serverable {
    private String logs = "";
    private String filename = "logs.txt";
    private ArrayList<Clientable> clients= new ArrayList<Clientable>();
    private ServerView serverView;

    public Server (){
        this.serverView=new ServerWindow(this);
    }
    
    public void addClient(Clientable client){
        
        this.clients.add(client);
    }

    private void sendMessages(String msg){
        System.out.println(clients.size());
        for (Clientable client : clients) {
            client.receiveMsg(msg);
        }

    }
    private void recordLog(String msg){

        try(FileWriter writer = new FileWriter(filename, true)){
            writer.write(msg+"\n");
            writer.flush();
            writer.close();
        }
        catch(IOException ex){
            throw new RuntimeException("Recording failed");
        }

    }

    @Override
    public void receiveMessage(String msg) {
        logs+=String.format("%s\n", msg);
        recordLog(msg);
        serverView.showMsg(logs);
        sendMessages(msg);        

    }

    @Override
    public String connectToServer(String connString, Clientable client) {

        addClient(client);
        return "You are connected successfully!";
    }


}
