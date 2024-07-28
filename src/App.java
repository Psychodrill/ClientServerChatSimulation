import client.*;
import server.*;

public class App {
    public static void main(String[] args) throws Exception {
        // ServerWindow server =new ServerWindow();
        // new ClientWindow(server);
        // new ClientWindow(server);
        Server server =new Server();
        new Client(server);
        new Client(server);

    }
}
