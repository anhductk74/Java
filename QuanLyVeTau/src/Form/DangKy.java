package Form;

import ConnectSQL.ConnectDB;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;

public class DangKy extends JFrame {
    ConnectDB conn = new ConnectDB();
    PreparedStatement ps;

    JFrame jf = new JFrame("Đăng Ký Tài Khoản");

    JLabel lbTitle = new JLabel("Đăng Ký");
    JLabel lbUserName = new JLabel("Tên Đăng Nhập");
    JTextField tfUserName = new JTextField();
    JLabel lbPassword = new JLabel("Mật Khẩu");
    JPasswordField tfPass = new JPasswordField();
    JLabel lbName = new JLabel("Họ Và Tên");
    JTextField tfName = new JTextField();
    JLabel lbcmnd = new JLabel("CMND");
    JTextField tfcmnd = new JTextField();
    JLabel lbGender = new JLabel("Giới tính");
    JRadioButton Female = new JRadioButton("Nữ");
    JRadioButton male = new JRadioButton("Nam");
    ButtonGroup bgGender = new ButtonGroup();
    JLabel lbDOB = new JLabel("Ngày sinh");
    JDateChooser tfDOB = new JDateChooser();
    JLabel lbAddress = new JLabel("Địa chỉ");
    JTextField tfAddress = new JTextField();
    JLabel lbSDT = new JLabel("SĐT");
    JTextField tfSDT = new JTextField();
    JButton bttDK = new JButton("Đăng Ký");
    JButton bttDN = new JButton("Đăng Nhập");
    JLabel lbyes = new JLabel("Đã có tài khoản");

    String Gender = null;

    public DangKy(){
        jf.setLayout(null);
        jf.setSize(420,650);
        jf.setLocationRelativeTo(null);

        bgGender.add(Female);
        bgGender.add(male);





        lbTitle.setBounds(160,40,150,50);
        lbTitle.setFont(new Font("Times New Roman", Font.BOLD, 28));
        jf.add(lbTitle);

        lbUserName.setBounds(40,100,150,30);
        lbUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbUserName);

        tfUserName.setBounds(160,100,180,30);
        tfUserName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfUserName);

        lbPassword.setBounds(40,150,100,30);
        lbPassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbPassword);

        tfPass.setBounds(160,150,180,30);
        tfPass.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfPass);

        lbName.setBounds(40,200,100,30);
        lbName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbName);

        tfName.setBounds(160,200,180,30);
        tfName.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfName);

        lbcmnd.setBounds(40,250,100,30);
        lbcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbcmnd);

        tfcmnd.setBounds(160,250,180,30);
        tfcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfcmnd);

        lbGender.setBounds(40,300,100,30);
        lbGender.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbGender);

        Female.setBounds(160,300,50,30);
        Female.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(Female);

        male.setBounds(230,300,70,30);
        male.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(male);

        lbDOB.setBounds(40,350,100,30);
        lbDOB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbDOB);

        tfDOB.setBounds(160,350,180,30);
        tfDOB.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfDOB);

        lbAddress.setBounds(40,400,100,30);
        lbAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbAddress);

        tfAddress.setBounds(160,400,180,30);
        tfAddress.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfAddress);

        lbSDT.setBounds(40,450,100,30);
        lbSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(lbSDT);

        tfSDT.setBounds(160,450,180,30);
        tfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 16));
        jf.add(tfSDT);

        bttDK.setBounds(50,520,140,30);
        bttDK.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jf.add(bttDK);

        bttDN.setBounds(200,520,140,30);
        bttDN.setFont(new Font("Times New Roman", Font.BOLD, 20));
        jf.add(bttDN);

        lbyes.setBounds(230,500,140,20);
        lbyes.setFont(new Font("Times New Roman", Font.BOLD, 12));
        jf.add(lbyes);

        dangkytk();
        bttDN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DangNhap dn = new DangNhap();
                dn.setVisible(true);
                dn.setVisible(false);
                jf.setVisible(false);
            }
        });
        jf.setVisible(true);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void dangkytk(){
        bttDK.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sql = "Insert into Customer values (?,?,?,?,?,?,?,?)";
                    ps = conn.connectSQL().prepareStatement(sql);
                    ps.setString(1,tfUserName.getText());
                    ps.setString(2,tfPass.getText());
                    ps.setString(3,tfName.getText());
                    ps.setString(4,tfcmnd.getText());
                    if(Female.isSelected()){
                        Gender = "Nữ";
                    } else if(male.isSelected()){
                        Gender = "Nam";
                    }
                    ps.setString(5,Gender);
                    ps.setString(6,((JTextField)tfDOB.getDateEditor().getUiComponent()).getText());
                    ps.setString(7,tfAddress.getText());
                    ps.setString(8,tfSDT.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        JOptionPane.showMessageDialog(rootPane, "Đăng Ký Thành Công");
                        DangNhap dn = new DangNhap();
                        jf.setVisible(false);
                        dn.setVisible(true);
                        dn.setVisible(false);
                    }
                } catch(Exception e1){
                    e1.printStackTrace();
                } finally {
                    try {
                        conn.connectSQL().close();
                        ps.close();
                    } catch (Exception e2) {
                        // TODO: handle exception
                        e2.printStackTrace();
                    }
                }
            }
        });
    }

}
