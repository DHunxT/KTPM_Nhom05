package JunitTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Greeter {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/nhanvien?serverTimezone=UTC";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "dvH.031214";
//
//    public static void main(String[] args) {
//        Connection connection = null;
//        Statement statement = null;
//        ResultSet resultSet = null;
//
//        try {
//            // Nạp driver JDBC
//            Class.forName("com.mysql.cj.jdbc.Driver");
//
//            // Tạo kết nối đến cơ sở dữ liệu
//            connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//            System.out.println("Kết nối thành công!");
//
//            // Tạo statement để thực hiện truy vấn
//            statement = connection.createStatement();
//
//            // Thực hiện truy vấn SQL
//            String query = "SELECT * FROM employee"; // Sửa tên bảng thành 'employee'
//            resultSet = statement.executeQuery(query);
//
//            // Xử lý kết quả truy vấn
//            while (resultSet.next()) {
//                // Giả sử bảng có các cột: id, name, title, org_id
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String title = resultSet.getString("title");
//                int orgId = resultSet.getInt("org_id");
//
//                // In kết quả
//                System.out.println("ID: " + id + ", Name: " + name + ", Title: " + title + ", Org ID: " + orgId);
//            }
//        } catch (ClassNotFoundException e) {
//            System.out.println("Driver JDBC không được tìm thấy!");
//            e.printStackTrace();
//        } catch (SQLException e) {
//            System.out.println("Không thể kết nối đến cơ sở dữ liệu!");
//            e.printStackTrace();
//        } finally {
//            // Đóng kết nối và các đối tượng liên quan
//            try {
//                if (resultSet != null) resultSet.close();
//                if (statement != null) statement.close();
//                if (connection != null) connection.close();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//    }
}
