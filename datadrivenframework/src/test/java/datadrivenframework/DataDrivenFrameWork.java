package datadrivenframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DataDrivenFrameWork {
		public static void main(String[] args) throws EncryptedDocumentException, IOException {
			FileInputStream fis = new FileInputStream("./datas/datas.xlsx");
			Workbook wb = WorkbookFactory.create(fis);

			String firstName = wb.getSheet("sheet1").getRow(0).getCell(0).getStringCellValue();
			System.out.println(firstName);
			String lastName = wb.getSheet("sheet1").getRow(1).getCell(0).getStringCellValue();
			System.out.println(lastName);
			String enterEmail = wb.getSheet("sheet1").getRow(2).getCell(0).getStringCellValue();
			System.out.println(enterEmail);
			String reenterEmail = wb.getSheet("sheet1").getRow(3).getCell(0).getStringCellValue();
			System.out.println(reenterEmail);
			String password = wb.getSheet("sheet1").getRow(4).getCell(0).getStringCellValue();
			System.out.println(password);
			double days = wb.getSheet("sheet1").getRow(5).getCell(0).getNumericCellValue();
			double months = wb.getSheet("sheet1").getRow(6).getCell(0).getNumericCellValue();
			String years = wb.getSheet("sheet1").getRow(7).getCell(0).getStringCellValue();
			System.out.println(days);
			System.out.println(months);
			System.out.println(years);

			
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(20,TimeUnit.SECONDS);
			driver.get("https://www.facebook.com/");
			driver.findElement(By.xpath("//a[contains(text(),'Create new account')]")).click();
			driver.findElement(By.name("firstname")).sendKeys(firstName);
			driver.findElement(By.name("lastname")).sendKeys(lastName);
			driver.findElement(By.xpath("//input[@name='reg_email__']")).sendKeys(enterEmail);
			driver.findElement(By.xpath("//input[@name='reg_email_confirmation__']")).sendKeys(reenterEmail);
			driver.findElement(By.id("password_step_input")).sendKeys(password);
			WebElement day = driver.findElement(By.id("day"));
			Select sel = new Select(day);
			sel.selectByIndex((int)days);
			WebElement month1 = driver.findElement(By.id("month"));
			Select sels = new Select(month1);
			sels.selectByIndex((int)months);
			WebElement year1 = driver.findElement(By.id("year"));
			Select selss = new Select(year1);
			selss.selectByValue(years);
			driver.findElement(By.xpath("//label[text()='Male']")).click();
			driver.findElement(By.xpath("(//button[contains(text(),'Sign Up')])[1]")).click();
			driver.quit();
		}

	}

