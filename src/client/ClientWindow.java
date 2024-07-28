package client;
import javax.swing.*;

import java.awt.*;
import java.awt.event.*;


public class ClientWindow extends JFrame implements ClientView{
    private static final int WINDOW_HEIGHT =320;
    private static final int WINDOW_WIDTH =360;
    private static final int WINDOW_POSX =300;
    private static final int WINDOW_POSY =360;

    JButton btnLogin =new JButton("login");
    JButton btnSend = new JButton("send");
    //JTextArea textArea = new JTextArea();
    JTextField ipField = new JTextField();
    JTextField portField = new JTextField();
    JTextField loginField = new JTextField();
    JTextField passwordField = new JTextField();
    JTextField typeField = new JTextField();
    //JTextField msgField = new JTextField();
    JTextPane msgPane = new JTextPane();
    //ServerWindow server;
    JPanel panTop =new JPanel(new GridLayout(2,3));
    Clientable client;

    public ClientWindow(Clientable client) {
        this.client = client;
   // public ClientWindow(Clientable client) {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        //this.server = server;


        //setLocationRelativeTo(server);


       setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Client");
        setResizable(false);
        setVisible(true);
        panTop.add(ipField);
        panTop.add(portField);
        panTop.add(new JPanel());
        panTop.add(loginField);
        panTop.add(passwordField);
        panTop.add(btnLogin);
        add(panTop, BorderLayout.NORTH);

        //GridBagConstraints gridConstraints = new GridBagConstraints();
       // gridConstraints.gridwidth=2;
        JPanel panBottom =new JPanel(new GridLayout(1,4));
        panBottom.add(typeField);
        panBottom.add(btnSend);
       
        add(panBottom, BorderLayout.SOUTH);

        JPanel panMsg =new JPanel(new GridLayout());
        //panMsg.setEnabled(false);
        msgPane.setEditable(false);
        panMsg.add(msgPane);
        add(panMsg);

        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
               btnLoginPressed();
            }

        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){

                btnSendPressed();
            }
        });

        typeField.addKeyListener(new KeyListener() {
            @Override
            public void keyPressed(KeyEvent e){

                if(e.getKeyCode() == KeyEvent.VK_ENTER){
                    btnSendPressed();
                }
            }
            @Override
            public void keyTyped(KeyEvent e){
            }
            @Override
            public void keyReleased(KeyEvent e){
            }
        });

    }

    public void btnSendPressed() {
        String textFieldValue = typeField.getText();

        client.sendMsg(textFieldValue);
        typeField.setText("");

    }
    public void btnLoginPressed() {
        panTop.setVisible(false);
        //server.addClient(this);
        client.connectToServer(ipField.getText()+portField.getText()+loginField.getText()+passwordField.getText());
    }
    public void showMsg(String msg){
        msgPane.setText(msgPane.getText()+msg +"\n");
    }




}
