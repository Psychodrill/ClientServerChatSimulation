import java.awt.*;
import java.awt.event.*;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

public class ServerWindow extends JFrame{

    private static final int WINDOW_HEIGHT =300;
    private static final int WINDOW_WIDTH =330;
    private static final int WINDOW_POSX =800;
    private static final int WINDOW_POSY =300;
    private String logs = "";
    private String filename = "logs.txt";
    private ArrayList<Clientable> clients= new ArrayList<Clientable>(); 

    JButton btnStart =new JButton("Start");
    JButton btnExit = new JButton("Stop");
    JTextPane msgPane = new JTextPane();
    public ServerWindow(){
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Server");
        setResizable(false);
        setVisible(true);

        JPanel panBottom =new JPanel(new GridLayout(1,2));
        panBottom.add(btnStart);
        panBottom.add(btnExit);
        add(panBottom, BorderLayout.SOUTH);
        setVisible(true);

        JPanel panMsg =new JPanel(new GridLayout());
        //panMsg.setEnabled(false);
        msgPane.setEditable(false);
        panMsg.add(msgPane);
        add(panMsg);

        btnStart.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
            }
        });

    }
    public void  setLogsValue(String log){
        logs+=String.format("%s\n", log);
        recordLog(log);
        msgPane.setText(logs);
        sendMessages(logs);        

    }
    public String getLogs(){
        return logs;
    }

    public void addClient(Clientable client){
        
        this.clients.add(client);
    }

    private void sendMessages(String logs){

        for (Clientable client : clients) {
            client.setLogs(logs);;
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



}
