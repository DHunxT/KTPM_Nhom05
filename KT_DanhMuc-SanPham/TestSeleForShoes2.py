from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import Select
import time

options = Options()
options.add_experimental_option("detach", True)
driver = webdriver.Chrome(service=Service(ChromeDriverManager().install()), options=options)
driver.get("http://localhost/TH/TH/Frontend/admin/")
time.sleep(5)
driver.maximize_window()

#Thực hiện điều hướng đến sidebar bên trái
#click sidebar
def validate1():
    sidebar = driver.find_elements(By.CSS_SELECTOR, "li.nav-item")
    sidebar[2].click()
    time.sleep(5)
    #click các danh mục bên trong
    adoption = sidebar[2].find_element(By.LINK_TEXT, "Quản lý sản phẩm")
    adoption.click()
    time.sleep(5)

    #Exception 1:
    btn_sua = driver.find_elements(By.LINK_TEXT, "Sửa")
    btn_sua[0].click()
    time.sleep(5)
    new_name = driver.find_element(By.NAME, "productName")
    new_category = Select(driver.find_element(By.NAME, "category"))
    new_image = driver.find_element(By.NAME, "image")

    new_name.send_keys(" 1")
    new_image.send_keys("c:\\Users\\Admin\\Pictures\\Ielts.jpg")
    new_category.select_by_visible_text("Giày Nike")

    
    time.sleep(5)
    btn_capnhat = driver.find_element(By.NAME, "submit")
    btn_capnhat.click()
    time.sleep(5)
    if "Đã sửa sản phẩm" in driver.page_source:
        print("Exception 1 pass!")
    else:
        print("Exception 1 fail!")
    new_direct=driver.find_element(By.LINK_TEXT, "Quản lý danh mục")
    new_direct.click()
    time.sleep(5)


validate1()