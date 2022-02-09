package ConnectSQL;

import java.sql.*;

public class ConnectDB {
    Connection conn = null;
    ResultSet rs;
    PreparedStatement ps;
    Statement stmt;
    public Connection connectSQL() {
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            String sql = "jdbc:sqlserver://DESKTOP-JH8LDLJ\\SQLEXPRESS:1433;databaseName=QuanLyVeTau;user=sa;password=123456789";
            conn = DriverManager.getConnection(sql);
            //System.out.println("Connect Success!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }

    public ResultSet listAll(String sql) {
        try {
            connectSQL();
            stmt = conn.createStatement();
            rs = stmt.executeQuery(sql);
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        }
        finally {
            try {
                //conn.close();
                //stmt.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return rs;

    }
}
