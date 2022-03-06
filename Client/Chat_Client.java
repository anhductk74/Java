package Client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.Socket;

public class Chat_Client extends JFrame {
    ChatMessageSocket mSocket;
    JFrame jf = new JFrame();
    JLabel lbTitle = new JLabel("Chat Client");
    JLabel lbServerHost = new JLabel("Server Host: ");
    JTextField tfServerHost = new JTextField(10);
    JLabel lbPort = new JLabel("Port: ");
    JTextField tfPort = new JTextField(5);
    JButton bttConnect = new JButton("Connect");
    JTextPane txpMess = new JTextPane();
    JLabel lbMess = new JLabel("Message:  ");
    JTextField tfMess = new JTextField(20);
    JButton bttSend = new JButton("Send");

    public Chat_Client(){
        jf.setLayout(new BorderLayout());

        PanelNorth();
        PanelCenter();
        PanelSouth();

        jf.setSize(500,400);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public void PanelNorth(){
        JPanel pnNorth = new JPanel();
        lbTitle.setFont(new Font("tahoma", Font.BOLD,26));
        pnNorth.add(lbTitle);
        jf.add(pnNorth, BorderLayout.NORTH);
    }

    public void PanelCenter(){
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

        JPanel pnPort = new JPanel();
        pnPort.setLayout(new BoxLayout(pnPort, BoxLayout.X_AXIS));
        JPanel pnPortContai = new JPanel();
        lbServerHost.setFont(new Font("Tahoma", 0, 16));
        pnPortContai.add(lbServerHost);
        tfServerHost.setFont(new Font("Tahoma", 0, 16));
        pnPortContai.add(tfServerHost);
        tfServerHost.setText("127.0.0.1");
        lbPort.setFont(new Font("Tahoma", 0, 16));
        pnPortContai.add(lbPort);
        tfPort.setFont(new Font("Tahoma", 0, 16));
        pnPortContai.add(tfPort);
        tfPort.setText("9888");
        bttConnect.setFont(new Font("Tahoma", 0, 16));
        ButtonConnect();
        pnPortContai.add(bttConnect);
        pnPort.add(pnPortContai);
        pnCenter.add(pnPort);

        JPanel pnMess = new JPanel();
        pnMess.setLayout(new GridLayout(1,1));
        txpMess.setFont(new Font("Tahoma", 0, 16));
        JScrollPane sp = new JScrollPane(txpMess);
        sp.setPreferredSize(new Dimension(0, 200));
        pnMess.add(sp);
        pnCenter.add(pnMess);

        JLabel lbnullSouth = new JLabel("  ");
        lbnullSouth.setPreferredSize(new Dimension(0, 20));
        pnCenter.add(lbnullSouth);

        jf.add(pnCenter, BorderLayout.CENTER);
    }

    public void PanelSouth(){
        JPanel pnSouth = new JPanel();
        pnSouth.setLayout(new BoxLayout(pnSouth, BoxLayout.X_AXIS));

        lbMess.setFont(new Font("Tahoma", 0, 16));
        pnSouth.add(lbMess);
        tfMess.setFont(new Font("Tahoma", 0, 16));
        pnSouth.add(tfMess);
        JLabel lbnull = new JLabel("   ");
        pnSouth.add(lbnull);
        bttSend.setFont(new Font("Tahoma", 0, 16));
        ButtonSend();
        pnSouth.add(bttSend);

        jf.add(pnSouth, BorderLayout.SOUTH);
    }

    public void ButtonConnect(){
        bttConnect.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    int port = Integer.parseInt(tfPort.getText());
                    Socket socket = new Socket(tfServerHost.getText(), port);
                    mSocket = new ChatMessageSocket(socket, txpMess);
                    txpMess.setText(txpMess.getText()+"Connected!");
                }catch(Exception e1){
                    e1.printStackTrace();
                    JOptionPane.showMessageDialog(null, e1.getMessage());
                }
            }
        });
    }

    public void ButtonSend(){
        bttSend.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(tfMess.getText().equals("")){
                    return;
                }
                mSocket.send(tfMess.getText());
                tfMess.setText("");
            }
        });
    }

    public static void main(String[] args) {
        new Chat_Client();
    }
}
