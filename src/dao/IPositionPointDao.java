package dao;

import entity.PositionPoint;

import java.util.List;

public interface IPositionPointDao {
    //public boolean delectStudentBysno(int sno);
    public boolean addPoint(PositionPoint positionPoint, String tablename);
    //根据sno找到待修改的人，吧这个人修改成student
    //public boolean updateStudentBySno(int sno, Student student);
    public List<PositionPoint> queryAll();

    public void createTable(String tablename);
    //public Student queryStudentBySNo(int sno);
    //public boolean isExist(int sno);
    //public int getTotalCount();
    //public List<Student> queryStudentsByPage(int currentPage, int pageSize);
    //currentPage 当前页， pageSize:页面大小
}
