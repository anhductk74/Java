package fb;

import java.awt.Container;
import java.awt.LayoutManager;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.FlowLayout; 
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import DBManage.ConnectDB;

import java.awt.BorderLayout;
import java.awt.CardLayout;


public class FacebookForm extends JFrame implements ActionListener{
	JFrame f = new JFrame("The Frame");
	JLabel lbUsername = new JLabel("Username");
	JTextField tfUsername = new JTextField(10);
	JLabel jbPassword = new JLabel("Password");
	JPasswordField tfPass = new JPasswordField(10);
	
	//combobox
	JLabel lbDepart = new JLabel("Department");
	String[] department = {"Vietnam-Korea University", "Hue University", "Hanoi University"};
	JComboBox cbDepartmant = new JComboBox(department);
	
	//checkbox
	JCheckBox chbSC = new JCheckBox("Computer Science");
	JCheckBox chbeconomic = new JCheckBox("Economic");
	JLabel rong = new JLabel();
	
	JButton btnSignUp = new JButton("Sign Up");
	JRadioButton rbMale=new JRadioButton("Male");    
	JRadioButton rbFemale=new JRadioButton("Female");
	ButtonGroup br= new ButtonGroup();
	JButton btnChange = new JButton("Change pass");
	JButton btnDelete = new JButton("Delete");
	
	JTable tbInfor = new JTable();
	
	JTextField txtUsername = new JTextField();
	JTextField txtPass = new JTextField();
	JTextField txtdepart = new JTextField();
	JLabel lbfacult = new JLabel("Faculty");
	JTextField txtfaculty = new JTextField();
	JLabel lbgender = new JLabel("Gender");
	JTextField txtGender = new JTextField();
	
	PreparedStatement ps;
	//Connection conn;
	public FacebookForm() {
		//tao 1 container de add cac component vao
		 // this.getContentPane().;
		f.setLayout(new GridLayout(8,2));
		Container cont = f.getContentPane();
		//cont.setLayout(new LayoutManager());
		cont.add(lbUsername);
		cont.add(tfUsername);
		cont.add(jbPassword);
		cont.add(tfPass);
		cont.add(cbDepartmant);
		cont.add(rong);
		cont.add(chbSC);
		cont.add(chbeconomic);
		br.add(rbMale);
		br.add(rbFemale);
		cont.add(rbMale);
		cont.add(rbFemale);
		//Hobbies : Game Music
		cont.add(btnSignUp);
		
		
		DefaultTableModel model = (DefaultTableModel) tbInfor.getModel();
		model.setColumnIdentifiers(new Object[] {"Username","Password","Gender","Departmant","Faculty"});
		JScrollPane spInfor =new JScrollPane(tbInfor);
		cont.add(spInfor);
		
		ConnectDB cnn = new ConnectDB();
		try {
			String sql = "Select * from Account";
			ps = cnn.connectSQL().prepareStatement(sql);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Object ob[] = {rs.getString("Username"), rs.getString("Password"), rs.getString("Gender"), rs.getString("Department"), rs.getString("Faculty")};
				model.addRow(ob);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		
        
        
        
		
		btnSignUp.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectDB cnn = new ConnectDB();
				
				String gender = "";
				if(rbMale.isSelected()) {
		       	 gender = rbMale.getText();
		        }
		        if(rbFemale.isSelected()) {
		       	 gender = rbFemale.getText();
		        }
		        String depart = cbDepartmant.getSelectedItem().toString();
		        String faculty = "";
		        if(chbSC.isSelected()) faculty += chbSC.getText()+"; "; 
		        if(chbeconomic.isSelected()) faculty += chbeconomic.getText(); 
		         String sql = "insert into Account values ?,?,?,?,?";
		         try {
					ps = cnn.connectSQL().prepareStatement(sql);
					ps.setString(1, tfUsername.getText());
					ps.setString(2, tfPass.getText());
					ps.setString(3, gender);
					ps.setString(4, depart);
					ps.setString(5, faculty);
					int record = ps.executeUpdate();
					if(record>0) {
					Object ob[] = {tfUsername.getText(), tfPass.getText(), gender, depart, faculty};
	 				model.addRow(ob);
					} else JOptionPane.showMessageDialog(null, "ERROR!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Inserted Error!");
				}
			}
		});
		
		cont.add(btnChange);
		btnChange.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
//				ConnectDB cnn = new ConnectDB();
//				String sql = "exec sp_UPdatepassword ?,?";
//				try {
//					ps = cnn.connectSQL().prepareStatement(sql);
//					ps.setString(1, tfUsername.getText());
//					ps.setString(2, tfPass.getText());
//					ps.executeUpdate();
//					JOptionPane.showMessageDialog(null, "Change Pas Sucessfully!");
//				} catch (SQLException e1) {
//					// TODO Auto-generated catch block
//					e1.printStackTrace();
//				}
				
				
			}
		});
		cont.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ConnectDB cnn = new ConnectDB();
//		    	int record = cnn.executeDB("Delete Account where username ='"+tfUsername.getText()+"'");
//		    	if(record>0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
//		    	else JOptionPane.showMessageDialog(null, "Error");
				String sql = "EXEC sp_Delete ?";
				try {
					ps = cnn.connectSQL().prepareStatement(sql);
					ps.setString(1, tfUsername.getText());
					int record = ps.executeUpdate();
					if(record>0) JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
			         else JOptionPane.showMessageDialog(null, "Error!");
					//JOptionPane.showMessageDialog(null, "Delete Account sucessfully!");
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Error");
				}
				
			}
		});
		
		tbInfor.addMouseListener(new MouseListener() {
			
			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				int row = tbInfor.getSelectedRow();
				if(row>=0) {
					txtUsername.setText(tbInfor.getValueAt(row, 0).toString());
					txtPass.setText(tbInfor.getValueAt(row, 1).toString());
					txtGender.setText(tbInfor.getValueAt(row, 2).toString());
					txtdepart.setText(tbInfor.getValueAt(row, 3).toString());
					txtfaculty.setText(tbInfor.getValueAt(row, 4).toString());
					JframeInf();
				}
			}
		});
		
				
		f.setSize(200,200);
		f.setLocationRelativeTo(null);
		f.pack();
	    f.setVisible(true);
	    f.setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	
	public void JframeInf() {
		JFrame frame = new JFrame();
		frame.setLayout(new GridLayout(5, 2));
		
		frame.add(lbUsername);
		frame.add(txtUsername);
		frame.add(jbPassword);
		frame.add(txtPass);
		frame.add(lbDepart);
		frame.add(txtdepart);
		frame.add(lbfacult);
		frame.add(txtfaculty);
		frame.add(lbgender);
		frame.add(txtGender);
		
		
		frame.setSize(300,200);
		frame.pack();
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//new FacebookForm();
		new FacebookForm();    
	    
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}



