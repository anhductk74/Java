package Business;

import DBManage.ConnectDB;

public class AccountManage {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ConnectDB cn = new ConnectDB();
		cn.connect();
		cn.executeDB("Insert into Account values('test','abc')");
	}
}
