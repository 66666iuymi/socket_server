package util;

import entity.PositionPoint;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBUtil {

    private static final String URL = "jdbc:mysql://localhost:3306/test3?serverTimezone=UTC&useSSL=false";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "12345Qq/";
    public static Connection connection = null;
    public static PreparedStatement pstmt = null;
    public static ResultSet rs = null;

    public static int getTotalCount(String sql) {
        int count = -1;
        try {
            createPreparedStatement(sql, null);

            rs = pstmt.executeQuery();
            if (rs.next()){
                count = rs.getInt(1);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try{
                if (rs != null) {rs.close();}
                if (pstmt != null) {pstmt.close();}
                if (connection != null) {connection.close();}
            }catch (SQLException e) {
                e.printStackTrace();
            }

            }
        return count;
    }

    public static void createPreparedStatement(String sql, Object[] params) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            pstmt = connection.prepareStatement(sql);
            if (params != null) {
                for (int i = 0; i < params.length; i++) {
                    pstmt.setObject(i+1,params[i]);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
    //增删改
    public static boolean executeUpdate(String sql, Object[] params) {
        int count = -1;
        //ResultSet rs = null;

        try {
            createPreparedStatement(sql, params);
            count = pstmt.executeUpdate();
            if (count>0) {
                return true;
            } else {
                return false;
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    // 查
    public static ResultSet executeQuery(String sql, Object[] params) {

        PositionPoint positionPoint = null;
        List<PositionPoint> positionPoints = new ArrayList<>();

        try {
            createPreparedStatement(sql, params);

            rs = pstmt.executeQuery();

            return rs;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }

    }

}
