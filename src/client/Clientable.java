package client;
public interface Clientable {

    void receiveMsg(String msg);
    void sendMsg(String msg);
    void connectToServer(String str);


}
