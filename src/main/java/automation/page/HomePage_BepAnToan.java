package automation.page;

import static org.testng.Assert.assertTrue;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage_BepAnToan {
	private static WebDriver driver;
	@FindBy(xpath="//a[contains(text(),' Chậu Vòi Rửa Bát ')]") WebElement ChauVoiRuaBatMenu;
	@FindBy(xpath ="(//div[@class='mb-1'])[1]/a") WebElement DanhMucChauRuaChenBat;
	@FindBy(xpath = "(//div[@class='mb-1'])[2]/a" ) WebElement DanhMucVoiRuaChenBat;
	@FindBy(xpath = "//a[@href='/danh-muc/chau-voi-rua-chen-bat/konox']//parent::div//child::a")WebElement DanhMucHangSanXuat;
	@FindBy(xpath = "(//div[@class='category-menus'])[3]//div") WebElement MucGia;
	@FindBy(xpath = "//a[text()='Giảm giá nhiều']") WebElement tabGiamGiaNhieu;
	@FindBy(xpath = "(//span[text()='Xem thêm'])[4]//parent::a") WebElement XemThemListSanPham;
	@FindBy(xpath = "(//span[text()='Xem thêm']//parent::a)[1]") WebElement XemThem2;
	@FindBy(xpath="//div[@class='flex flex-wrap product-list']//a") List<WebElement> Product;
	@FindBy(xpath = "//span[contains(text(),'< 3.000.000')]") WebElement NhoHon3;
	@FindBy(xpath = "//div[contains(@class,'product-list')]//img[@alt='Vòi Rửa Bát Hai Đường Nước Korea AT2 - 304']") WebElement SanPhamDemo;


	public HomePage_BepAnToan(WebDriver _driver) {
		this.driver = _driver;
		PageFactory.initElements(_driver,this);
	}
	
	public void locTheoDanhMucChauRuaChenBat() {
		ChauVoiRuaBatMenu.click();
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOf(DanhMucChauRuaChenBat));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", DanhMucChauRuaChenBat);  
	//xuatDanhSachSanPham();		
	}
	public void locTheoDanhMucVoiRuaChenBat() {
		ChauVoiRuaBatMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		wait.until(ExpectedConditions.visibilityOf(DanhMucVoiRuaChenBat));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].click();", DanhMucVoiRuaChenBat);    
		//xuatDanhSachSanPham();
	}
	public void danhSachGiamGiaNhieu() {
		 ChauVoiRuaBatMenu.click(); 
		 WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		 WebElement discountTab = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[text()='Giảm giá nhiều']")));
		 JavascriptExecutor js = (JavascriptExecutor) driver;
		 js.executeScript("arguments[0].click();", discountTab);    
		 // Gọi hàm xuất danh sách sản phẩm và kiểm tra sắp xếp giảm giá
//		  List<Integer> danhSachPhanTramGiamGia = xuatDanhSachSanPham();
//		  kiemTraSapXepGiamGia(danhSachPhanTramGiamGia); // Kiểm tra sắp xếp giảm giá
	}
	public void chiTietSanPham() {
		SanPhamDemo.click();
		
		
	}
	
	
	public void danhSachTheoMucGia() {
		ChauVoiRuaBatMenu.click();
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
		wait.until(ExpectedConditions.visibilityOf(NhoHon3));
		NhoHon3.click();
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
		KiemTraLocTheoMucGia(0, 3000000); // Khoảng giá từ 0 đến 3.000.000 VND
	}
	
 	public  List<Integer> xuatDanhSachSanPham() {
 		int phanTramGiamGia = 0;
	    WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(50));
	    List<Integer> danhSachSanPham = new ArrayList<>();
	    try {
	        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='flex flex-wrap product-list']//a")));
	        List<WebElement> productList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));

	        if (productList.isEmpty()) {
	            System.out.println("Không có sản phẩm nào được tìm thấy.");
	        } else {
	            for (WebElement product : productList) {
	                try {
	                	//CHƯA CLICK ĐƯỢC BUTTON XEMTHEM Ở LIST PRODUCT
	                	Actions actions = new Actions(driver);
	                	actions.moveToElement(product).perform();
	                    WebElement tenSanPham = product.findElement(By.xpath(".//h4"));
	                    String tenSP = tenSanPham.getText();
	                    //WebElement danhMucSanPham = product.findElement(By.xpath("(.//img)[1]"));
	                    WebElement danhMucSanPham = product.findElement(By.xpath(".//h4"));
	                    String danhMucSP = danhMucSanPham.getText();
	                    if(danhMucSP.toLowerCase().contains("vòi".toLowerCase())) {
	                    	danhMucSP = "Vòi rửa chén bát";
	                    }
	                    if(danhMucSP.toLowerCase().contains("chậu".toLowerCase())) {
	                    	danhMucSP = "Chậu rửa chén bát";
	                    }
	                    WebElement hangSanXuat = product.findElement(By.xpath("(.//img)[2]"));
	                    String hangSX = hangSanXuat.getAttribute("alt");
	                    if (isElementPresent(product, "//div[@class='flex flex-wrap product-list']//a//div[contains(@class,'absolute')]")) {
	                        WebElement giamGiaPhanTram = product.findElement(By.xpath("//div[@class='flex flex-wrap product-list']//a//div[contains(@class,'bg-maroon')]"));
	                        String giamGia = giamGiaPhanTram.getText().replace("%", "").replace("-", "").trim(); // Bỏ dấu '%' và '-'
	                        phanTramGiamGia = Integer.parseInt(giamGia);
	                        danhSachSanPham.add(phanTramGiamGia);
	                    } else {
	                        phanTramGiamGia = 0; // Không có giảm giá
	                    }
//	                    if(isElementPresent(product,".//div[contains(@class,'bg-maroon')]")) {
//	                    WebElement giamGiaPhanTram = product.findElement(By.xpath(".//div[contains(@class,'bg-maroon')]"));
//	                    String giamGia = giamGiaPhanTram.getText().replace("%", "").replace("-", "").trim(); // Bỏ dấu '%' và '-'
//	                    // Chuyển đổi giảm giá sang kiểu số nguyên
//	                    phanTramGiamGia = Integer.parseInt(giamGia);
//	            	    danhSachSanPham.add(phanTramGiamGia);
//	                    }
	                    String giaB = "";
	                    String giaG = "";
	                    if (isElementPresent(product, ".//div[contains(@class,'flex prices')]//span")) {
	                        List<WebElement> giaList = product.findElements(By.xpath(".//div[contains(@class,'flex prices')]//span"));
	                        if (giaList.size() > 0) {
	                            giaB = giaList.get(0).getText(); // Giá bán (phần tử đầu tiên)
	                        }
	                        if (giaList.size() > 1) {
	                            giaG = giaList.get(1).getText(); // Giá gốc (phần tử thứ hai)
	                        }
	                    }
	                    //VẪN ĐANG LỖI VỚI PRODUCT KO CÓ GIÁ MÀ CHỈ CÓ CHỮ LIÊN HỆ, GẶP PRODUCT NÀY THÌ CODE SẼ BỊ OUT
//	                    String lienHe="";
//	                    if(isElementPresent(product,".//div[contains(@class,'text-xs')]")) {
//	                    WebElement lh = product.findElement(By.xpath(".//div[contains(@class,'text-xs')]"));
//	                    lienHe = lh.getText();
//	                    }
//	                    else lienHe = "";
	                    
	                    System.out.println("Danh mục sản phẩm: " + danhMucSP);
	                    System.out.println("Tên sản phẩm: " + tenSP);
	                    System.out.println("Hãng sản xuất: " + hangSX);
	                    System.out.println("Giảm giá (%): " + phanTramGiamGia);
	                    if (!giaB.isEmpty() || !giaG.isEmpty()) {
	                        System.out.println("Giá bán: " + giaB);
	                        System.out.println("Giá gốc: " + giaG);
	                    } else {
	                        System.out.println("Vui lòng liên hệ.");
	                    }
	                    Thread.sleep(3000);
	                    Thread.sleep(3000);
	                  

	                } catch (StaleElementReferenceException e) {
	                    System.out.println("Không thể lấy tên sản phẩm, phần tử bị lỗi: " + e.getMessage());
	                }
	              
	            }
	        }
	    } catch (Exception e) {
	        System.out.println("Có lỗi xảy ra khi lấy danh sách sản phẩm: " + e.getMessage());
	    }
	    return danhSachSanPham;
	}
	public static boolean kiemTraSapXepGiamGia(List<Integer> danhSachPhanTramGiamGia) {
	    boolean isSorted = true;
	    for (int i = 0; i < danhSachPhanTramGiamGia.size() - 1; i++) {
	        if (danhSachPhanTramGiamGia.get(i) > danhSachPhanTramGiamGia.get(i + 1)) {
	            return true;
	        }
	    }
	    return false;
	}
	public static boolean kiemTraLocSanPhamTheoDanhMuc (List<Integer> danhSachSanPhamDanhMuc) {
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
	    for(WebElement sanPham : productList) {
	    	WebElement danhMucSanPham = sanPham.findElement(By.xpath(".//h4"));
            String danhMucSP = danhMucSanPham.getText();
            if(danhMucSP.toLowerCase().contains("chậu".toLowerCase())) {
            	danhMucSP = "Chậu rửa chén bát";
            	if(!danhMucSP.equalsIgnoreCase("Chậu rửa chén bát")) {
    	    		return false;
    	    	}
            }
            if(danhMucSP.toLowerCase().contains("vòi".toLowerCase())) {
            	danhMucSP = "Vòi rửa chén bát";
            	if(!danhMucSP.equalsIgnoreCase("Vòi rửa chén bát")) {
    	    		return false;
    	    	}
            }
	    	
	    }
	    return true;
	}
	public void KiemTraLocTheoMucGia(int min, int max) {
		List<WebElement> productList = driver.findElements(By.xpath("//div[@class='flex flex-wrap product-list']//a"));
		boolean gia = true;
		for(WebElement product : productList) {
			 WebElement giaBan = product.findElement(By.xpath("(//div[@class='flex flex-wrap product-list']//a//div[contains(@class,'flex prices')]//span)[1]"));
             String giaB = giaBan.getText();
             double giaBanS = convertPriceToInt(giaB);
             if(giaBanS < min || giaBanS > max) {
            	 gia = false;
            	 System.out.println("Sản phẩm có giá ngoài khoảng lọc: " + giaBanS);
             }
		}
		
	}

	private static double convertPriceToInt(String giaB) {
        String giaBanS = giaB.replaceAll("[^0-9]", "");
        return Integer.parseInt(giaBanS);
    }
	private boolean isElementPresent(WebElement parent, String xpath) {
	    try {
	        return parent.findElement(By.xpath(xpath)).isDisplayed();
	    } catch (NoSuchElementException e) {
	        return false;
	    }
	}
}