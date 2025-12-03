package chatting.application;

import javax.swing.*;
import javax.swing.border.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;
import java.net.*;
import java.io.*;

public class Server {

    JFrame f = new JFrame();
    JTextField text;
    JPanel a1;
    JScrollPane sp;
    DataOutputStream dout;

    Server() {
        f.setLayout(null);
        JPanel p1 = new JPanel();
        p1.setBackground(new Color(7,94,84));
        p1.setBounds(0,0,450,70);
        p1.setLayout(null);
        f.add(p1);

        JLabel back = new JLabel(new ImageIcon(new ImageIcon(ClassLoader.getSystemResource("icons/3.png")).getImage().getScaledInstance(25,25,Image.SCALE_DEFAULT)));
        back.setBounds(5,20,25,25);
        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent ae) { System.exit(0); }
        });
        p1.add(back);

        JLabel name = new JLabel("Gaitonde");
        name.setBounds(110,15,150,18);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN_SERIF",Font.BOLD,18));
        p1.add(name);

        JLabel status = new JLabel("Active Now");
        status.setBounds(110,35,100,18);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("SAN_SERIF",Font.PLAIN,14));
        p1.add(status);

        a1 = new JPanel();
        a1.setLayout(new BoxLayout(a1, BoxLayout.Y_AXIS));
        sp = new JScrollPane(a1);
        sp.setBounds(5,75,440,570);
        sp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        f.add(sp);

        text = new JTextField();
        text.setBounds(5,655,310,40);
        text.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(text);

        JButton send = new JButton("Send");
        send.setBounds(320,655,123,40);
        send.setBackground(new Color(7,94,84));
        send.setForeground(Color.WHITE);
        send.setFont(new Font("SAN_SERIF",Font.PLAIN,16));
        f.add(send);

        send.addActionListener(e -> sendMessage());

        f.setSize(450,700);
        f.setLocation(200,50);
        f.setUndecorated(true);
        f.getContentPane().setBackground(Color.WHITE);
        f.setVisible(true);

        new Thread(this::startServer).start();
    }

    private void sendMessage() {
        try {
            String msg = text.getText();
            if (!msg.isEmpty()) {
                JPanel panel = formatLabel(msg, true);
                a1.add(panel);
                a1.revalidate();
                a1.repaint();

                dout.writeUTF(msg); // send to client
                text.setText("");
            }
        } catch(Exception e){ e.printStackTrace(); }
    }

    private void startServer() {
        try {
            ServerSocket skt = new ServerSocket(6001);
            Socket s = skt.accept();
            DataInputStream din = new DataInputStream(s.getInputStream());
            dout = new DataOutputStream(s.getOutputStream());

            while(true) {
                String msg = din.readUTF();
                SwingUtilities.invokeLater(() -> {
                    JPanel panel = formatLabel(msg, false);
                    a1.add(panel);
                    a1.revalidate();
                    a1.repaint();
                });
            }
        } catch(Exception e){ e.printStackTrace(); }
    }

    private JPanel formatLabel(String msg, boolean isSent) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 150px\">" + msg + "</p></html>");
        output.setFont(new Font("Tahoma",Font.PLAIN,16));
        output.setOpaque(true);
        output.setBackground(isSent? new Color(37,211,102):Color.LIGHT_GRAY);
        output.setBorder(new EmptyBorder(10,10,10,10));

        panel.add(output);

        JLabel time = new JLabel(new SimpleDateFormat("HH:mm").format(new Date()));
        time.setFont(new Font("SAN_SERIF",Font.PLAIN,10));
        panel.add(time);

        panel.setAlignmentX(isSent? Component.RIGHT_ALIGNMENT : Component.LEFT_ALIGNMENT);
        return panel;
    }

    public static void main(String[] args) {
        new Server();
    }
}
