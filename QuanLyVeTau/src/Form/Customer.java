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

public class Customer extends JFrame {
    ConnectDB conn = new ConnectDB();
    PreparedStatement ps;
    ResultSet rs;
    JFrame jFrame = new JFrame();
    JLabel lbTitle = new JLabel("Quản Lý Đặt Vé Xe");
    JPanel jpChinh = new JPanel();
    JPanel jpTitle = new JPanel();

    JLabel lbCustomer = new JLabel("Tài khoản:");
    JLabel tfCustomer = new JLabel("ducdinh123");
    JLabel lbMV = new JLabel("Mã Vé");
    JTextField tfMV = new JTextField();
    JTextField tfmatuyen = new JTextField();
    JLabel lbnoidi = new JLabel("Nơi Đi");
    JTextField tfnoidi = new JTextField();
    JLabel lbnoiden = new JLabel("Nơi Đến");
    JTextField tfnoiden = new JTextField();
    JLabel lbLoaive = new JLabel("Loại Vé");
    JTextField tfLoaive = new JTextField();
    JLabel lbBienSoxe = new JLabel("Biển Số");
    JTextField tfBienSoxe = new JTextField();
    JLabel lbtGioKH = new JLabel("Khởi hành lúc");
    JTextField tfGioKH = new JTextField();
    JLabel lbNgayDi = new JLabel("Ngày đi");
    JDateChooser tfNgayDi = new JDateChooser();
    JLabel lbGhe = new JLabel("Số Ghế");
    JLabel tfMaGhe = new JLabel("");
    JButton bttGhe = new JButton("Chọn Ghế");

    JTable tblDSTuyen = new JTable();
    JTable tbldsdatve = new JTable();

    JButton bttDatVe = new JButton("Đặt Vé");
    JButton bttHuy = new JButton("Hủy Vé");
    JButton bttCapNhat = new JButton("Cập Nhật");
    JButton bttInf = new JButton("Thông Tin Cá Nhân");
    JButton bttThoat = new JButton("Thoát");

    JLabel txtNgayDatVeCu = new JLabel("");
    JLabel txtGheDatCu = new JLabel("");

    public Customer(){
        jFrame.setLayout(null);
        jpTitle.setLayout(null);
        Border bdTitle = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbTitle = new TitledBorder(bdTitle, "Đề Tài Cuối Kỳ Java");
        tlbTitle.setTitleFont(new Font("Times New Roman", 0, 14));
        jpTitle.setBorder(tlbTitle);
        jpTitle.setBounds(20,20,1120,80);
        jFrame.add(jpTitle);

        lbTitle.setBounds(470,20,500,40);
        lbTitle.setFont(new Font("Times New Roman", Font.BOLD, 28));
        jpTitle.add(lbTitle);
        WellcomeCustomer();

        jpChinh.setLayout(null);
        Border bdChinh = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbChinh = new TitledBorder(bdChinh, "Thông tin chính");
        tlbChinh.setTitleFont(new Font("Times New Roman", 0, 14));
        jpChinh.setBorder(tlbChinh);
        jpChinh.setBounds(20,110,1120,430);
        jFrame.add(jpChinh);

        ThongTinDatVe();
        ThongTinTuyenDuong();
        ChucNang();
        DanhSachDatVe();
        ThongTinSinhVienThucHien();
        ThoatTaiKhoan();


        jFrame.setSize(1180,720);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);
    }
    public void WellcomeCustomer(){
        lbCustomer.setBounds(960,60,100,20);
        lbCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jpTitle.add(lbCustomer);

        tfCustomer.setBounds(1030,60,100,20);
        tfCustomer.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        jpTitle.add(tfCustomer);
    }

    public void ThongTinDatVe(){
        JPanel pnDatve = new JPanel();
        pnDatve.setLayout(null);
        Border bddatve = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbdatve = new TitledBorder(bddatve, "Thông tin đặt vé");
        tlbdatve.setTitleFont(new Font("Times New Roman", 0, 14));
        pnDatve.setBorder(tlbdatve);
        pnDatve.setBounds(20,30,290,370);
        jpChinh.add(pnDatve);

        lbMV.setBounds(40,40,100,20);
        lbMV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbMV);

        tfMV.setBounds(120,40,130,20);
        tfMV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfMV.setHorizontalAlignment(JTextField.CENTER);
        tfMV.setEditable(false);
        pnDatve.add(tfMV);

        lbnoidi.setBounds(40,80,100,20);
        lbnoidi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbnoidi);

        tfnoidi.setBounds(120,80,130,20);
        tfnoidi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfnoidi.setHorizontalAlignment(JTextField.CENTER);
        tfnoidi.setEditable(false);
        pnDatve.add(tfnoidi);


        lbnoiden.setBounds(40,120,100,20);
        lbnoiden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbnoiden);

        tfnoiden.setBounds(120,120,130,20);
        tfnoiden.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfnoiden.setHorizontalAlignment(JTextField.CENTER);
        tfnoiden.setEditable(false);
        pnDatve.add(tfnoiden);

        lbtGioKH.setBounds(40,160,100,20);
        lbtGioKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbtGioKH);

        tfGioKH.setBounds(120,160,130,20);
        tfGioKH.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfGioKH.setHorizontalAlignment(JTextField.CENTER);
        tfGioKH.setEditable(false);
        pnDatve.add(tfGioKH);

        lbLoaive.setBounds(40,200,100,20);
        lbLoaive.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbLoaive);

        tfLoaive.setBounds(120,200,130,20);
        tfLoaive.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfLoaive.setHorizontalAlignment(JTextField.CENTER);
        tfLoaive.setEditable(false);
        pnDatve.add(tfLoaive);

        lbBienSoxe.setBounds(40,240,100,20);
        lbBienSoxe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbBienSoxe);

        tfBienSoxe.setBounds(120,240,130,20);
        tfBienSoxe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        tfBienSoxe.setHorizontalAlignment(JTextField.CENTER);
        tfBienSoxe.setEditable(false);
        pnDatve.add(tfBienSoxe);

        lbNgayDi.setBounds(40,280,100,20);
        lbNgayDi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbNgayDi);

        tfNgayDi.setBounds(120,280,130,20);
        tfNgayDi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(tfNgayDi);

        lbGhe.setBounds(40,320,100,20);
        lbGhe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
        pnDatve.add(lbGhe);

        bttGhe.setBounds(120,320,130,20);
        bttGhe.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnDatve.add(bttGhe);

        bttGhe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatGhe();
                DanhSachGheTrong();
            }
        });
    }

    public void DatVe(){
        try {
            String insertDV = "Insert into DatVeXe values (?,?,?,?,N'Chưa thanh toán')";
            ps = conn.connectSQL().prepareStatement(insertDV);
            ps.setString(1, tfmatuyen.getText());
            ps.setString(2, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
            ps.setString(3, tfCustomer.getText());
            ps.setString(4, tfMaGhe.getText());
            int record = ps.executeUpdate();
            if(record>0){
                try{
                    String UpdateDatVe = "Update DatGhe set TinhTrang = N'Đã Đặt' where Stt = ?";
                    ps = conn.connectSQL().prepareStatement(UpdateDatVe);
                    ps.setString(1, tfMaGhe.getText());
                    int record1 = ps.executeUpdate();
                    if(record1>0){
                        JOptionPane.showMessageDialog(rootPane, "Đặt Vé Thành Công");
                    }
                }catch (Exception e2){
                    e2.printStackTrace();
                }
            }
        }catch (Exception e1){
            e1.printStackTrace();
        }
    }

    public void HienThiDSDatVe(){
        DefaultTableModel model = (DefaultTableModel) tbldsdatve.getModel();
        model.setRowCount(0);
        model.setColumnIdentifiers(new Object[]{"Mã Vé","Ngày Đặt Vé","Nơi Đi","Nơi Đến","Loại Vé","Biển Số Xe","Giờ đi","Giá","Số Ghê","Tình Trạng Thanh Toán"});
        try{
            String selectDSDatVe = "select Distinct MaVe, DatVeXe.NgayDatVe, NoiDi, NoiDen, LOAIVE, BienSoXe, GioKhoiHanh,GIA, SoGhe, DatVeXe.TinhTrang\n" +
                    "from DatVeXe, Customer, DatGhe, NgayDat, TuyenDuong where\n" +
                    "DatVeXe.MaTuyen = TuyenDuong.MaTuyen\n" +
                    "and DatVeXe.NgayDatVe = NgayDat.NgayDatVe\n" +
                    "and DatVeXe.Stt = DatGhe.Stt\n" +
                    "and DatVeXe.Username = Customer.Username\n" +
                    "and\n" +
                    "DatVeXe.Username = ?";
            ps = conn.connectSQL().prepareStatement(selectDSDatVe);
            ps.setString(1, tfCustomer.getText());
            rs = ps.executeQuery();
            while(rs.next()){
                Object ob[] =  {rs.getString("MaVe"),rs.getString("NgayDatVe"),
                        rs.getString("NoiDi"),rs.getString("NoiDen"),
                        rs.getString("LOAIVE"),rs.getString("BienSoXe"),
                        rs.getString("GioKhoiHanh"),rs.getString("GIA"),rs.getString("SoGhe"),rs.getString("TinhTrang"),};
                model.addRow(ob);
            }

        } catch (Exception e1){
            e1.printStackTrace();
        }

        //TODO: import data từ table ds đặt vé lên JtextField
        tbldsdatve.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tbldsdatve.getSelectedRow();
                if(row>=0){
                    tfMV.setText(tbldsdatve.getValueAt(row, 0).toString());
                    txtNgayDatVeCu.setText(tbldsdatve.getValueAt(row,1).toString());
                    txtGheDatCu.setText(tbldsdatve.getValueAt(row,8).toString());
                    tfnoidi.setText(tbldsdatve.getValueAt(row, 2).toString());
                    tfnoiden.setText(tbldsdatve.getValueAt(row, 3).toString());
                    tfGioKH.setText(tbldsdatve.getValueAt(row, 6).toString());
                    tfLoaive.setText(tbldsdatve.getValueAt(row, 4).toString());
                    tfBienSoxe.setText(tbldsdatve.getValueAt(row, 5).toString());

                }
            }
        });
    }

    public void DanhSachGheTrong(){
        JFrame jfDsGhe = new JFrame();
        jfDsGhe.setLayout(null);

        JPanel pnchonghe = new JPanel();
        pnchonghe.setLayout(null);
        Border bdchonghe = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbchonghe = new TitledBorder(bdchonghe, "Chọn Ghế");
        tlbchonghe.setTitleFont(new Font("Times New Roman", 0, 14));
        pnchonghe.setBorder(tlbchonghe);
        pnchonghe.setBounds(20,20,360,240);
        jfDsGhe.add(pnchonghe);

        JLabel tfTinhTrang = new JLabel("");
        JTable tbGhe = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbGhe.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã Ghế","Ngày Đi","Ghế","Tình Trạng"});
        String tinhtrang = "Đã Đặt";

        JButton Ghe01 = new JButton("Ghế 01");
        JButton Ghe02 = new JButton("Ghế 02");
        JButton Ghe03 = new JButton("Ghế 03");
        JButton Ghe04 = new JButton("Ghế 04");
        JButton Ghe05 = new JButton("Ghế 05");
        JButton Ghe06 = new JButton("Ghế 06");
        JButton Ghe07 = new JButton("Ghế 07");
        JButton Ghe08 = new JButton("Ghế 08");
        JButton Ghe09 = new JButton("Ghế 09");
        JButton Ghe10 = new JButton("Ghế 10");

//        ImageIcon icon = new ImageIcon("image/ghe.png");

        Ghe01.setBounds(20,50,100,30);
        Ghe01.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe01);
        Ghe02.setBounds(130,50,100,30);
        Ghe02.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe02);
        Ghe03.setBounds(240,50,100,30);
        Ghe03.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe03);
        Ghe04.setBounds(20,90,100,30);
        Ghe04.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe04);
        Ghe05.setBounds(130,90,100,30);
        Ghe05.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe05);
        Ghe06.setBounds(240,90,100,30);
        Ghe06.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe06);
        Ghe07.setBounds(20,130,100,30);
        Ghe07.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe07);
        Ghe08.setBounds(130,130,100,30);
        Ghe08.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe08);
        Ghe09.setBounds(240,130,100,30);
        Ghe09.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe09);
        Ghe10.setBounds(130,170,100,30);
        Ghe10.setFont(new Font("Times New Roman", Font.BOLD, 15));
        pnchonghe.add(Ghe10);

        try{
            String selectghe = "Select * from DatGhe Where NgayDatVe=?";
            ps = conn.connectSQL().prepareStatement(selectghe);
            ps.setString(1, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
            rs = ps.executeQuery();
            while(rs.next()){
                Object ob[]= {rs.getString("Stt"),rs.getString("NgayDatVe"),
                rs.getString("SoGhe"),rs.getString("TinhTrang")};
                model.addRow(ob);
            }

            //TODO:set ghế 01
            tfTinhTrang.setText(tbGhe.getValueAt(0,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe01.setBackground(new Color(176,224,230));
                Ghe01.setEnabled(false);
            } else {
                Ghe01.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(0,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(0,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 02
            tfTinhTrang.setText(tbGhe.getValueAt(1,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe02.setBackground(new Color(176,224,230));
                Ghe02.setEnabled(false);
            } else {
                Ghe02.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(1,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(1,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 03
            tfTinhTrang.setText(tbGhe.getValueAt(2,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe03.setBackground(new Color(176,224,230));
                Ghe03.setEnabled(false);
            } else {
                Ghe03.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(2,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(2,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 04
            tfTinhTrang.setText(tbGhe.getValueAt(3,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe04.setBackground(new Color(176,224,230));
                Ghe04.setEnabled(false);
            } else {
                Ghe04.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(3,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(3,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 05
            tfTinhTrang.setText(tbGhe.getValueAt(4,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe05.setBackground(new Color(176,224,230));
                Ghe05.setEnabled(false);
            } else {
                Ghe05.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(4,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(4,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 06
            tfTinhTrang.setText(tbGhe.getValueAt(5,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe06.setBackground(new Color(176,224,230));
                Ghe06.setEnabled(false);
            } else {
                Ghe06.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(5,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(5,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 07
            tfTinhTrang.setText(tbGhe.getValueAt(6,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe07.setBackground(new Color(176,224,230));
                Ghe07.setEnabled(false);
            } else {
                Ghe07.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(6,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(6,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 08
            tfTinhTrang.setText(tbGhe.getValueAt(7,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe08.setBackground(new Color(176,224,230));
                Ghe08.setEnabled(false);
            } else {
                Ghe08.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(7,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(7,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 09
            tfTinhTrang.setText(tbGhe.getValueAt(8,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe09.setBackground(new Color(176,224,230));
                Ghe09.setEnabled(false);
            } else {
                Ghe09.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(8,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(8,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

            //TODO:set ghế 10
            tfTinhTrang.setText(tbGhe.getValueAt(9,3).toString().trim());
            if(tfTinhTrang.getText().equals(tinhtrang)){
                Ghe10.setBackground(new Color(176,224,230));
                Ghe10.setEnabled(false);
            } else {
                Ghe10.addActionListener(new ActionListener() {
                    @Override
                    public void actionPerformed(ActionEvent e) {
                        bttGhe.setText(tbGhe.getValueAt(9,2).toString());
                        tfMaGhe.setText(tbGhe.getValueAt(9,0).toString());
                        jfDsGhe.dispose();
                    }
                });
            }

        }catch (Exception e1){
            e1.printStackTrace();
        }

        jfDsGhe.setSize(420,360);
        jfDsGhe.setLocationRelativeTo(null);
        jfDsGhe.setVisible(true);
    }

    public void DatGhe(){
        try{
            String InsertNgayDat = "Insert into NgayDat values (?)";
            ps = conn.connectSQL().prepareStatement(InsertNgayDat);
            ps.setString(1, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
            int record = ps.executeUpdate();
            if(record>0){
                System.out.println("insert ngay tc");
                try{
                    String InsertGhe = "Insert into DatGhe values\n" +
                            "(?, '1', N'Trống'),\n" +
                            "(?, '2', N'Trống'),\n" +
                            "(?, '3', N'Trống'),\n" +
                            "(?, '4', N'Trống'),\n" +
                            "(?, '5', N'Trống'),\n" +
                            "(?, '6', N'Trống'),\n" +
                            "(?, '7', N'Trống'),\n" +
                            "(?, '8', N'Trống'),\n" +
                            "(?, '9', N'Trống'),\n" +
                            "(?, '10', N'Trống')";
                    ps = conn.connectSQL().prepareStatement(InsertGhe);
                    ps.setString(1, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(2, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(3, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(4, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(5, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(6, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(7, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(8, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(9, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(10, ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).getText());
                    int record1 =  ps.executeUpdate();
                    if(record1>0){
                        System.out.println("insert ghe tc");
                    }
                } catch (Exception e2){
                    e2.printStackTrace();
                }
            } else {
                System.out.println("Ngay bi trung");
            }
        } catch (Exception e1){
        }
    }

    public void ThongTinTuyenDuong() {
        JPanel jpTuyen = new JPanel();
        jpTuyen.setLayout(null);
        Border bdTuyen = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbTuyen = new TitledBorder(bdTuyen, "Thông Tin Tuyến Đường");
        jpTuyen.setBorder(tlbTuyen);
        jpTuyen.setBounds(330, 30, 770, 185);
        jpChinh.add(jpTuyen);

        DefaultTableModel model = (DefaultTableModel) tblDSTuyen.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã Tuyến", "Nơi Đi", "Nơi Đến", "Biển Số Xe", "Loại Vé", "Giờ đi", "Giá"});
        JScrollPane sp = new JScrollPane(tblDSTuyen);
        sp.setBounds(20, 20, 730, 152);
        jpTuyen.add(sp);

        try {
            String selectDSTuyen = "Select * from TuyenDuong";
            ps = conn.connectSQL().prepareStatement(selectDSTuyen);
            rs = ps.executeQuery();
            while (rs.next()) {
                Object ob[] = {rs.getString("MaTuyen"), rs.getString("NoiDi"),
                        rs.getString("NoiDen"), rs.getString("BienSoXe"),
                        rs.getString("LoaiVe"), rs.getString("GioKhoiHanh"), rs.getString("GIA")};
                model.addRow(ob);
            }

        } catch (Exception e1) {
            e1.printStackTrace();
        }
        //TODO: import data từ bảng lên JtextField
        tblDSTuyen.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int row = tblDSTuyen.getSelectedRow();
                if(row>=0){
                    tfmatuyen.setText(tblDSTuyen.getValueAt(row, 0).toString());
                    tfnoidi.setText(tblDSTuyen.getValueAt(row, 1).toString());
                    tfnoiden.setText(tblDSTuyen.getValueAt(row, 2).toString());
                    tfGioKH.setText(tblDSTuyen.getValueAt(row, 5).toString());
                    tfLoaive.setText(tblDSTuyen.getValueAt(row, 4).toString());
                    tfBienSoxe.setText(tblDSTuyen.getValueAt(row, 3).toString());
                }
            }
        });
    }

    public void DanhSachDatVe(){
        JPanel jpDSDatVe = new JPanel();
        jpDSDatVe.setLayout(null);
        Border bdTuyen = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbTuyen = new TitledBorder(bdTuyen, "Danh Sách Đặt Vé");
        jpDSDatVe.setBorder(tlbTuyen);
        jpDSDatVe.setBounds(330,220,770,180);
        jpChinh.add(jpDSDatVe);

        JScrollPane sp = new JScrollPane(tbldsdatve);
        sp.setBounds(20,20,730,152);
        jpDSDatVe.add(sp);

        HienThiDSDatVe();
    }

    public void ChucNang(){
        JPanel jpChucNang = new JPanel();
        jpChucNang.setLayout(null);
        Border bdChucNang = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbChucNang = new TitledBorder(bdChucNang, "Chức Năng Chính");
        jpChucNang.setBorder(tlbChucNang);
        jpChucNang.setBounds(20,550,700,120);
        jFrame.add(jpChucNang);

        bttDatVe.setBounds(40,50,100,30);
        bttDatVe.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jpChucNang.add(bttDatVe);

        bttHuy.setBounds(150,50,100,30);
        bttHuy.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jpChucNang.add(bttHuy);

        bttCapNhat.setBounds(260,50,100,30);
        bttCapNhat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jpChucNang.add(bttCapNhat);

        bttInf.setBounds(370,50,180,30);
        bttInf.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jpChucNang.add(bttInf);

        bttThoat.setBounds(560,50,100,30);
        bttThoat.setFont(new Font("Times New Roman", Font.BOLD, 15));
        jpChucNang.add(bttThoat);

        bttDatVe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                DatVe();
                HienThiDSDatVe();
                ResetText();
            }
        });

        bttHuy.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String HuyGhe = "update DatGhe set TinhTrang = N'Trống' where NgayDatVe=? and SoGhe=?";
                    ps = conn.connectSQL().prepareStatement(HuyGhe);
                    ps.setString(1, txtNgayDatVeCu.getText());
                    ps.setString(2, txtGheDatCu.getText());
                    ps.executeUpdate();

                } catch (Exception e2){
                    e2.printStackTrace();
                }

                try{
                    String HuyVesql = "delete from DatVeXe Where MaVe = ?";
                    ps = conn.connectSQL().prepareStatement(HuyVesql);
                    ps.setString(1, tfMV.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        JOptionPane.showMessageDialog(rootPane, "Hủy Vé Thành Công");
                        HienThiDSDatVe();
                        ResetText();
                    }
                }catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });

        bttCapNhat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String ChinhSuaVesql = "update DatGhe set TinhTrang = N'Trống' where NgayDatVe=? and SoGhe=?\n" +
                            "Update DatVeXe set MaTuyen = ?, NgayDatVe=?, Stt=? where MaVe=?";
                    ps = conn.connectSQL().prepareStatement(ChinhSuaVesql);
                    ps.setString(1, txtNgayDatVeCu.getText());
                    ps.setString(2, txtGheDatCu.getText());
                    ps.setString(3, tfmatuyen.getText());
                    ps.setString(4, ((JTextField) tfNgayDi.getDateEditor().getUiComponent()).getText());
                    ps.setString(5, tfMaGhe.getText());
                    ps.setString(6, tfMV.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        try{
                            String DatGhesql = "update DatGhe set TinhTrang = N'Đã Đặt' where Stt=?";
                            ps = conn.connectSQL().prepareStatement(DatGhesql);
                            ps.setString(1, tfMaGhe.getText());
                            int records = ps.executeUpdate();
                            if(records>0){
                                JOptionPane.showMessageDialog(rootPane, "Cập Nhật Thành Công");
                                HienThiDSDatVe();
                                ResetText();
                            }
                        }catch (Exception e2) {

                        }
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }



    public void ThongTinSinhVienThucHien(){
        JPanel jpinfsv = new JPanel();
        jpinfsv.setLayout(null);
        Border bdinfsv = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbinfsv = new TitledBorder(bdinfsv, "Thông Tin Sinh Viên Thực Hiện");
        jpinfsv.setBorder(tlbinfsv);
        jpinfsv.setBounds(740,550,400,120);
        jFrame.add(jpinfsv);

        JLabel lbname = new JLabel("Họ Tên:  Đinh Hồng Đức");
        JLabel lbmasv = new JLabel("Lớp:  21IT4  -  Mã SV:  21IT269");
        lbname.setBounds(120,30,200,30);
        lbname.setFont(new Font("Times New Roman",Font.BOLD,16));
        jpinfsv.add(lbname);
        lbmasv.setBounds(100,60,250,30);
        lbmasv.setFont(new Font("Times New Roman",Font.BOLD,16));
        jpinfsv.add(lbmasv);

    }
    public void ThoatTaiKhoan(){
        bttThoat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.dispose();
                DangNhap dn = new DangNhap();
                dn.setVisible(true);
                dn.setVisible(false);
            }
        });
    }

    public void ResetText(){
        tfMV.setText("");
        tfnoidi.setText("");
        tfnoiden.setText("");
        tfGioKH.setText("");
        tfLoaive.setText("");
        tfBienSoxe.setText("");
        ((JTextField)tfNgayDi.getDateEditor().getUiComponent()).setText("");
        bttGhe.setText("Chọn Ghế");
    }

    public static void main(String[] args) {
        new Customer();
    }

}
