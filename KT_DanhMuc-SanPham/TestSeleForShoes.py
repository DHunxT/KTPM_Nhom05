from selenium import webdriver
from selenium.webdriver.chrome.service import Service
from selenium.webdriver.chrome.options import Options
from webdriver_manager.chrome import ChromeDriverManager
from selenium.webdriver.common.by import By
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
    sidebar[1].click()
    time.sleep(5)
    #click các danh mục bên trong
    adoption1 = sidebar[1].find_element(By.LINK_TEXT, "Thêm danh mục")
    adoption1.click()
    #Exception 1
    #gửi dữ liệu
    new_direct = driver.find_element(By.ID, "categoryName")
    new_direct.send_keys("Giày Dior")
    time.sleep(5)
    #add dữ liệu
    btn_add = driver.find_element(By.ID, "btn-add")
    btn_add.click()
    if "Đã thêm mới một danh mục !" in driver.page_source:
        print("Exception 1 pass!")
    else:
        print("Exception 1 fail")

    #Exception 2
    new_direct = driver.find_element(By.ID, "categoryName")
    new_direct.send_keys("Giày Dior")
    btn_reset = driver.find_element(By.ID, "btn-reset")
    time.sleep(5)
    btn_reset.click()
    time.sleep(5)
    if new_direct == "":
        print("Exception 2 pass!")
    else:
        print("Exception 2 fail!")

    #Exception 3
    new_direct=driver.find_element(By.LINK_TEXT, "Quản lý danh mục")
    new_direct.click()
    if "Quản lý danh mục" in driver.page_source:
        print("Exception 3 pass!")
    else:
        print("Exception 3 fail!")

def validate2():
    sidebar = driver.find_elements(By.CSS_SELECTOR, "li.nav-item")
    sidebar[1].click()
    time.sleep(5)
    #click các danh mục bên trong
    adoption2 = sidebar[1].find_element(By.LINK_TEXT, "Quản lý danh mục")
    adoption2.click()
    time.sleep(5)

    #Exception 1:
    btn_sua = driver.find_elements(By.LINK_TEXT, "Sửa")
    btn_sua[1].click()
    time.sleep(5)
    new_direct = driver.find_element(By.ID, "categoryName")
    new_direct.send_keys("2")
    time.sleep(5)
    btn_capnhat = driver.find_element(By.ID, "btn-edit")
    btn_capnhat.click()
    time.sleep(5)
    if "Đã sửa danh mục" in driver.page_source:
        print("Exception 4 pass!")
    else:
        print("Exception 4 fail!")
    new_direct=driver.find_element(By.LINK_TEXT, "Quản lý danh mục")
    new_direct.click()
    time.sleep(5)

    #Exception 2
    btn_xoa = driver.find_elements(By.LINK_TEXT, "Xóa")
    btn_xoa[0].click()
    time.sleep(5)
    alert = driver.switch_to.alert
    alert.accept()
    print("Exception 5 done!")




validate1()
time.sleep(5)
validate2()


