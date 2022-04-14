package Controller;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.table.DefaultTableModel;

import ConnectDB.ConnectDB;
import Model.ModelStudent;
import View.ViewStudent;

public class ControllerStudent {
	public static void TableStudent(DefaultTableModel model){
		ConnectDB conn = new ConnectDB();
		ResultSet rs;
	    PreparedStatement ps;
        model.setRowCount(0);
        try{
            String selectListStudent = "Select * from Student";
            ps = conn.connectSQL().prepareStatement(selectListStudent);
            rs = ps.executeQuery();
            while(rs.next()){
                Object ob[] =  {rs.getString("StuID"),rs.getString("Name"),rs.getString("Address")};
                model.addRow(ob);
            }

        } catch (Exception e1){
            e1.printStackTrace();
        }
    }
	
	public static void main(String[] args) {
		ViewStudent vst = new ViewStudent();
		ModelStudent mst = new ModelStudent();
		TableStudent(vst.getModel());
		
	}
}
