package server;

import client.*;

public interface Serverable {

    void receiveMessage(String msg);
    String connectToServer(String connString, Clientable client);

}
