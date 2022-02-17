package Form;

import ConnectSQL.ConnectDB;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DangNhap extends JFrame {
    PreparedStatement ps;

    JFrame jf = new JFrame("Đăng Nhập");

    JLabel lbDN = new JLabel("Đăng Nhập");
    JLabel lbUser = new JLabel("Tên đăng nhập");
    JLabel lbPass = new JLabel("Mật khẩu");
    JTextField tfUser = new JTextField("");
    JPasswordField tfPass = new JPasswordField();
    JRadioButton rbManage = new JRadioButton("Quản Lý");
    JRadioButton rbCustomer = new JRadioButton("Hành Khách");
    ButtonGroup btgUser = new ButtonGroup();
    JButton bttDN = new JButton("Đăng Nhập");
    JButton bttDK = new JButton("Đăng Ký");

    public DangNhap(){
        btgUser.add(rbCustomer);
        btgUser.add(rbManage);

        lbDN.setBounds(130,60,200,50);
        lbDN.setFont(new Font("tahoma",Font.BOLD,28));
        jf.add(lbDN);

        lbUser.setBounds(50,130,150,30);
        lbUser.setFont(new Font("tahoma",Font.BOLD,16));
        jf.add(lbUser);

        tfUser.setBounds(180,130,170,30);
        tfUser.setFont(new Font("tahoma",0,16));
        jf.add(tfUser);

        lbPass.setBounds(50,180,150,30);
        lbPass.setFont(new Font("tahoma",Font.BOLD,16));
        jf.add(lbPass);

        tfPass.setBounds(180,180,170,30);
        tfPass.setFont(new Font("tahoma",0,16));
        jf.add(tfPass);


        rbCustomer.setBounds(70,230,130,30);
        rbCustomer.setFont(new Font("tahoma",0,16));
        jf.add(rbCustomer);

        rbManage.setBounds(240,230,100,30);
        rbManage.setFont(new Font("tahoma",0,16));
        jf.add(rbManage);

        bttDN.setBounds(60,280,130,30);
        bttDN.setFont(new Font("tahoma",Font.BOLD,16));
        jf.add(bttDN);

        bttDK.setBounds(210,280,130,30);
        bttDK.setFont(new Font("tahoma",Font.BOLD,16));
        jf.add(bttDK);




        bttDN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ConnectDB cnn = new ConnectDB();
                if (rbManage.isSelected()) {
                    try {

                        String sql = "Select * from Manage where Username=? and Password=?";
                        ps = cnn.connectSQL().prepareStatement(sql);
                        ps.setString(1, tfUser.getText());
                        ps.setString(2, tfPass.getText());
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("Manage");
                            Manage manage = new Manage();
                            manage.setVisible(true);
                            manage.setVisible(false);
                            manage.tfManage.setText(tfUser.getText().trim());
                        } else {
                            JOptionPane.showMessageDialog(null, "Tài khoản không chính xác");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    } finally {
                        try {
                            cnn.connectSQL().close();
                            ps.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                            e2.printStackTrace();
                        }
                    }
                }
                else if(rbCustomer.isSelected()){
                    try {
                        String sql = "Select * from Customer where Username=? and Password=?";
                        ps = cnn.connectSQL().prepareStatement(sql);
                        ps.setString(1, tfUser.getText());
                        ps.setString(2, tfPass.getText());
                        ResultSet rs = ps.executeQuery();

                        if (rs.next()) {
                            System.out.println("Customer");
                            Customer c = new Customer(tfUser);
                            c.setVisible(true);
                            c.setVisible(false);
                            jf.setVisible(false);
                        } else {
                            JOptionPane.showMessageDialog(null, "Tài khoản không chính xác");
                        }
                    } catch (Exception e1) {
                        e1.printStackTrace();
                    }
                    finally {
                        try {
                            cnn.connectSQL().close();
                            ps.close();
                        } catch (Exception e2) {
                            // TODO: handle exception
                            e2.printStackTrace();
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "Chưa chọn quyền đăng nhập");
                }
            }
        });

        bttDK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangKy dk = new DangKy();
                dk.setVisible(true);
                dk.setVisible(false);
                jf.setVisible(false);
            }
        });

        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(420,420);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);
    }

    public static void main(String[] args) {
        new DangNhap();
    }
}
