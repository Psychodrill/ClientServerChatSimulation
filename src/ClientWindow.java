import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientWindow extends JFrame implements Clientable{
    private static final int WINDOW_HEIGHT =320;
    private static final int WINDOW_WIDTH =360;

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
    ServerWindow server;
    JPanel panTop =new JPanel(new GridLayout(2,3));
    

    public ClientWindow(ServerWindow server) {
        
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.server = server;
        setLocationRelativeTo(server);
       // setLocation(WINDOW_POSX, WINDOW_POSY);
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
               btnLoginPressed(e);
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
        //msgPane.setText(textFieldValue);
        server.setLogsValue(textFieldValue);
        msgPane.setText(server.getLogs());
        typeField.setText("");
        //server.addClient(this);

    }
    public void btnLoginPressed(ActionEvent e) {
        panTop.setVisible(false);
        server.addClient(this);
    }

    @Override
    public void setLogs(String text) {
        msgPane.setText(text);
    }

}
