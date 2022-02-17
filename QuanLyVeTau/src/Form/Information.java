package Form;

import ConnectSQL.ConnectDB;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Information extends JFrame {
    PreparedStatement ps;
    ConnectDB conn = new ConnectDB();
    JFrame jFrame = new JFrame("Thông tin cá nhân");
    JLabel lbTitle = new JLabel("Thông tin cá nhân");
    JLabel tfuser = new JLabel("");
    JTable tbinf = new JTable();
    public Information(JLabel tfCustomer){
        jFrame.setLayout(new BorderLayout());
        jFrame.setResizable(false);
        tfuser.setText(tfCustomer.getText());
        PanelNorth();
        PanelCenter();

        jFrame.setSize(420,420);
        jFrame.setLocationRelativeTo(null);
        jFrame.setVisible(true);
    }

    public void PanelNorth(){
        JPanel pnNorth = new JPanel();
        lbTitle.setFont(new Font("Tahoma", Font.BOLD,28));
        pnNorth.add(lbTitle);
        jFrame.add(pnNorth, BorderLayout.NORTH);
    }

    public void PanelCenter(){
        JPanel pnCenter = new JPanel();
        pnCenter.setLayout(new BoxLayout(pnCenter, BoxLayout.Y_AXIS));

        JPanel pnTop = new JPanel();
        pnCenter.add(pnTop);

        JPanel pnTK = new JPanel();
        JLabel lbTK = new JLabel("Tài Khoản: ");
        lbTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnTK.add(lbTK);
        JTextField tfTK = new JTextField(10);
        tfTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
        tfTK.setEditable(false);
        pnTK.add(tfTK);
        pnCenter.add(pnTK);

        JPanel pnName = new JPanel();
        JLabel lbName = new JLabel("Họ Tên: ");
        lbName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnName.add(lbName);
        JTextField tfName = new JTextField(10);
        tfName.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnName.add(tfName);
        pnCenter.add(pnName);

        JPanel pnCMND = new JPanel();
        JLabel lbCMND = new JLabel("CMND: ");
        lbCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnCMND.add(lbCMND);
        JTextField tfCMND = new JTextField(10);
        tfCMND.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnCMND.add(tfCMND);
        pnCenter.add(pnCMND);

        JPanel pnGender = new JPanel();
        JLabel lbGender = new JLabel("Giới Tính: ");
        lbGender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnGender.add(lbGender);
        Object[] items = {"Nam","Nữ"};
        JComboBox cbGender = new JComboBox(items);
        cbGender.setPreferredSize(new Dimension(100,25));
        String Gender = cbGender.getSelectedItem().toString();
        pnGender.add(cbGender);
        pnCenter.add(pnGender);

        JPanel pnDOB = new JPanel();
        JLabel lbDOB = new JLabel("Ngày Sinh: ");
        lbDOB.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnDOB.add(lbDOB);
        JDateChooser tfDOB = new JDateChooser();
        tfDOB.setPreferredSize(new Dimension(120,25));
        pnDOB.add(tfDOB);
        pnCenter.add(pnDOB);

        JPanel pnAddress = new JPanel();
        JLabel lbAddress = new JLabel("Địa Chỉ: ");
        lbAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnAddress.add(lbAddress);
        JTextField tfAddress = new JTextField(10);
        tfAddress.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnAddress.add(tfAddress);
        pnCenter.add(pnAddress);

        JPanel pnSDT = new JPanel();
        JLabel lbSDT = new JLabel("SĐT: ");
        lbSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnSDT.add(lbSDT);
        JTextField tfSDT = new JTextField(10);
        tfSDT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnSDT.add(tfSDT);
        pnCenter.add(pnSDT);

        JPanel pnButton = new JPanel();
        JButton bttupdate = new JButton("Cập nhật thông tin");
        pnButton.add(bttupdate);
        JButton bttChangePass = new JButton("Đổi mật khẩu");
        pnButton.add(bttChangePass);
        pnCenter.add(pnButton);

        JPanel pnbottom = new JPanel();
        pnCenter.add(pnbottom);


        DefaultTableModel model = (DefaultTableModel) tbinf.getModel();
        model.setColumnIdentifiers(new Object[] {"username","Pass","name","cmnd","gender","DOB","Diachi","SDT"});
//        Customer c = new Customer();
//        String tfuser = c.tfCustomer.getText();
        try{
            String sql = "Select * from Customer Where Username = ?";

            ps = conn.connectSQL().prepareStatement(sql);
            ps.setString(1, tfuser.getText());
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Object ob[] = {rs.getString("Username"),rs.getString("Password"),rs.getString("HoTen")
                        ,rs.getString("cmnd"),rs.getString("GioiTinh"),rs.getString("NgaySinh")
                        ,rs.getString("DiaChi"),rs.getString("SDT")};
                model.addRow(ob);
            }

            tfTK.setText(tbinf.getValueAt(0,0).toString());
            tfName.setText(tbinf.getValueAt(0,2).toString());
            tfCMND.setText(tbinf.getValueAt(0,3).toString());

            ((JTextField)tfDOB.getDateEditor().getUiComponent()).setText(tbinf.getValueAt(0,5).toString());
            tfAddress.setText(tbinf.getValueAt(0,6).toString());
            tfSDT.setText(tbinf.getValueAt(0,7).toString());
            //            cbGender.setSelectedItem(tbinf.getValueAt(1,4).toString());
            Gender = tbinf.getValueAt(0,4).toString();
            cbGender.setSelectedItem(Gender);
        }catch(Exception e1){

        }

        bttupdate.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{

                    String sql = "Update Customer set HoTen = ?, cmnd = ?, GioiTinh = ?, NgaySinh = ? ,DiaChi = ?, SDT = ? Where Username = ?";
                    ps = conn.connectSQL().prepareStatement(sql);
                    ps.setString(1, tfName.getText());
                    ps.setString(2, tfCMND.getText());
                    String gender = cbGender.getSelectedItem().toString();
                    ps.setString(3, gender);
                    ps.setString(4, ((JTextField)tfDOB.getDateEditor().getUiComponent()).getText());
                    ps.setString(5, tfAddress.getText());
                    ps.setString(6, tfSDT.getText());
                    ps.setString(7, tfTK.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        JOptionPane.showMessageDialog(null, "Cập nhật thông tin thành công");
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        changePass(bttChangePass);

        jFrame.add(pnCenter, BorderLayout.CENTER);
    }



    public void changePass(JButton bttChangePass){
        bttChangePass.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jfchangepass = new JFrame();
                jfchangepass.setLayout(new BorderLayout());
                jfchangepass.setResizable(false);

                JPanel pnchange = new JPanel();
                pnchange.setLayout(new BoxLayout(pnchange, BoxLayout.Y_AXIS));

                JPanel pnTK = new JPanel();
                JLabel lbTK = new JLabel("Tài Khoản: ");
                lbTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnTK.add(lbTK);
                JTextField tfTK = new JTextField(10);
                tfTK.setFont(new Font("Tahoma", Font.PLAIN, 14));
                tfTK.setEditable(false);
                tfTK.setText(tfuser.getText());
                pnTK.add(tfTK);
                pnchange.add(pnTK);

                JPanel pnpasscu = new JPanel();
                JLabel lbpasscu = new JLabel("Mật khẩu cũ: ");
                lbpasscu.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnpasscu.add(lbpasscu);
                JPasswordField tfpasscu = new JPasswordField(10);
                tfpasscu.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnpasscu.add(tfpasscu);
                pnchange.add(pnpasscu);

                JPanel pnpassmoi = new JPanel();
                JLabel lbpassmoi = new JLabel("Mật khẩu mới: ");
                lbpassmoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnpassmoi.add(lbpassmoi);
                JPasswordField tfpassmoi = new JPasswordField(10);
                tfpassmoi.setFont(new Font("Tahoma", Font.PLAIN, 14));
                pnpassmoi.add(tfpassmoi);
                pnchange.add(pnpassmoi);

                JButton bttOK = new JButton("OK");
                pnchange.add(bttOK);

                bttOK.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        try{
                            String Selectsql = "select * from Customer where Username = ? and Password = ?";
                            ps = conn.connectSQL().prepareStatement(Selectsql);
                            ps.setString(1, tfTK.getText());
                            ps.setString(2, tfpasscu.getText());
                            ResultSet rs = ps.executeQuery();
                            if(rs.next()){
                                try{
                                    String Updatesql = "Update Customer set Password = ? where Username = ?";
                                    ps = conn.connectSQL().prepareStatement(Updatesql);
                                    ps.setString(1, tfpassmoi.getText());
                                    ps.setString(2, tfTK.getText());
                                    int record = ps.executeUpdate();
                                    if(record>0){
                                        JOptionPane.showMessageDialog(null, "Đổi mật khẩu thành công");
                                    }

                                } catch (Exception e2){
                                    e2.printStackTrace();
                                }
                            } else {
                                JOptionPane.showMessageDialog(null, "Mật khẩu cũ không đúng");
                            }
                        }catch (Exception e1){
                            e1.printStackTrace();
                        }
                    }
                });

                jfchangepass.add(pnchange, BorderLayout.CENTER);

                jfchangepass.setSize(260,200);
                jfchangepass.setLocationRelativeTo(null);
                jfchangepass.setVisible(true);

            }
        });
    }

}
