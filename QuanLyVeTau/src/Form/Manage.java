package Form;
import ConnectSQL.ConnectDB;
import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Manage extends JFrame {
    ConnectDB conn = new ConnectDB();
    PreparedStatement ps;
    ResultSet rs;
    JFrame jFrame = new JFrame();
    JLabel lbManage = new JLabel("Manager:");
    JLabel tfManage = new JLabel("");
    JLabel lbTitle = new JLabel("Thông Tin Đặt Vé");
    JLabel lbMaKH = new JLabel("Mã Vé");
    JTextField tfMV = new JTextField();
    JLabel lbName = new JLabel("Tên KH");
    JTextField tfName = new JTextField();
    JLabel lbnoidi = new JLabel("Nơi Đi");
    JTextField tfnoidi = new JTextField();
    JLabel lbnoiden = new JLabel("Nơi Đến");
    JTextField tfnoiden = new JTextField();
    JLabel lbLoaive = new JLabel("Loại Vé");
    JTextField tfLoaive = new JTextField();
    JLabel lbBienSoxe = new JLabel("Biển Số");
    JTextField tfBienSoxe = new JTextField();
    JLabel lbtGioKH = new JLabel("Giờ đi");
    JTextField tfGioKH = new JTextField();
    JLabel lbNgayDi = new JLabel("Ngày đi");
    JTextField tfNgayDi = new JTextField();
    JLabel lbGhe = new JLabel("Số Ghế");
    JTextField tfGhe = new JTextField();
    JTable tbdsDatVe = new JTable();
    String itemtimkiem[] = {"Mã vé","Tên đăng nhập","Tên hành khách"};
    JComboBox cbtimkiem = new JComboBox(itemtimkiem);
    JTextField timkiem = new JTextField();
    JTextField tftimkiem = new JTextField();
    JButton bttTimkiem = new JButton("Tìm kiếm");
    JButton bttThanhtoan = new JButton("Thanh toán");
    JButton bttThongKe = new JButton("Thống kê");
    JButton bttDangXuat = new JButton("Đăng xuất");
    public Manage(){
        jFrame.setLayout(null);
        jFrame.setResizable(false);

        lbManage.setFont(new Font("Times New Roman", Font.BOLD,17));
        lbManage.setBounds(930,65,150,30);
        jFrame.add(lbManage);
        tfManage.setFont(new Font("Times New Roman", Font.BOLD,17));
        tfManage.setBounds(1005,65,150,30);
        jFrame.add(tfManage);

        ThongTinDatVe();
        DSDatVe();
        chucnang();


        jFrame.setSize(1180,700);
        jFrame.setLocationRelativeTo(null);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setVisible(true);

    }
    public void ThongTinDatVe(){
        lbTitle.setFont(new Font("Times New Roman", Font.BOLD,32));
        lbTitle.setBounds(450,50,300,50);
        jFrame.add(lbTitle);

        lbMaKH.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbMaKH.setBounds(70,130,100,30);
        jFrame.add(lbMaKH);

        tfMV.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfMV.setBounds(150,130,200,25);
        tfMV.setEditable(false);
        jFrame.add(tfMV);

        lbName.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbName.setBounds(70,180,100,30);
        jFrame.add(lbName);

        tfName.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfName.setBounds(150,180,200,25);
        jFrame.add(tfName);

        lbNgayDi.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbNgayDi.setBounds(70,230,100,30);
        jFrame.add(lbNgayDi);

        tfNgayDi.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfNgayDi.setBounds(150,230,200,25);
        jFrame.add(tfNgayDi);

        lbnoidi.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbnoidi.setBounds(450,130,100,30);
        jFrame.add(lbnoidi);

        tfnoidi.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfnoidi.setBounds(520,130,200,25);
        jFrame.add(tfnoidi);

        lbnoiden.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbnoiden.setBounds(450,180,100,30);
        jFrame.add(lbnoiden);

        tfnoiden.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfnoiden.setBounds(520,180,200,25);
        jFrame.add(tfnoiden);

        lbtGioKH.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbtGioKH.setBounds(450,230,100,30);
        jFrame.add(lbtGioKH);

        tfGioKH.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfGioKH.setBounds(520,230,200,25);
        jFrame.add(tfGioKH);

        lbLoaive.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbLoaive.setBounds(800,130,100,30);
        jFrame.add(lbLoaive);

        tfLoaive.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfLoaive.setBounds(870,130,200,25);
        jFrame.add(tfLoaive);

        lbBienSoxe.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbBienSoxe.setBounds(800,180,100,30);
        jFrame.add(lbBienSoxe);

        tfBienSoxe.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfBienSoxe.setBounds(870,180,200,25);
        jFrame.add(tfBienSoxe);

        lbGhe.setFont(new Font("Times New Roman", Font.PLAIN,15));
        lbGhe.setBounds(800,230,100,30);
        jFrame.add(lbGhe);

        tfGhe.setFont(new Font("Times New Roman", Font.PLAIN,15));
        tfGhe.setBounds(870,230,200,25);
        jFrame.add(tfGhe);
    }

    public void DSDatVe(){
        JPanel pndsdatve = new JPanel();
        pndsdatve.setLayout(new GridLayout(1,1));
        Border bddsdatve = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbdsdatve = new TitledBorder(bddsdatve, "Danh Sách Đặt Vé");
        pndsdatve.setBorder(tlbdsdatve);
        pndsdatve.setBounds(50,300,1050,180);
        JScrollPane sp = new JScrollPane(tbdsDatVe);
        DefaultTableModel model = (DefaultTableModel) tbdsDatVe.getModel();
        model.setColumnIdentifiers(new Object[]{"Mã Vé","Tên KH","Ngày Đặt Vé","Nơi Đi","Nơi Đến","Loại Vé","Biển Số Xe","Giờ đi","Số Ghê","Giá","Tình Trạng"});
        tbdsDatVe.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbdsDatVe.getColumnModel().getColumn(3).setPreferredWidth(40);
        tbdsDatVe.getColumnModel().getColumn(4).setPreferredWidth(40);
        tbdsDatVe.getColumnModel().getColumn(5).setPreferredWidth(40);
        tbdsDatVe.getColumnModel().getColumn(8).setPreferredWidth(10);
        tbdsDatVe.getColumnModel().getColumn(9).setPreferredWidth(40);
        pndsdatve.add(sp);

        DSDatVeSQL(model);
        LayDuLieu();
        buttonTiemKiem(model);
        setBttThanhtoan(model);
        jFrame.add(pndsdatve);
    }
    public void DSDatVeSQL(DefaultTableModel model){
        model.setRowCount(0);
        try{
            String selectDSDatVe = "select Distinct MaVe, HoTen, DatVeXe.NgayDatVe, NoiDi, NoiDen, LOAIVE, BienSoXe, GioKhoiHanh, SoGhe, GIA, DatVeXe.TinhTrang\n" +
                    "from DatVeXe, Customer, DatGhe, NgayDat, TuyenDuong where\n" +
                    "DatVeXe.MaTuyen = TuyenDuong.MaTuyen\n" +
                    "and DatVeXe.NgayDatVe = NgayDat.NgayDatVe\n" +
                    "and DatVeXe.Stt = DatGhe.Stt\n" +
                    "and DatVeXe.Username = Customer.Username";
            ps = conn.connectSQL().prepareStatement(selectDSDatVe);
            rs = ps.executeQuery();
            while(rs.next()){
                Object ob[] =  {rs.getString("MaVe"),rs.getString("HoTen"),rs.getString("NgayDatVe"),
                        rs.getString("NoiDi"),rs.getString("NoiDen"),
                        rs.getString("LOAIVE"),rs.getString("BienSoXe"),
                        rs.getString("GioKhoiHanh"),rs.getString("SoGhe"),rs.getString("GIA"),rs.getString("TinhTrang")};
                model.addRow(ob);
            }

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }


    public void LayDuLieu(){
        tbdsDatVe.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int i = tbdsDatVe.getSelectedRow();
                if(i>=0){
                    tfMV.setText(tbdsDatVe.getValueAt(i,0).toString());
                    tfName.setText(tbdsDatVe.getValueAt(i,1).toString());
                    tfNgayDi.setText(tbdsDatVe.getValueAt(i,2).toString());
                    tfnoidi.setText(tbdsDatVe.getValueAt(i,3).toString());
                    tfnoiden.setText(tbdsDatVe.getValueAt(i,4).toString());
                    tfGioKH.setText(tbdsDatVe.getValueAt(i,5).toString());
                    tfLoaive.setText(tbdsDatVe.getValueAt(i,6).toString());
                    tfBienSoxe.setText(tbdsDatVe.getValueAt(i,7).toString());
                    tfGhe.setText(tbdsDatVe.getValueAt(i,8).toString());
                }
            }
        });
    }

    public void chucnang(){
        JPanel pnchucnang = new JPanel(null);
        Border bdchucnang = BorderFactory.createLineBorder(Color.black);
        TitledBorder tlbchucnang = new TitledBorder(bdchucnang, "Tìm kiếm");
        pnchucnang.setBorder(tlbchucnang);
        pnchucnang.setBounds(50,500,1050,100);

        cbtimkiem.setBounds(50,35,150,30);
        pnchucnang.add(cbtimkiem);

        tftimkiem.setBounds(220,35,150,30);
        pnchucnang.add(tftimkiem);

        bttTimkiem.setBounds(390,35,130,30);
        pnchucnang.add(bttTimkiem);

        bttThanhtoan.setBounds(540,35,130,30);
        pnchucnang.add(bttThanhtoan);

        bttThongKe.setBounds(700,35,130,30);
        pnchucnang.add(bttThongKe);
        ThongKe();

        bttDangXuat.setBounds(850,35,130,30);
        pnchucnang.add(bttDangXuat);
        bttDangXuat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jFrame.setVisible(false);
                DangNhap dn = new DangNhap();
                dn.setVisible(true);
                dn.setVisible(false);
            }
        });


        jFrame.add(pnchucnang);
    }

    public void ThongKe(){
        bttThongKe.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ThongKe tk = new ThongKe();
                tk.setVisible(true);
                tk.setVisible(false);
            }
        });
    }


    public void buttonTiemKiem(DefaultTableModel model){
        bttTimkiem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (cbtimkiem.getSelectedItem() == "Mã vé") {
                    timkiem.setText("MaVe");
                } else if (cbtimkiem.getSelectedItem() == "Tên đăng nhập") {
                    timkiem.setText("Customer.Username");
                } else if (cbtimkiem.getSelectedItem() == "Tên hành khách") {
                    timkiem.setText("HoTen");
                }
                try {
                    String timkiemsql = "select Distinct MaVe, HoTen, DatVeXe.NgayDatVe, NoiDi, NoiDen, LOAIVE, BienSoXe, GioKhoiHanh, SoGhe, GIA, DatVeXe.TinhTrang\n" +
                            "                    from DatVeXe, Customer, DatGhe, NgayDat, TuyenDuong where\n" +
                            "                    DatVeXe.MaTuyen = TuyenDuong.MaTuyen\n" +
                            "                    and DatVeXe.NgayDatVe = NgayDat.NgayDatVe\n" +
                            "                    and DatVeXe.Stt = DatGhe.Stt\n" +
                            "                    and DatVeXe.Username = Customer.Username\n" +
                            "                    and "+timkiem.getText()+" = N'"+tftimkiem.getText()+"'";
                    ps = conn.connectSQL().prepareStatement(timkiemsql);
                    rs = ps.executeQuery();
                    model.setRowCount(0);
                    while(rs.next()){

                        Object ob[] =  {rs.getString("MaVe"),rs.getString("HoTen"),rs.getString("NgayDatVe"),
                                rs.getString("NoiDi"),rs.getString("NoiDen"),
                                rs.getString("LOAIVE"),rs.getString("BienSoXe"),
                                rs.getString("GioKhoiHanh"),rs.getString("SoGhe"),rs.getString("GIA"),rs.getString("TinhTrang")};
                        model.addRow(ob);
                    }
                } catch (Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }

    public void setBttThanhtoan(DefaultTableModel model){
        bttThanhtoan.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try{
                    String thanhtoansql = "Update DatVeXe set TinhTrang = 'Đã Thanh Toán' where MaVe = ?";
                    ps= conn.connectSQL().prepareStatement(thanhtoansql);
                    ps.setString(1, tfMV.getText());
                    int record = ps.executeUpdate();
                    if(record>0){
                        JOptionPane.showMessageDialog(null, "Thanh toán thành công");
                        DSDatVeSQL(model);
                        ResetText();
                    }
                }catch(Exception e1){
                    e1.printStackTrace();
                }
            }
        });
    }

    public void ResetText(){
        tfMV.setText("");
        tfName.setText("");
        tfnoidi.setText("");
        tfnoiden.setText("");
        tfGioKH.setText("");
        tfLoaive.setText("");
        tfBienSoxe.setText("");
        tfNgayDi.setText("");
        tfGhe.setText("");
    }


}