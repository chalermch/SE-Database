package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DatabaseHandler {
    private Connection connection =  null;
    private String url = "jdbc:mariadb://bolons.synology.me:3307/teletubbies";
    private String user = "hall";
    private String password = "gqVsX%2h!C";
    
    //เชื่อมกับฐานข้อมูล
    public DatabaseHandler() throws ClassNotFoundException, SQLException {
        connection = DriverManager.getConnection(url, user, password);
        if(connection != null) System.out.println("Connected");
        else System.out.println("Connect faild");

    }
   
    public void closeConnection() throws SQLException {
        connection.close();
    }
    
    //เป็นการส่งค่าไปเก็บไว้ใน database
    public int update(String sql, Object ...args) throws SQLException { 
        PreparedStatement ps = connection.prepareStatement(sql);
        for(int i =0; i < args.length; i++) {
            ps.setObject(i+1, args[i]);
        }
        int result = ps.executeUpdate();
        return result;
    }

    //ดึงข้อมูลจาก database มาใช้
    public ResultSet query(String sql, Object...args) throws SQLException {
        PreparedStatement ps = connection.prepareStatement(sql);
        if (args != null ) {
            for(int i =0; i < args.length; i++) {
                ps.setObject(i+1, args[i]);
            }
        }
        ResultSet rs = ps.executeQuery();
        return rs;
    }

    //ถ้ากำหนด false จะทำให้เป็นการกำหนดว่าจะให้มีการควบคุม transaction ด้วยตนเอง 
    //(คือเมื่อมีการ execute แล้วคำสั่ง sql จะถูกเก็บไว้ก่อน และจะมีผลกับฐานข้อมูลจริง ๆ เมื่อมีการ commit)
    public void beginTransaction() throws SQLException {
        connection.setAutoCommit(false);
    }


    public void commit() throws SQLException {
        connection.commit();
    }


    public void rollback() throws SQLException {
        connection.rollback();
    }
}
