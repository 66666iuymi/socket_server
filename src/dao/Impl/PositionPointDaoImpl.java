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
    public boolean addPoint(PositionPoint positionPoint){
        String sql = "insert into positionpoint values(?,?,?)";
        Object[] params = {positionPoint.getSno(),positionPoint.getLongitude(),positionPoint.getLatitude()};
        return DBUtil.executeUpdate(sql, params);
    }


    @Override
    public List<PositionPoint> queryAll() {

        ResultSet rs = null;
        PositionPoint positionPoint = null;
        List<PositionPoint> students = new ArrayList<>();

        try {
            String sql = "select * from positionpoint";
            rs = DBUtil.executeQuery(sql,null);
            while (rs.next()) {
                int no = rs.getInt("no");
                double longitude = rs.getDouble("longitude");
                double latitude = rs.getDouble("latitude");
                positionPoint = new PositionPoint(no, longitude, latitude);
                students.add(positionPoint);
                //System.out.println(students);
            }
            return students;
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
