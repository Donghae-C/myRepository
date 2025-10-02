package db.dao;

import db.manager.DbManager;
import db.vo.Room;
import db.vo.Student;
import db.vo.Subject;
import db.vo.Teacher;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentTeacherDAOImpl implements StudentTeacherDAO{
    @Override
    public List<Student> getGenderByWomen() {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Student> list = new ArrayList<>();
        String sql = "select * from student where s_jumin like '%-2%'";
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            rs = ps.executeQuery();
            while (rs.next()) {
                int studentNo = rs.getInt("s_no");
                String studentName = rs.getString("s_name");
                String studentJumin = rs.getString("s_jumin");
                String studentPhone = rs.getString("s_phone");
                String StudentAddr =  rs.getString("s_addr");
                String studentEmail = rs.getString("s_mail");
                Student student = new Student(studentNo, studentName, studentJumin, studentPhone, StudentAddr, studentEmail);
                list.add(student);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbManager.releaseConnection(con, ps, rs);
        }
        return list;
    }

    @Override
    public List<Teacher> getTeacherInfoByAddr(String gu) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Teacher> list = new ArrayList<>();
        String sql = "select * from teacher where t_addr like ?";
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, "%"+gu+"%");
            rs = ps.executeQuery();
            while (rs.next()) {
                int teacherNo = rs.getInt("t_no");
                String teacherName = rs.getString("t_name");
                String teacherJumin = rs.getString("t_jumin");
                String teacherPhone = rs.getString("t_phone");
                String teacherEmail = rs.getString("t_mail");
                String teacherAddr = rs.getString("t_addr");
                String subCode = rs.getString("sub_code");
                Teacher teacher = new Teacher(teacherNo,teacherName,teacherJumin,teacherPhone,teacherAddr,teacherEmail,subCode);
                list.add(teacher);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbManager.releaseConnection(con, ps, rs);
        }
        return list;
    }

    @Override
    public Teacher getTeacherInfoBySubject(String sub) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Teacher teacher = null;
        String sql = "select * from teacher where sub_code = "
        		+ "(select sub_code from subject where upper(subject)=upper( ? ))";
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setString(1, sub);
            rs = ps.executeQuery();
            if (rs.next()) {
            	int teacherNo = rs.getInt("t_no");
                String teacherName = rs.getString("t_name");
                String teacherJumin = rs.getString("t_jumin");
                String teacherPhone = rs.getString("t_phone");
                String teacherEmail = rs.getString("t_mail");
                String teacherAddr = rs.getString("t_addr");
                String subCode = rs.getString("sub_code");
                teacher = new Teacher(teacherNo,teacherName,teacherJumin,teacherPhone,teacherAddr,teacherEmail,subCode);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            DbManager.releaseConnection(con, ps, rs);
        }
        return teacher;
    }

    @Override
    public Teacher getTeacherInfoByNo(int teacherNo) {
        Connection con = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        Teacher teacher = null;
        String sql = "select  * from v_total where t_no = ?";
        try {
            con = DbManager.getConnection();
            ps = con.prepareStatement(sql);
            ps.setInt(1, teacherNo);
            rs = ps.executeQuery();
            if (rs.next()) {
                int teacherNo2 = rs.getInt("t_no");
                String teacherName = rs.getString("t_name");
                String subCode = rs.getString("sub_code");
                String subject = rs.getString("subject");
                int roomNo = rs.getInt("room_no");
                int roomCount = rs.getInt("room_count");
                Subject subs = new Subject(subCode, subject);
                Room room = new Room(roomNo, roomCount);
                teacher = new Teacher();
                teacher.setTeacherNo(teacherNo2);
                teacher.setTeacherName(teacherName);
                teacher.setSubject(subs);
                teacher.setRoom(room);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        } finally {
            DbManager.releaseConnection(con, ps, rs);
        }

        return teacher;
    }
}
