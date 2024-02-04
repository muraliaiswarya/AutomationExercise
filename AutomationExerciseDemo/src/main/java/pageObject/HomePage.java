package pageObject;

import java.util.List;

import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	WebDriver driver;

	public HomePage(WebDriver driver) {

		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li/a[1]")
	List<WebElement> Headerlist;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li")
	private List<WebElement> AfterHeaderList;
	@FindBy(xpath = "//div[@class='col-sm-6']/child::h2")
	WebElement Homepagetext;
	@FindBy(xpath = "//div[@class='single-widget']/h2")
	WebElement SubscriptionText;
	@FindBy(id = "susbscribe_email")
	WebElement SubsEmailTab;
	@FindBy(id = "subscribe")
	WebElement SubscButton;
	@FindBy(xpath = "//div[@class='footer-widget']")
	WebElement Footerstart;
	@FindBy(xpath = "//div[@class='alert-success alert']")
	WebElement Succesmessage;
	@FindBy(xpath = "(//h2[@class='title text-center'])[2]")
	WebElement Contactformtext;
	@FindBy(xpath = "//div[@id='form-section']/form/div[1]/input")
	WebElement ContFormName;
	@FindBy(xpath = "//div[@id='form-section']/form/div[2]/input")
	WebElement ContFormEmail;
	@FindBy(xpath = "//div[@id='form-section']/form/div[3]/input")
	WebElement ContFormSub;
	@FindBy(id = "message")
	WebElement ContFormMessg;
	@FindBy(xpath = "//input[@type='file']")
	WebElement ContactUploadfile;
	@FindBy(xpath = "//input[@data-qa='submit-button']")
	WebElement ContSubmit;
	@FindBy(xpath = "//a[@class='btn btn-success']/span/i")
	WebElement ClickHome;
	@FindBy(xpath = "//div[@class='recommended_items']/h2")
	WebElement Recommenditemstext;
	
	

	public String displayCurrentURL() {
		return driver.getCurrentUrl();
	}

	public void headerList() {
		for (int i = 0; i < Headerlist.size(); i++) {
			System.out.println(Headerlist.get(i).getText());
		}
		// System.out.println(Headerlist.get(0).getText());
	}

	public void clickOnHome() {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("Home")) {
				Headerlist.get(i).click();
				break;
			}

		}

	}

	public void clickOnProducts() throws InterruptedException {
		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals(" Products")) {
				Headerlist.get(i).click();
				Thread.sleep(4000);
				break;
			}
		}
	}

	public void clickOnCart() throws InterruptedException {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("Cart")) {
				Headerlist.get(i).click();
				Thread.sleep(1000);
				break;
			}
		}
	}

	public void clickOnSignup() {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("Signup / Login")) {
				Headerlist.get(i).click();
				break;
			}
		}
	}

	public void clickOnTestCases() throws InterruptedException {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("Test Cases")) {
				Headerlist.get(i).click();
				Thread.sleep(3000);
				break;
			}
		}
	}

	public void clickOnAPITesting() {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("API Testing")) {
				Headerlist.get(i).click();
				break;
			}
		}
	}

	public void clickOnVideoTutorials() {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals(" VideoTutorials")) {
				Headerlist.get(i).click();
				break;
			}
		}
	}

	public void clickOnContactus() {

		for (int i = 0; i < Headerlist.size(); i++) {
			if (Headerlist.get(i).getText().equals("Contact us")) {
				Headerlist.get(i).click();
				break;
			}
		}
	}

	public String homepageverification() {
		return Homepagetext.getText();
	}

	public WebElement footerWidget() {
		return Footerstart;
	}

	public WebElement scrollToFooter() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", Footerstart);
		return Footerstart;
	}

	public WebElement ContactUploadfile() {

		return ContactUploadfile;
	}

	public void ContSubmit() {
		ContSubmit.click();
	}

	public String subscriptionTextVisibility() {

		return SubscriptionText.getText();
	}

	public WebElement SubscriptionEmailtabverification() {
		return SubsEmailTab;
	}

	public void SubsriptionEmail(String EM) throws InterruptedException {
		SubsEmailTab.sendKeys(EM);
		Thread.sleep(1000);
	}

	public void subscribeButton() {
		SubscButton.click();

	}

	public String successmessg() {
		return Succesmessage.getText();

	}

	public String Contactformtext() {
		return Contactformtext.getText();

	}

	public void fillTheForm(String cnm, String cem, String sub, String messg) throws InterruptedException {

		ContFormName.sendKeys(cnm);
		ContFormEmail.sendKeys(cem);
		ContFormSub.sendKeys(sub);
		Thread.sleep(1000);
		ContFormMessg.sendKeys(messg);

	}

	/*//public void scrolltoReccomnded() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeAsyncScript("arguments[0].scrollIntoView();", Recommenditemstext);
		Thread.sleep(5000);
	}*/

	public String reccomendText() {
		return Recommenditemstext.getText();
	}

	public void Alert() {
		Alert a = driver.switchTo().alert();
		a.accept();
	}

	public void clickHomebuttn() throws InterruptedException {
		ClickHome.click();
		Thread.sleep(4000);

	}
}
