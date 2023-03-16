import dao.StudentDAO;
import model.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    private static void mainMenu() {
        System.out.println("--- QUẢN LÝ THÔNG TIN SINH VIÊN ---");
        System.out.println("1. Danh sách sinh viên theo bảng");
        System.out.println("2. Thêm 1 sinh viên mới");
        System.out.println("3. Xóa sinh viên theo mã");
        System.out.println("4. Câp nhật thông tin sinh viên");
        System.out.println("5. Tìm 1 sinh viên thao họ tên hoặc mã");
        System.out.println("6. sắp xếp sinh viên thao điểm số GPA tăng dần");
        System.out.println("7. In ra tất cả sinh viên nữ ở hà nội có GPA trên 2.5");
        System.out.println("8. Sắp xếp sinh viên thoe họ tên, saắp xếp theo bảng chữ cái abc");

    }

    private static void option1() {
        List<Student> studentList = StudentDAO.getAll();
        System.out.printf("%-20s %-20s %-20s %-20s", "Mã sinh viên", "Họ tên", "Giới tính", "Địa chỉ");
        System.out.println();
        for (int i = 0; i < studentList.size(); i++) {
            Student p = studentList.get(i);
            System.out.printf("%-20s %-20s %-20d %-20s\n", p.getId(), p.getFull_name(), p.getGender(),p.getAddress());
        };
    }

    private static void option2(Scanner in){
        Student student = new Student();
        System.out.print("Nhập ID Sinh Viên : ");
        student.setId(in.nextLine());
        System.out.print("Nhập Họ Và Tên : ");
        student.setFull_name(in.nextLine());
        System.out.print("Nhập Giới Tính : ");
        student.setGender(Integer.parseInt(in.nextLine()));
        System.out.print("Nhập Ngày Sinh : ");
        student.setDatebirth(in.nextLine());
        System.out.print("Nhập Địa Chỉ : ");
        student.setAddress(in.nextLine());
        System.out.print("Nhập Phone Number : ");
        student.setPhone(in.nextLine());
        System.out.print("Nhập Email : ");
        student.setEmail(in.nextLine());
        System.out.print("Nhập Điểm GPA : ");
        student.setGPA(Double.parseDouble(in.nextLine()));
        StudentDAO.insert(student);
    }

    private static void option3(Scanner in){
        StudentDAO studentDAO= new StudentDAO();
        Student student=new Student();
        System.out.println("Nhập mã sinh viên muốn xóa: ");
        String id = in.nextLine();
        student.setId(id);
        studentDAO.delete(id);
    }

    private static void option4(Scanner in){
        StudentDAO studentDAO = new StudentDAO();
        Student s=new Student();
        System.out.print("\tNhập mã sinh viên: ");
        String id = in.nextLine();
        s.setId(id);
        System.out.print("\tNhập họ tên: ");
        String name = in.nextLine();
        s.setFull_name(name);
        System.out.print("\tNhập giới tính: ");
        int gender=Integer.parseInt(in.nextLine());
        s.setGender(gender);
        System.out.print("\tNhập ngày sinh: ");
        String dateOfBirth=in.nextLine();
        s.setDatebirth(dateOfBirth);
        System.out.print("\tNhập địa chỉ: ");
        String address=in.nextLine();
        s.setAddress(address);
        System.out.print("\tNhập số điện thoại: ");
        String phone = in.nextLine();
        s.setPhone(phone);
        System.out.print("\tNhập email: ");
        String email=in.nextLine();
        s.setEmail(email);
        System.out.print("\tNhập điểm GPA: ");
        Double GPA=Double.parseDouble(in.nextLine());
        s.setGPA(GPA);

        studentDAO.update(s,id);
    }

    public static void main(String[] args) {
        StudentDAO studentDAO = new StudentDAO();

        int option = -1;
        Scanner in = new Scanner(System.in);
        do {
            mainMenu();
            System.out.print("Nhập lựa chọn: ");
            try {
                option = Integer.parseInt(in.nextLine());
            } catch (Exception e) {
                System.out.println("Nhập sai định dạng!");
                continue;
            }
            if (option < 1 || option > 8) {
                System.out.println("Lựa chọn không hợp lệ");
                continue;
            }
            switch (option) {
                case 1:
                    option1();
                    break;
                case 2:
                    option2(in);
                    break;
                case 3:
                    option3(in);
                    break;
                case 4:
                  option4(in);
                    break;
                case 5:
                    break;
                case 6:
                    break;
                case 7:
                    break;
                case 8:
                    break;
            }

        }
        while (option != 9);
        in.close();



    }

}
