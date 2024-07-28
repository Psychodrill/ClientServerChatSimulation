package server;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class ServerWindow extends JFrame implements ServerView{

    private static final int WINDOW_HEIGHT =300;
    private static final int WINDOW_WIDTH =330;
    private static final int WINDOW_POSX =800;
    private static final int WINDOW_POSY =300;
    private Serverable server;

    JButton btnStart =new JButton("Start");
    JButton btnExit = new JButton("Stop");
    JTextPane msgPane = new JTextPane();
    public ServerWindow(Serverable server){

        this.server=server;
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
        btnExit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                closeWindow();
            }
        });

    }
    @Override
    public void showMsg(String text) {
        msgPane.setText(text);
    }
    private void closeWindow(){
        this.dispose();
    }




}
