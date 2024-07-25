import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ClientWindow extends JFrame {
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

    public ClientWindow(ServerWindow server) {
        //setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(server);
       // setLocation(WINDOW_POSX, WINDOW_POSY);
        setSize(WINDOW_WIDTH,WINDOW_HEIGHT);
        setTitle("Client");
        setResizable(false);
        setVisible(true);

        JPanel panTop =new JPanel(new GridLayout(2,3));
        //panTop.add(btnStart);
        //panTop.add(btnExit);

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
                panTop.setVisible(false);
            }
        });

        btnSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                
                String textFieldValue = typeField.getText();
                msgPane.setText(textFieldValue);
                server.setLogsValue(textFieldValue);
                System.out.println(server.getComponentCount());
            }
        });

    }



}
