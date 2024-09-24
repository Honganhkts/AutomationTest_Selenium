package automation.testsuite;

import static org.testng.Assert.assertTrue;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import automation.common.CommonBase;
import automation.constant.CT_PageURLs;
import automation.page.HomePage_BepAnToan;

public class ChauVoiRuaBat_BepAnToan extends CommonBase {
	@BeforeMethod
	public void openChrome() {
		driver = initChromeDriver(CT_PageURLs.URL_BEPANTOAN);
	}
	@Test(priority=1)
	public void clickDanhMucChauRuachenBat() throws InterruptedException {
		HomePage_BepAnToan ListProductTheoDanhMuc = new HomePage_BepAnToan(driver);
		ListProductTheoDanhMuc.locTheoDanhMucChauRuaChenBat();
		List<Integer> danhSachChauRua = ListProductTheoDanhMuc.xuatDanhSachSanPham();
		//assertTrue(isElementVisibility(By.xpath("//h1[contains(text(),'Chậu rửa chén bát')]")));
		//Thread.sleep(3000);
		//Assert.assertTrue(HomePage_BepAnToan.kiemTraLocSanPhamTheoDanhMuc(danhSachChauRua));
		assertTrue(isElementVisibility(By.xpath("//h1[contains(text(),'Chậu rửa chén bát')]")));
	}
	@Test(priority=2)
	public void clickDanhMucVoiRuaChenBat() throws InterruptedException {
		HomePage_BepAnToan ListProductTheoDanhMuc = new HomePage_BepAnToan(driver);
		ListProductTheoDanhMuc.locTheoDanhMucVoiRuaChenBat();
		List<Integer> danhSachVoiRua = ListProductTheoDanhMuc.xuatDanhSachSanPham();
		//Assert.assertTrue(HomePage_BepAnToan.kiemTraLocSanPhamTheoDanhMuc(danhSachVoiRua));
		assertTrue(isElementVisibility(By.xpath("//h1[contains(text(),'Vòi rửa chén bát')]")));
	}
//	@Test(priority=3)
//	public void clickHangSanXuat() throws InterruptedException {
//		HomePage_BepAnToan ListProductTheoHangSanXuat = new HomePage_BepAnToan(driver);
//		ListProductTheoHangSanXuat.kiemTraHangSanXuat();
//	}
	@Test(priority=4)
	public void clickGiamGiaNhieu() throws InterruptedException {
		HomePage_BepAnToan ListProductTheoGiamGia = new HomePage_BepAnToan(driver);
		ListProductTheoGiamGia.danhSachGiamGiaNhieu();
		List<Integer> danhSachPhanTramGiamGia = ListProductTheoGiamGia.xuatDanhSachSanPham();
		Assert.assertTrue(HomePage_BepAnToan.kiemTraSapXepGiamGia(danhSachPhanTramGiamGia));
	}
	@Test(priority=5)
	public void clickMucGiaNhoHon3() throws InterruptedException {
		HomePage_BepAnToan ListProductTheoMucGia = new HomePage_BepAnToan(driver);
		ListProductTheoMucGia.danhSachTheoMucGia();
		List<Integer> danhSachPhanTramGiamGia = ListProductTheoMucGia.xuatDanhSachSanPham();
	}
	
	
	@AfterMethod
	public void closeBrowser() {
		driver.close();
	}
}
