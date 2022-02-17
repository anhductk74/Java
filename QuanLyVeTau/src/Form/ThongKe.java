package Form;

import ConnectSQL.ConnectDB;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class ThongKe extends JFrame {
    ConnectDB conn = new ConnectDB();
    PreparedStatement ps;
    ResultSet rs;
    JFrame jFrame = new JFrame("Thống kê");
    JLabel lbTitle = new JLabel("Thống Kê");
    public ThongKe(){
        jFrame.setLayout(new BorderLayout());
        jFrame.setResizable(false);

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
        JPanel pnVe = new JPanel();
        JLabel lbVe = new JLabel("Tổng số vé đã đặt: ");
        lbVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVe.add(lbVe);
        JLabel tfVe = new JLabel("");
        tfVe.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVe.add(tfVe);
        pnCenter.add(pnVe);
        TongSoVe(tfVe);

        JPanel pnKH = new JPanel();
        JLabel lbKH = new JLabel("Tổng số khách hàng đã đăng ký: ");
        lbKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnKH.add(lbKH);
        JLabel tfKH = new JLabel("");
        tfKH.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnKH.add(tfKH);
        pnCenter.add(pnKH);
        TongKH(tfKH);

        JPanel pnVeDaTT = new JPanel();
        JLabel lbVeDaTT = new JLabel("Số vé đã thanh toán: ");
        lbVeDaTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVeDaTT.add(lbVeDaTT);
        JLabel tfVeDaTT = new JLabel("");
        tfVeDaTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVeDaTT.add(tfVeDaTT);
        pnCenter.add(pnVeDaTT);
        VeDaThanhToan(tfVeDaTT);

        JPanel pnVeChuaTT = new JPanel();
        JLabel lbVeChuaTT = new JLabel("Số vé chưa thanh toán: ");
        lbVeChuaTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVeChuaTT.add(lbVeChuaTT);
        JLabel tfVeChuaTT = new JLabel("");
        tfVeChuaTT.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnVeChuaTT.add(tfVeChuaTT);
        pnCenter.add(pnVeChuaTT);
        VeChuaThanhToan(tfVeChuaTT);

        JPanel pnTongDoanhThu = new JPanel();
        JLabel lbTongDoanhThu = new JLabel("Tổng doanh thu: ");
        lbTongDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnTongDoanhThu.add(lbTongDoanhThu);
        JLabel tfTongDoanhThu = new JLabel("");
        tfTongDoanhThu.setFont(new Font("Tahoma", Font.PLAIN, 14));
        pnTongDoanhThu.add(tfTongDoanhThu);
        pnCenter.add(pnTongDoanhThu);
        TongDoanhThu(tfTongDoanhThu);

        JPanel pnbottom = new JPanel();
        pnCenter.add(pnbottom);

        jFrame.add(pnCenter, BorderLayout.CENTER);
    }

    public void TongSoVe(JLabel tfVe){
        JTable tbVe = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbVe.getModel();
        model.setColumnIdentifiers(new Object[]{"Ve"});
        try{
            String sql = "SELECT COUNT(MaVe) AS TongSoVe FROM DatVeXe";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("TongSoVe")};
                model.addRow(ob);
            }
        } catch(Exception e1){
            e1.printStackTrace();
        }
        tfVe.setText(tbVe.getValueAt(0,0).toString());
    }

    public void TongKH(JLabel tfKH){
        JTable tbKH = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbKH.getModel();
        model.setColumnIdentifiers(new Object[]{"KH"});
        try{
            String sql = "SELECT COUNT(Username) AS TongKH FROM Customer ";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("TongKH")};
                model.addRow(ob);
            }
        } catch(Exception e1){
            e1.printStackTrace();
        }
        tfKH.setText(tbKH.getValueAt(0,0).toString());
    }

    public void VeDaThanhToan(JLabel tfVeDaTT){
        JTable tbVeDaTT = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbVeDaTT.getModel();
        model.setColumnIdentifiers(new Object[]{"ve da tt"});
        try{
            String sql = "SELECT COUNT(MaVe) AS DaTT FROM DatVeXe Where TinhTrang = 'Đã Thanh Toán'";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("DaTT")};
                model.addRow(ob);
            }
        } catch(Exception e1){
            e1.printStackTrace();
        }
        tfVeDaTT.setText(tbVeDaTT.getValueAt(0,0).toString());
    }

    public void VeChuaThanhToan(JLabel tfVeChuaTT){
        JTable tbVeChuaTT = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbVeChuaTT.getModel();
        model.setColumnIdentifiers(new Object[]{"ve chua tt"});
        try{
            String sql = "SELECT COUNT(MaVe) AS ChuaTT FROM DatVeXe Where TinhTrang = N'Chưa Thanh Toán'";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("ChuaTT")};
                model.addRow(ob);
            }
        } catch(Exception e1){
            e1.printStackTrace();
        }
        tfVeChuaTT.setText(tbVeChuaTT.getValueAt(0,0).toString());
    }

    public void TongDoanhThu(JLabel tfTongDoanhThu){
        JTable tbTongDoanhThu = new JTable();
        DefaultTableModel model = (DefaultTableModel) tbTongDoanhThu.getModel();
        model.setColumnIdentifiers(new Object[]{"TongDoanhThu"});
        try{
            String sql = "select Sum(GIA) as TongDoanhThu\n"+
                    "                    from DatVeXe,TuyenDuong where\n" +
                    "                    DatVeXe.MaTuyen = TuyenDuong.MaTuyen\n" +
                    "                    and TinhTrang = 'Đã Thanh Toán'";
            ps = conn.connectSQL().prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()){
                Object ob[]= {rs.getString("TongDoanhThu")};
                model.addRow(ob);
            }
        } catch(Exception e1){
            e1.printStackTrace();
        }
        tfTongDoanhThu.setText(tbTongDoanhThu.getValueAt(0,0).toString()+"đ");
    }

}

