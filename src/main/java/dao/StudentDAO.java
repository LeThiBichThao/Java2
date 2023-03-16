package dao;
import connection.MyConnection;
import model.Student;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class StudentDAO {
    public static List<Student> getAll(){
        List<Student> studentList = new ArrayList<>();

    try{
        Connection conn = MyConnection.getConnection();
        final String sql = "select * from students";

        Statement stmt = conn.createStatement();

        ResultSet rs = stmt.executeQuery(sql);

        while (rs.next()){
            Student s = new Student();
            s.setId(rs.getString("id"));
            s.setFull_name(rs.getString("full_name"));
            s.setGender(rs.getInt("gender"));
            s.setDatebirth(rs.getString("datebirth"));
            s.setAddress(rs.getString("address"));
            s.setPhone(rs.getString("phone"));
            s.setEmail(rs.getString("email"));
            s.setGPA(rs.getDouble("GPA"));

            studentList.add(s);
        }
        rs.close();
        stmt.close();
        conn.close();
    }catch (Exception e){
        e.printStackTrace();
    }
        return studentList;
    }

    public static void insert(Student s){
        final String sql = String.format("INSERT INTO students VALUES ('%s','%s','%d','%s','%s','%s','%s','%f')",
                s.getId(),s.getFull_name(),s.getGender(),s.getDatebirth(),s.getAddress(),s.getPhone(),s.getEmail(),s.getGPA());
        try {
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();

            int rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Thêm thông tin thất bại!");
            }
            stmt.close();
            conn.close();
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
    public  Student getByID(String id){
        try{
            Connection conn = MyConnection.getConnection();
            final String sql = "select * from students WHERE id = " +id;

            Statement stmt = conn.createStatement();

            ResultSet rs = stmt.executeQuery(sql);
            Student s = null;

            while (rs.next()){
                s = new Student();
                s.setId(rs.getString("id"));
                s.setFull_name(rs.getString("full_name"));
                s.setGender(rs.getInt("gender"));
                s.setDatebirth(rs.getString("datebirth"));
                s.setAddress(rs.getString("address"));
                s.setPhone(rs.getString("phone"));
                s.setEmail(rs.getString("email"));
                s.setGPA(rs.getDouble("GPA"));

            }
            rs.close();
            stmt.close();
            conn.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }

    public void  update (Student s, String id){
        Student tmp = getByID(id);
        if (tmp == null){
            System.out.println("Không tồn tại nhân viên có id = " + id);
            return;
        }
        final String sql = String.format("INSERT INTO students VALUES ('%s','%s','%d','%s','%s','%s','%s','%f')",
                s.getId(),s.getFull_name(),s.getGender(),s.getDatebirth(),s.getAddress(),s.getPhone(),s.getEmail(),s.getGPA());
        System.out.println(sql);
        try{
            Connection conn = MyConnection.getConnection();
            Statement stmt = conn.createStatement();
            long rs = stmt.executeUpdate(sql);

            if (rs == 0) {
                System.out.println("Cập nhật thất bại");
            }

        }
        catch(Exception ex){
            ex.printStackTrace();
        }
    }

    public void delete(String id) {
        try {
            Connection conn = MyConnection.getConnection();
            final String sql = String.format("DELETE FROM students WHERE id ='%s'",id);

            Statement stmt = conn.createStatement();

            long rs = stmt.executeUpdate(sql);
            if (rs == 0) {
                System.out.println("Xoá thất bại");
            }
            stmt.close();
            conn.close();

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}
