package Form;

import ConnectSQL.ConnectDB;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Home extends JFrame {
    ConnectDB conn = new ConnectDB();
    PreparedStatement ps;
    ResultSet rs;
    JFrame jf = new JFrame("Giao Diện Chính");
    JLabel lbtdn = new JLabel("");
    JFrame jfdsghe = new JFrame("Danh Sách Ghế Trống");

    JTable tbdsloaive = new JTable();
    JScrollPane spdsloaive = new JScrollPane(tbdsloaive);

    JTable tbbooking = new JTable();
    JScrollPane spbooking = new JScrollPane(tbbooking);


    JLabel lbMV = new JLabel("Mã Vé");
    JTextField tfMV = new JTextField();
    JLabel lbTuyen = new JLabel("Tuyến");
    //Object[] adress = {"Đà Nẵng - Nghệ An","Nghệ An - Đà Nẵng","Nghệ An - Hà Nội","Hà Nội - Nghệ An"};
//    JComboBox cbTuyen = new JComboBox(adress);
    JLabel tfTenTuyen = new JLabel("");
    JLabel lbLoaive = new JLabel("Loại Vé");
//    Object[] loaive = {"Người lớn","Trẻ em"};
//    JComboBox cbLoaive = new JComboBox(loaive);
    JLabel tfLoaive = new JLabel("");
    JLabel lbDateStart = new JLabel("Ngày đi");
    JDateChooser tfDateStart = new JDateChooser();
    JLabel lbMaGhe = new JLabel("Số Ghế");
    JLabel tfMaGhe = new JLabel();
    JLabel lbMaTuyen = new JLabel("Mã tuyến");
    JLabel tfmatuyen = new JLabel();
    JButton bttdsghe = new JButton("DS Ghế");
    JButton bttDelete = new JButton("Hủy");
    JButton bttChange = new JButton("Cập Nhật");


    JLabel lbMAKH = new JLabel("Mã HK");
    JTextField tfMAKH = new JTextField();
    JLabel lbName = new JLabel("Họ Tên");
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



    public Home(){
        //TODO:border information
        JPanel jpInfor = new JPanel();
        Border bdInfor = BorderFactory.createLineBorder(Color.black);
        TitledBorder titleTable = new TitledBorder(bdInfor, "Thông tin hành khách");
        titleTable.setTitleFont(new Font("Times New Roman", Font.ITALIC, 14));
        jpInfor.setBorder(titleTable);
        jpInfor.setLayout(null);
        jpInfor.setBounds(30,30,300,290);
        jf.add(jpInfor);

        bgGender.add(Female);
        bgGender.add(male);


        lbMAKH.setBounds(40,40,100,20);
        lbMAKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbMAKH);

        tfMAKH.setBounds(110,40,150,20);
        tfMAKH.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfMAKH);

        lbName.setBounds(40,70,100,20);
        lbName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbName);

        tfName.setBounds(110,70,150,20);
        tfName.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfName);

        lbcmnd.setBounds(40,100,100,20);
        lbcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbcmnd);

        tfcmnd.setBounds(110,100,150,20);
        tfcmnd.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfcmnd);

        lbGender.setBounds(40,130,100,20);
        lbGender.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbGender);

        Female.setBounds(110,125,50,30);
        Female.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(Female);

        male.setBounds(170,125,70,30);
        male.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(male);


        lbDOB.setBounds(40,160,100,20);
        lbDOB.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbDOB);

        tfDOB.setBounds(110,160,150,20);
        tfDOB.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfDOB);

        lbAddress.setBounds(40,190,100,20);
        lbAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbAddress);

        tfAddress.setBounds(110,190,150,20);
        tfAddress.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfAddress);

        lbSDT.setBounds(40,220,100,20);
        lbSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(lbSDT);

        tfSDT.setBounds(110,220,150,20);
        tfSDT.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpInfor.add(tfSDT);


        lbtdn.setBounds(40,260,100,30);
        lbtdn.setFont(new Font("tahoma",Font.BOLD,10));
        jpInfor.add(lbtdn);

        //TODO:danh sách đặt vé
        JPanel jpbookinglist = new JPanel();
        jpbookinglist.setLayout(null);
        Border bdbookinglist = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbbookinglist = new TitledBorder(bdbookinglist, "Danh sách đặt vé");
        tlbbookinglist.setTitleFont(new Font("Times New Roman",Font.ITALIC,14));
        jpbookinglist.setBorder(tlbbookinglist);
        jpbookinglist.setBounds(30,330,1200,300);
        jf.add(jpbookinglist);
        spbooking.setBounds(20,40,1160,235);
        jpbookinglist.add(spbooking);
        DefaultTableModel model = (DefaultTableModel) tbbooking.getModel();
        showallData(model);

        //Thông tin đặt vé
        JPanel jpticket = new JPanel();
        jpticket.setLayout(null);
        Border bdticket = BorderFactory.createLineBorder(Color.black);
        TitledBorder tbticket = new TitledBorder(bdticket,"Thông tin vé");
        jpticket.setBorder(tbticket);
        tbticket.setTitleFont(new Font("Times New Roman",Font.ITALIC,14));
        jpticket.setBounds(360,30,280,290);
        jf.add(jpticket);



        bttdsghe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jframedsghe();
            }
        });

        lbMV.setBounds(40,40,100,20);
        lbMV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbMV);

        tfMV.setBounds(100,38,150,25);
        tfMV.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfMV);

        lbTuyen.setBounds(40,80,100,20);
        lbTuyen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbTuyen);

        tfTenTuyen.setBounds(100,78,150,25);
        tfTenTuyen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfTenTuyen);

        lbLoaive.setBounds(40,120,100,20);
        lbLoaive.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbLoaive);

        tfLoaive.setBounds(100,118,150,25);
        tfLoaive.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfLoaive);

        lbDateStart.setBounds(40,160,100,20);
        lbDateStart.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbDateStart);

        tfDateStart.setBounds(100,158,150,25);
        tfDateStart.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfDateStart);

        lbMaGhe.setBounds(40,200,100,20);
        lbMaGhe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbMaGhe);

        tfMaGhe.setBounds(100,198,70,25);
        tfMaGhe.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfMaGhe);

        bttdsghe.setBounds(170,198,80,24);
        bttdsghe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
        jpticket.add(bttdsghe);

        lbMaTuyen.setBounds(40,240,100,20);
        lbMaTuyen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(lbMaTuyen);

        tfmatuyen.setBounds(100,240,100,20);
        tfmatuyen.setFont(new Font("Times New Roman", Font.PLAIN, 14));
        jpticket.add(tfmatuyen);

        //Danh sach ve
        JPanel jpdsloaive = new JPanel();
        jpdsloaive.setLayout(null);
        Border bdtbloaive = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbloaive = new TitledBorder(bdtbloaive,"Danh sách các loại giá vé");
        jpdsloaive.setBorder(tlbloaive);
        tlbloaive.setTitleFont(new Font("Times New Roman",Font.ITALIC,14));
        jpdsloaive.setBounds(670,30,560,190);
        jf.add(jpdsloaive);
        spdsloaive.setBounds(20,20,520,150);
        jpdsloaive.add(spdsloaive);
        showtablesticketlist();

        //TODO: Buttons
        JButton bttadd = new JButton("Đặt vé");

        bttadd.setBounds(700,250,100,30);
        bttadd.setFont(new Font("Tahoma", Font.BOLD, 14));
        jf.add(bttadd);

        //TODO:Hủy thông tin đặt vé
        bttDelete.setBounds(830,250,100,30);
        bttDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
        jf.add(bttDelete);

        bttDelete.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String sql = "DELETE FROM DatVe WHERE MaVe=?";
                    ps = conn.connectSQL().prepareStatement(sql);
                    ps.setString(1, tfMV.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        try {
                            String sql1 = "DELETE FROM Information WHERE MAKH=?";
                            ps = conn.connectSQL().prepareStatement(sql1);
                            ps.setString(1, tfMAKH.getText());
                            int record1 = ps.executeUpdate();
                            if(record1>0){
                                JOptionPane.showMessageDialog(null, "Hủy Vé Thành Công");
                                showallData(model);
                            }
                        } catch (Exception e4){
                            e4.printStackTrace();
                        }
                    }
                } catch (Exception e3){
                    e3.printStackTrace();
                }
            }
        });

        //TODO:Cật nhật lại thông tin
        bttChange.setBounds(960,250,100,30);
        bttChange.setFont(new Font("Tahoma", Font.BOLD, 14));
        jf.add(bttChange);
        bttChange.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });
        tbdsloaive.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tbdsloaive.getSelectedRow();
                if(i>=0){
                    tfmatuyen.setText(tbdsloaive.getValueAt(i, 0).toString());
                    tfTenTuyen.setText(tbdsloaive.getValueAt(i, 1).toString());
                    tfLoaive.setText(tbdsloaive.getValueAt(i, 2).toString());
                }
            }
        });
        //TODO: đặt vé
        bttadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                //TODO: them thong tin khach hang
                try{
                    String Gender = null;
                    if(Female.isSelected()){
                        Gender = Female.getText();
                    } else if(male.isSelected()){
                        Gender = male.getText();
                    }

                    String InsertInfor = "Insert into Information values (?,?,?,?,?,?,?)";
                    ps = conn.connectSQL().prepareStatement(InsertInfor);
                    ps.setString(1, tfMAKH.getText());
                    ps.setString(2, tfName.getText());
                    ps.setString(3, tfcmnd.getText());
                    ps.setString(4, Gender);
                    ps.setString(5, ((JTextField)tfDOB.getDateEditor().getUiComponent()).getText());
                    ps.setString(6, tfAddress.getText());
                    ps.setString(7, tfSDT.getText());
                    int record = ps.executeUpdate();
                if(record>0){
                    try{
                        String InsertDatVe = "Insert into DatVe values (?,?,?,?,?)";
                        ps = conn.connectSQL().prepareStatement(InsertDatVe);
                        ps.setString(1, tfMV.getText());
                        ps.setString(2, tfMAKH.getText());
                        ps.setString(3, tfmatuyen.getText());
                        ps.setString(4, tfMaGhe.getText());
                        ps.setString(5, ((JTextField)tfDateStart.getDateEditor().getUiComponent()).getText());
                        int record1 = ps.executeUpdate();
                        if(record1 > 0){
                            showaddData(model,tfMV);
                            TinhTrangGhe(tfMaGhe);
                            JOptionPane.showMessageDialog(null, "Đặt Vé Thành Công!");
                        }
                    } catch (Exception e3){
                        e3.printStackTrace();
                        JOptionPane.showMessageDialog(null, "Mã Vé Bị Trùng!");
                        try{
                            String sql = "DELETE FROM Information WHERE MAKH = ?";
                            ps = conn.connectSQL().prepareStatement(sql);
                            ps.setString(1, tfMAKH.getText());
                            ps.executeUpdate();
                        }catch (Exception e4){
                            e4.printStackTrace();
                        }
                    }
                }
                }catch(Exception e2){
                    e2.printStackTrace();
                    JOptionPane.showMessageDialog(null, "Mã Hành Khách Bị Trùng");

                }



            }
        });

        JButton bttInf = new JButton("TTHK");
        bttInf.setBounds(700,290,100,30);
        bttInf.setFont(new Font("Tahoma", Font.BOLD, 14));
        jf.add(bttInf);
        //TODO:Thông tin hành khách
        bttInf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JFrame jFrame = new JFrame();
                jFrame.setLayout(null);

                JPanel jpinf = new JPanel();
                jpinf.setLayout(null);
                Border bdinf = BorderFactory.createLineBorder(Color.black);
                TitledBorder tlbinf = new TitledBorder(bdinf,"Thông Tin Hành Khách");
                tlbinf.setTitleFont(new Font("Tahoma", Font.ITALIC,14));
                jpinf.setBorder(tlbinf);
                jpinf.setBounds(20,20,460,290);
                jFrame.add(jpinf);

                JTable tbinf = new JTable();
                JScrollPane spinf = new JScrollPane(tbinf);
                DefaultTableModel modelInf = (DefaultTableModel) tbinf.getModel();
                modelInf.setColumnIdentifiers(new Object []{"Mã Khách Hàng","Họ Tên","CMND","Giới Tính","Ngày Sinh","Địa Chỉ","SĐT"});
                spinf.setBounds(20,20,420,250);
                jpinf.add(spinf);
                try{
                    String sql = "Select * from Information";
                    ps = conn.connectSQL().prepareStatement(sql);
                    rs = ps.executeQuery();
                    while(rs.next()){
                        Object ob[] = {rs.getString("MAKH"),rs.getString("Name"),rs.getString("CMND"),
                        rs.getString("Gender"),rs.getString("Birthday"),rs.getString("Address"),rs.getString("SDT")};
                        modelInf.addRow(ob);
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
                tbinf.setModel(modelInf);

                tbinf.addMouseListener(new MouseAdapter() {
                    @Override
                    public void mouseClicked(MouseEvent e) {
                        int i = tbinf.getSelectedRow();
                        if(i>=0) {
                            tfMAKH.setText(tbinf.getValueAt(i, 0).toString());
                            tfName.setText(tbinf.getValueAt(i, 1).toString());
                            tfcmnd.setText(tbinf.getValueAt(i, 2).toString());
                            tfAddress.setText(tbinf.getValueAt(i, 5).toString());
                            tfSDT.setText(tbinf.getValueAt(i, 6).toString());
                        }
                    }
                });


                JButton bttexit = new JButton("exit");
                bttexit.setBounds(400,340,80,30);
                bttexit.setFont(new Font("Tahoma",Font.BOLD,14));
                jFrame.add(bttexit);
                bttexit.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        jFrame.dispose();
                    }
                });
                jFrame.setSize(500,400);
                jFrame.setLocationRelativeTo(null);
                jFrame.setUndecorated(true);
                jf.setResizable(false);
                jFrame.setVisible(true);


            }
        });

        tbbooking.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbbooking.getSelectedRow();
                    tfMV.setText(tbbooking.getValueAt(row, 0).toString());
                    tfMAKH.setText(tbbooking.getValueAt(row, 1).toString());
            }
        });


        jf.setLayout(null);
        jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jf.setSize(1280,720);
        jf.setResizable(false);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);

    }

    public void showtablesticketlist(){
        DefaultTableModel modeldsloaive = (DefaultTableModel) tbdsloaive.getModel();
        modeldsloaive.setColumnIdentifiers(new Object []{"Mã Tuyến","Tên Tuyến","Loại Vé","Giờ Khởi Hành","Giá"});
        ConnectDB conn = new ConnectDB();
        rs= conn.listAll("Select * from TuyenDuong");
        try {
            while (rs.next()) {
                Object data[]= {rs.getString("MATUYEN"), rs.getString("TENTUYEN"),rs.getString("LOAIVE"),rs.getString("TIMESTART"),rs.getString("GIA")};

                modeldsloaive.addRow(data);

            }
            tbdsloaive.setModel(modeldsloaive);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void showallData(DefaultTableModel model){
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[] {"Mã vé","Mã Hành Khách","Họ tên","CMND","Tuyến","Loại vé","Giá vé","Ngày đi","Giờ đi","Số ghế"});
        ConnectDB conn = new ConnectDB();
        rs= conn.listAll( "select MaVe,Information.MAKH,Name,CMND,TENTUYEN,LOAIVE,GIA,NgayDi,TIMESTART,SoGhe from DatVe, Ghe, Information, TuyenDuong\n" +
                "where DatVe.MAKH = Information.MAKH\n" +
                "\tand DatVe.MaGhe = Ghe.MaGhe\n" +
                "\tand DatVe.MATUYEN = TuyenDuong.MATUYEN");
        try {

            while (rs.next()) {
                Object data[]= {rs.getString("MaVe"),rs.getString("MAKH"), rs.getString("Name"),rs.getString("CMND"),
                        rs.getString("TENTUYEN"),rs.getString("LOAIVE"),rs.getString("GIA"),
                        rs.getString("NgayDi"),rs.getString("TIMESTART"),rs.getString("SoGhe")};

                model.addRow(data);

            }
            tbbooking.setModel(model);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void showaddData(DefaultTableModel model, JTextField tfMV){
        model.setColumnIdentifiers(new Object[] {"Mã vé","Mã Hành Khách","Họ tên","CMND","Tuyến","Loại vé","Giá vé","Ngày đi","Giờ đi","Số ghế"});
        ConnectDB conn = new ConnectDB();
         String sql = "select MaVe,Information.MAKH,Name,CMND,TENTUYEN,LOAIVE,GIA,NgayDi,TIMESTART,SoGhe from DatVe, Ghe, Information, TuyenDuong\n" +
                 "                where DatVe.MAKH = Information.MAKH \n" +
                 "                and DatVe.MaGhe = Ghe.MaGhe\n" +
                 "                and DatVe.MATUYEN = TuyenDuong.MATUYEN\n" +
                 "                and MaVe = ?";
        try {
            ps = conn.connectSQL().prepareStatement(sql);
            ps.setString(1, tfMV.getText());
            rs = ps.executeQuery();
            if (rs.next()) {
                Object data[]= {rs.getString("MaVe"),rs.getString("MAKH"), rs.getString("Name"),rs.getString("CMND"),
                        rs.getString("TENTUYEN"),rs.getString("LOAIVE"),rs.getString("GIA"),
                        rs.getString("NgayDi"),rs.getString("TIMESTART"),rs.getString("SoGhe")};

                model.addRow(data);

            }
            tbbooking.setModel(model);
        } catch (SQLException e1) {
            // TODO Auto-generated catch block
            e1.printStackTrace();
        }
    }

    public void TinhTrangGhe(JLabel tfMaGhe){
        try{
            String sql = "Update Ghe set TinhTrang = 'Đã Đặt' where MaGhe = ?";
            ps = conn.connectSQL().prepareStatement(sql);
            ps.setString(1, tfMaGhe.getText());
            ps.executeUpdate();
        } catch (Exception ex){
            ex.printStackTrace();
        }
    }

    public void jframedsghe(){
        jfdsghe.setLayout(null);

        JPanel jPanel = new JPanel();
        jPanel.setLayout(null);
        Border bdpanel = BorderFactory.createLineBorder(Color.black);
        TitledBorder titledBorder = new TitledBorder(bdpanel, "Danh Sách Ghế Trống");
        titledBorder.setTitleFont(new Font("Tahoma", Font.ITALIC,14));
        jPanel.setBounds(20,20,370,280);
        jPanel.setBorder(titledBorder);
        jfdsghe.add(jPanel);

        JTable tbdsghe = new JTable();
        JScrollPane sp = new JScrollPane(tbdsghe);
        sp.setBounds(10,20,350,250);
        jPanel.add(sp);

        DefaultTableModel model = (DefaultTableModel) tbdsghe.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã Ghế","Số Ghế","Tình Trạng"});

        try{
            String sql = "Select * from Ghe where TinhTrang=N'Trống'";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("MaGhe"),rs.getString("SoGhe"),rs.getString("TinhTrang")};
                model.addRow(ob);
            }
        }catch(Exception e1){
            e1.printStackTrace();
        }

        tbdsghe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbdsghe.getSelectedRow();
                tfMaGhe.setText(tbdsghe.getValueAt(row, 0).toString());
                jfdsghe.dispose();
            }
        });

        jfdsghe.setSize(420,360);
        jfdsghe.setLocationRelativeTo(null);
        jfdsghe.setUndecorated(true);
        jfdsghe.setVisible(true);
    }


    public static void main(String[] args) {
        new Home();
    }
}

