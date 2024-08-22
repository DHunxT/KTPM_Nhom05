//package JunitTest;
//
//import org.junit.Assert;
//import org.junit.Before;
//import org.junit.After;
//import org.junit.Test;
//
//import java.sql.Connection;
//import java.sql.DriverManager;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.sql.SQLException;
//import java.sql.Statement;
//
//public class GreeterTest {
//    private static final String DB_URL = "jdbc:mysql://localhost:3306/shoesecommerce?serverTimezone=UTC";
//    private static final String USERNAME = "root";
//    private static final String PASSWORD = "dvH.031214";
//    private Connection connection;
//
//    @Before
//    public void setUp() throws SQLException {
//
//        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
//        connection.setAutoCommit(false);
//
//    }
//
//    @After
//    public void tearDown() throws SQLException {
//
//        if (connection != null && !connection.isClosed()) {
//            connection.commit(); // Commit giao dịch
//            connection.close();
//        }
//    }
//
//    @Test
//    public void testCase1() throws SQLException {
//
//        String insertQuery = "INSERT INTO nhanvien (id, name, title, org_id) VALUES (?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
//            statement.setDouble(1, 21);
//            statement.setString(2, "Nguyễn Văn Hung");
//            statement.setString(3, "SEO");
//            statement.setDouble(4, 2);
//            int rowsAffected = statement.executeUpdate();
//            Assert.assertEquals(1, rowsAffected);
//        }
//
//        // Select dữ liệu từ cơ sở dữ liệu
//        String selectQuery = "SELECT * FROM nhanvien WHERE name = ?";
//        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
//            statement.setString(1, "Nguyễn Văn Hung");
//            try (ResultSet resultSet = statement.executeQuery()) {
//                Assert.assertTrue(resultSet.next());
//                Assert.assertEquals(2, resultSet.getDouble("id"), 0.001); // Sử dụng epsilon
//                Assert.assertEquals("SEO", resultSet.getString("title"));
//                Assert.assertEquals(2, resultSet.getDouble("org_id"), 0.001); // Sử dụng epsilon
//            }
//        }
//    }
//
////    @Test
////    public void TestCase2() throws SQLException {
////        String insertQuery = "INSERT INTO nhanvien (id, name, title, org_id) VALUES (?, ?, ?, ?)";
////
////        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
////            // Thêm bản ghi đầu tiên
////            statement.setInt(1, 14);
////            statement.setString(2, "Phạm Minh Tâm");
////            statement.setString(3, "Developer");
////            statement.setInt(4, 2);
////            statement.addBatch();
////
////            // Thêm bản ghi thứ hai
////            statement.setInt(1, 15);
////            statement.setString(2, "Nguyễn Thị Hương");
////            statement.setString(3, "Tester");
////            statement.setInt(4, 1);
////            statement.addBatch();
////
////            // Thực thi các bản ghi đã thêm vào batch
////            int[] rowsAffected = statement.executeBatch();
////
////            // Kiểm tra số lượng bản ghi ảnh hưởng
////            Assert.assertEquals(2, rowsAffected.length);
////            Assert.assertEquals(1, rowsAffected[0]); // Số bản ghi bị ảnh hưởng bởi câu lệnh đầu tiên
////            Assert.assertEquals(1, rowsAffected[1]); // Số bản ghi bị ảnh hưởng bởi câu lệnh thứ hai
////        } catch (SQLException e) {
////            e.printStackTrace(); // In ra lỗi nếu có
////            Assert.fail(e.getMessage()); // Thông báo lỗi
////        }
////    }
//
////    @Test
////
////    // Thay dổi các giá trị của dữ liệu
////    public void testCase3() throws SQLException {
////        // Xóa bản ghi cũ nếu tồn tại
////        String deleteQuery = "DELETE FROM nhanvien WHERE id = ?";
////        try (PreparedStatement statement = connection.prepareStatement(deleteQuery)) {
////            statement.setInt(1, 3);
////            statement.executeUpdate();
////        }
////
////        // Insert dữ liệu vào cơ sở dữ liệu
////        String insertQuery = "INSERT INTO nhanvien (id, name, title, org_id) VALUES (?, ?, ?, ?)";
////        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
////            statement.setInt(1, 11); // Đảm bảo id không trùng lặp
////            statement.setString(2, "Van hung");
////            statement.setString(3, "CEO"); // Sử dụng title hợp lệ
////            statement.setInt(4, 4); // Sử dụng int thay vì double cho org_id
////            int rowsAffected = statement.executeUpdate();
////            Assert.assertEquals(1, rowsAffected);
////        } catch (SQLException e) {
////            e.printStackTrace();
////            Assert.fail(e.getMessage());
////        }
////
////        // Select dữ liệu từ cơ sở dữ liệu
////        String selectQuery = "SELECT * FROM nhanvien WHERE id = ?";
////        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
////            statement.setInt(1, 11);
////            try (ResultSet resultSet = statement.executeQuery()) {
////                Assert.assertTrue(resultSet.next());
////                Assert.assertEquals("Van hung", resultSet.getString("name")); // Đã sửa lại tên cột để phù hợp với bảng
////                Assert.assertEquals("CEO", resultSet.getString("title")); // Đã sửa lại title
////                Assert.assertEquals(4, resultSet.getInt("org_id")); // Đã sửa lại org_id
////            }
////        } catch (SQLException e) {
////            e.printStackTrace();
////            Assert.fail(e.getMessage());
////        }
//    }
//}


package JunitTest;

import org.junit.Assert;
import org.junit.Before;
import org.junit.After;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class GreeterTest {
    private static final String DB_URL = "jdbc:mysql://localhost:3306/shoesecommerce?serverTimezone=UTC";
    private static final String USERNAME = "root";
    private static final String PASSWORD = "dvH.031214";
    private Connection connection;

    @Before
    public void setUp() throws SQLException {
        connection = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
        connection.setAutoCommit(false);
    }

    @After
    public void tearDown() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.commit(); // Commit giao dịch
            connection.close();
        }
    }

//    @Test
//    public void testInsertAndSelectUser() throws SQLException {
//        // Chèn dữ liệu vào bảng user
//        String insertQuery = "INSERT INTO user (id, username, password, firstName, lastName, phoneNumber, address, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
//        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
//            statement.setInt(1, 6); // ID
//            statement.setString(2, "LTranxH"); // username
//            statement.setString(3, "123456789"); // password
//            statement.setString(4, "Trang"); // firstName
//            statement.setString(5, "Le"); // lastName
//            statement.setString(6, "123456789"); // phoneNumber
//            statement.setString(7, "Hung Yen"); // address
//            statement.setString(8, "john_doe.png"); // image
//            int rowsAffected = statement.executeUpdate();
//            Assert.assertEquals(1, rowsAffected);
//        }
//
//        // Truy vấn dữ liệu từ cơ sở dữ liệu
//        String selectQuery = "SELECT * FROM user WHERE username = ?";
//        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
//            statement.setString(1, "LTranxH");
//            try (ResultSet resultSet = statement.executeQuery()) {
//                Assert.assertTrue(resultSet.next());
//                // Xác minh các giá trị đã chèn vào cơ sở dữ liệu
//                Assert.assertEquals(5, resultSet.getInt("id")); // ID phải là 5
//                Assert.assertEquals("LTranxH", resultSet.getString("username")); // username phải là "LTranxH"
//                Assert.assertEquals("123456789", resultSet.getString("password")); // password phải là "123456789"
//                Assert.assertEquals("Trang", resultSet.getString("firstName")); // firstName phải là "Trang"
//                Assert.assertEquals("Le", resultSet.getString("lastName")); // lastName phải là "Le"
//                Assert.assertEquals("123456789", resultSet.getString("phoneNumber")); // phoneNumber phải là "123456789"
//                Assert.assertEquals("Hung Yen", resultSet.getString("address")); // address phải là "Hung Yen"
//                Assert.assertEquals("john_doe.png", resultSet.getString("image")); // image phải là "john_doe.png"
//            }
//        }
//    }


    @Test
    public void testUpdateUser() throws SQLException {
        // Chèn dữ liệu người dùng vào bảng user
        String insertQuery = "INSERT INTO user (id, username, password, firstName, lastName, phoneNumber, address, image) VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(insertQuery)) {
            statement.setInt(1, 5); // ID
            statement.setString(2, "LTranxH"); // username
            statement.setString(3, "123456789"); // password
            statement.setString(4, "Trang"); // firstName
            statement.setString(5, "Le"); // lastName
            statement.setString(6, "123456789"); // phoneNumber
            statement.setString(7, "Hung Yen"); // address
            statement.setString(8, "john_doe.png"); // image
            statement.executeUpdate();
        }

        // Cập nhật thông tin người dùng
        String updateQuery = "UPDATE user SET phoneNumber = ?, address = ?, image = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(updateQuery)) {
            statement.setString(1, "555555555"); // phoneNumber mới
            statement.setString(2, "789 Pine Road"); // address mới
            statement.setString(3, "jane_doe.png"); // image mới
            statement.setInt(4, 5); // ID của người dùng để cập nhật
            int rowsAffected = statement.executeUpdate();
            Assert.assertEquals(1, rowsAffected); // Kiểm tra rằng 1 bản ghi đã được cập nhật
        }

        // Xác minh thông tin đã cập nhật
        String selectQuery = "SELECT * FROM user WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(selectQuery)) {
            statement.setInt(1, 5); // ID của người dùng để kiểm tra
            try (ResultSet resultSet = statement.executeQuery()) {
                Assert.assertTrue(resultSet.next()); // Kiểm tra rằng có dữ liệu
                // Xác minh các giá trị đã được cập nhật trong cơ sở dữ liệu
                Assert.assertEquals(5, resultSet.getInt("id")); // ID phải là 5
                Assert.assertEquals("LTranxH", resultSet.getString("username")); // username không thay đổi
                Assert.assertEquals("123456789", resultSet.getString("password")); // password không thay đổi
                Assert.assertEquals("Trang", resultSet.getString("firstName")); // firstName không thay đổi
                Assert.assertEquals("Le", resultSet.getString("lastName")); // lastName không thay đổi
                Assert.assertEquals("555555555", resultSet.getString("phoneNumber")); // phoneNumber phải là "555555555"
                Assert.assertEquals("789 Pine Road", resultSet.getString("address")); // address phải là "789 Pine Road"
                Assert.assertEquals("jane_doe.png", resultSet.getString("image")); // image phải là "jane_doe.png"
            }
        }
    }

}
