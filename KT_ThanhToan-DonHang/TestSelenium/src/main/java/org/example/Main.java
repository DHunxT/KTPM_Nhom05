package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws InterruptedException {
    System.setProperty("webdriver.chrome.driver","D:\\KTPM\\TestSelenium\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        String url = "http://localhost:120/TH/TH/TH/Frontend/index.php";

        driver.get(url);

        // Click the login link
        driver.findElement(By.linkText("ĐĂNG NHẬP")).click();

        //inputText username,password
//        driver.findElement(By.id("username")).sendKeys("dhunxt");
////        Thread.sleep(1000);
//        driver.findElement(By.id("password")).sendKeys("dvHung@12345");
//       Thread.sleep(1000);
////        //button "Log in"
//       driver.findElement(By.name("dn")).click();
//        Thread.sleep(2000);

        //inputText username,password
        driver.findElement(By.id("username")).sendKeys("dhunxt");
        Thread.sleep(5000);
        driver.findElement(By.id("password")).sendKeys("123456789");
        Thread.sleep(5000);
        driver.findElement(By.name("dn")).click();
//        Thread.sleep(5000);
//
//        driver.findElement(By.linkText("TRANG CHỦ")).click();
//        Thread.sleep(5000);
//       driver.findElement(By.linkText("GIỎ HÀNG")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.linkText("THANH TOÁN")).click();
//        Thread.sleep(5000);
//        driver.findElement(By.linkText("THANH TOÁN")).click();
//        Thread.sleep(5000);
//        Alert confirmAlert = driver.switchTo().alert();
//        Thread.sleep(5000);
//        System.out.println(confirmAlert.getText());  // In nội dung alert
//        Thread.sleep(5000);
//        confirmAlert.accept();  // Nhấn nút "OK" trên confirm alert
//        Thread.sleep(5000);









        String url2 = "http://localhost:120/TH/TH/TH/Frontend/admin/orderAdmin.php";

        driver.get(url2);
        WebElement dropdownButton = driver.findElement(By.cssSelector("button.btn.btn-primary.dropdown-toggle"));
        dropdownButton.click();

        // Chờ để các tùy chọn dropdown xuất hiện
        Thread.sleep(2000); // Điều chỉnh thời gian chờ nếu cần thiết

        // Chọn tùy chọn "Đã vận chuyển"
        WebElement deliveredOption = driver.findElement(By.xpath("//a[text()='Đã vận chuyển']"));
        deliveredOption.click();
     Thread.sleep(2000); // Điều chỉnh thời gian chờ nếu cần thiết
//
//        // Nhấp vào nút "XÓA"
        WebElement deleteButton = driver.findElement(By.xpath("//button[contains(@class,'btn-danger')]//a[text()='XÓA']"));
        deleteButton.click();




    }
}