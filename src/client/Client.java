package client;
import server.*;

public class Client implements Clientable {

    private Serverable server;
    private boolean connected;
    private ClientView clientView;

    public Client (Serverable server){
        //this.client = client;
        this.server= server;
        this.clientView= new ClientWindow(this);

    }

    @Override
    public void receiveMsg(String text) {

        clientView.showMsg(text);
    }

    @Override
    public void sendMsg(String msg) {
        if(connected){
            server.receiveMessage(msg);
        }
        else{
            clientView.showMsg("You are not connected!");
        }
        
    }

    @Override
    public void connectToServer(String str) {
        String connectionMessage =server.connectToServer(str, this);
        clientView.showMsg(connectionMessage);
        connected=true;
    }
}
