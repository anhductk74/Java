package View;

import java.awt.Font;
import java.awt.HeadlessException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

public class ViewStudent extends JFrame{
	private JFrame jf;
	private JTextField txStuID;
	private JTextField txName;
	private JTextField txAddress;
	private JTable tblStu;
	private DefaultTableModel model;
	private JButton bttSearch;
	private JButton bttAdd;
	private JButton bttEdit;
	private JButton bttDelete;
	private JButton bttClear;
	private JButton bttExit;
	

	public JFrame getJf() {
		return jf;
	}



	public void setJf(JFrame jf) {
		this.jf = jf;
	}



	public JTextField getTxStuID() {
		return txStuID;
	}



	public void setTxStuID(JTextField txStuID) {
		this.txStuID = txStuID;
	}



	public JTextField getTxName() {
		return txName;
	}



	public void setTxName(JTextField txName) {
		this.txName = txName;
	}



	public JTextField getTxAddress() {
		return txAddress;
	}



	public void setTxAddress(JTextField txAddress) {
		this.txAddress = txAddress;
	}



	public JTable getTblStu() {
		return tblStu;
	}



	public void setTblStu(JTable tblStu) {
		this.tblStu = tblStu;
	}



	public DefaultTableModel getModel() {
		return model;
	}



	public void setModel(DefaultTableModel model) {
		this.model = model;
	}



	public JButton getBttSearch() {
		return bttSearch;
	}



	public void setBttSearch(JButton bttSearch) {
		this.bttSearch = bttSearch;
	}



	public JButton getBttAdd() {
		return bttAdd;
	}



	public void setBttAdd(JButton bttAdd) {
		this.bttAdd = bttAdd;
	}



	public JButton getBttEdit() {
		return bttEdit;
	}



	public void setBttEdit(JButton bttEdit) {
		this.bttEdit = bttEdit;
	}



	public JButton getBttDelete() {
		return bttDelete;
	}



	public void setBttDelete(JButton bttDelete) {
		this.bttDelete = bttDelete;
	}



	public JButton getBttClear() {
		return bttClear;
	}



	public void setBttClear(JButton bttClear) {
		this.bttClear = bttClear;
	}



	public JButton getBttExit() {
		return bttExit;
	}



	public void setBttExit(JButton bttExit) {
		this.bttExit = bttExit;
	}



	public ViewStudent(){
		jf = new JFrame();
		jf.setLayout(null);
		
		JLabel lbtitle = new JLabel("QUẢN LÝ LỚP HỌC");
		lbtitle.setBounds(270, 30, 400, 50);
		lbtitle.setFont(new Font("tahoma", Font.BOLD, 28));
		jf.add(lbtitle);
		
		JLabel lbStuID = new JLabel("StuID:");
		lbStuID.setBounds(30, 90, 100, 30);
		lbStuID.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(lbStuID);
		
		txStuID = new JTextField();
		txStuID.setBounds(100, 90, 100, 30);
		txStuID.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(txStuID);
		
		JLabel lbName = new JLabel("Name:");
		lbName.setBounds(30, 130, 100, 30);
		lbName.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(lbName);
		
		txName = new JTextField();
		txName.setBounds(100, 130, 100, 30);
		txName.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(txName);
		
		JLabel lbAddress = new JLabel("Address:");
		lbAddress.setBounds(30, 170, 100, 30);
		lbAddress.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(lbAddress);
		
		txAddress = new JTextField();
		txAddress.setBounds(100, 170, 100, 30);
		txAddress.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(txAddress);
		
		tblStu = new JTable();
		JScrollPane spStu = new JScrollPane(tblStu);
		spStu.setBounds(200, 90, 500, 110);
		spStu.setFont(new Font("tahoma", Font.PLAIN, 16));
		model =(DefaultTableModel) tblStu.getModel();
		model.setColumnIdentifiers(new Object[]{"StuID","Name","Address"});
		jf.add(spStu);
		
		bttSearch = new JButton("Search");
		bttSearch.setBounds(30, 200, 90, 30);
		bttSearch.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttSearch);
		
		bttAdd = new JButton("Add");
		bttAdd.setBounds(120, 200, 80, 30);
		bttAdd.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttAdd);
		
		bttEdit = new JButton("Edit");
		bttEdit.setBounds(30, 230, 90, 30);
		bttEdit.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttEdit);
		
		bttDelete = new JButton("Delete");
		bttDelete.setBounds(120, 230, 80, 30);
		bttDelete.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttDelete);
		
		bttClear = new JButton("Clear");
		bttClear.setBounds(30, 260, 90, 30);
		bttClear.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttClear);
		
		bttExit = new JButton("Exit");
		bttExit.setBounds(120, 260, 80, 30);
		bttExit.setFont(new Font("tahoma", Font.PLAIN, 16));
		jf.add(bttExit);
		
		jf.setSize(800,450);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.setLocationRelativeTo(null);
		jf.setVisible(true);
	}
	
	public static void main(String[] args) {
		new ViewStudent();
	}
}
