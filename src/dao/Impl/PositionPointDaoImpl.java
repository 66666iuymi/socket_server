package dao.Impl;


import dao.IPositionPointDao;
import entity.PositionPoint;
import util.DBUtil;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static util.DBUtil.pstmt;
import static util.DBUtil.connection;

//数据访问层： 原子性的增删改查
public class PositionPointDaoImpl implements IPositionPointDao {

    @Override
    public boolean addPoint(PositionPoint positionPoint, String tablename){
        String sql = "insert into "+tablename+" values(?,?,?)";
        Object[] params = {positionPoint.getSno(),positionPoint.getLongitude(),positionPoint.getLatitude()};
        return DBUtil.executeUpdate(sql, params);
    }

    @Override
    public void createTable(String tablename) {
        String sql = "create table " + tablename +
                "(sno int primary key," +
                "longitude double," +
                "latitude double)";
        DBUtil.executeUpdate(sql, null);
    }

    @Override
    public List<PositionPoint> queryAll(String tablename) {

        ResultSet rs = null;
        PositionPoint positionPoint = null;
        List<PositionPoint> positionPoints = new ArrayList<>();

        try {
            String sql = "select * from "+ tablename;
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int no = rs.getInt("sno");
                double longitude = rs.getDouble("longitude");
                double latitude = rs.getDouble("latitude");
                positionPoint = new PositionPoint(no, longitude, latitude);
                positionPoints.add(positionPoint);
                //System.out.println(students);
            }
            return positionPoints;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(rs != null)
                    rs.close();
                if(rs != null)
                    pstmt.close();
                if(rs != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

    }

    @Override
    public List<String> getTableName() {
        ResultSet rs = null;
        PositionPoint positionPoint = null;
        List<PositionPoint> students = new ArrayList<>();
        List<String> lists = new ArrayList<>();
        try {
            String sql = "show tables";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                lists.add(rs.getString("Tables_in_test1"));
            }
            return lists;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            try {
                if(rs != null)
                    rs.close();
                if(rs != null)
                    pstmt.close();
                if(rs != null)
                    connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
    }
}
