package com.ExcelrProject_2.AutomationExerciseDemo;

import java.io.IOException;
import java.time.Duration;
import java.util.List;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageObject.CartPage;
import pageObject.HomePage;
import pageObject.ProductsPage;
import pageObject.SignUpOrLoginPage;

public class Testcases {
	WebDriver driver;
	HomePage homepage;
	ProductsPage prodpage;
	SignUpOrLoginPage signpage;
	CartPage cp;
	Actions act;
    XSSFSheet sheet;
    WebDriverWait wait;

	@BeforeTest
	public void initialisation() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
		driver.get("http://automationexercise.com");
		homepage = new HomePage(driver);
		prodpage = new ProductsPage(driver);
		signpage = new SignUpOrLoginPage(driver);
		cp=new CartPage(driver);
	}

	@Test(priority = 1)
	public void registerUser() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displaySignupText(),Sheet1.getRow(0).getCell(0).toString());
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(1).getCell(1).toString());
		EnterEmail.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		signpage.clickOnSignupButton();
		Assert.assertEquals(signpage.displayAccountText(),Sheet1.getRow(1).getCell(0).toString());
		signpage.enterTitle();
		WebElement EnterPaswrd=signpage.displayPasswordtab();
		Assert.assertTrue(EnterPaswrd.isDisplayed());
		Assert.assertTrue(EnterPaswrd.isEnabled());
		EnterPaswrd.sendKeys(Sheet1.getRow(1).getCell(3).toString());
		signpage.enterDOBMonths();
		signpage.enterDOBYears();
		signpage.clickOnnewscheckbox();
		signpage.clickOnSpecialoffercheck();
		WebElement Firstname=signpage.displayFirstname();
		Assert.assertTrue(Firstname.isDisplayed());
		Assert.assertTrue(Firstname.isEnabled());
		Firstname.sendKeys(Sheet1.getRow(1).getCell(4).toString());
		WebElement Lastname=signpage.displayLastname();
		Assert.assertTrue(Lastname.isDisplayed());
		Assert.assertTrue(Lastname.isEnabled());
		Lastname.sendKeys(Sheet1.getRow(1).getCell(5).toString());
		WebElement Company=signpage.displayCompany();
		Assert.assertTrue(Company.isDisplayed());
		Assert.assertTrue(Company.isEnabled());
		Company.sendKeys(Sheet1.getRow(1).getCell(6).toString());
		WebElement Address1=signpage.displayAddress1();
		Assert.assertTrue(Address1.isDisplayed());
		Assert.assertTrue(Address1.isEnabled());
		Address1.sendKeys(Sheet1.getRow(1).getCell(7).toString());
        WebElement Address2=signpage.displayAddress2();
		Assert.assertTrue(Address2.isDisplayed());
		Assert.assertTrue(Address2.isEnabled());
		Address2.sendKeys(Sheet1.getRow(1).getCell(8).toString());
		Assert.assertTrue(signpage.displayCountryDrop().isDisplayed());
		Assert.assertTrue(signpage.displayCountryDrop().isEnabled());
		signpage.clickOnCountryDrop();
		WebElement State=signpage.displayState();
		Assert.assertTrue(State.isDisplayed());
		Assert.assertTrue(State.isEnabled());
		State.sendKeys(Sheet1.getRow(1).getCell(9).toString());
		WebElement City=signpage.displayCity();
		Assert.assertTrue(City.isDisplayed());
		Assert.assertTrue(City.isEnabled());
		City.sendKeys(Sheet1.getRow(1).getCell(10).toString());
		WebElement ZipCode=signpage.displayZipcode();		 
		Assert.assertTrue(ZipCode.isDisplayed());
		Assert.assertTrue(ZipCode.isEnabled());
		ZipCode.sendKeys(Sheet1.getRow(1).getCell(11).toString());
		WebElement Mobile=signpage.displayMobile();
		Assert.assertTrue(Mobile.isDisplayed());
		Assert.assertTrue(Mobile.isEnabled());
		Mobile.sendKeys(Sheet1.getRow(1).getCell(12).getRawValue());
		Assert.assertTrue(signpage.displayCreateAccount().isDisplayed());
		Assert.assertTrue(signpage.displayCreateAccount().isEnabled());
		signpage.clickOnCreateaccount();
		Assert.assertEquals(signpage.displayAccountCreate(),Sheet1.getRow(2).getCell(0).toString());
		Assert.assertTrue(signpage.displayACCContinuebutton().isDisplayed());
		Assert.assertTrue(signpage.displayACCContinuebutton().isEnabled());
		signpage.clickOnAccContinue();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(2).getCell(1).toString());
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(),Sheet1.getRow(3).getCell(0).toString());
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();

	}

	@Test(priority = 2)
	public void loginWithValidCredentials() {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displayLoginText(),Sheet1.getRow(4).getCell(0).toString());
		WebElement LogEmail=signpage.loginemailverify();
		WebElement LogPassword=signpage.loginPasswrdverify();
		Assert.assertEquals(LogEmail.getAttribute("placeholder"), Sheet1.getRow(4).getCell(1).toString());
		Assert.assertEquals(LogPassword.getAttribute("placeholder"), Sheet1.getRow(4).getCell(2).toString());
		LogEmail.sendKeys(Sheet1.getRow(5).getCell(1).toString());
		LogPassword.sendKeys(Sheet1.getRow(5).getCell(2).toString());
		signpage.clickOnLogin();
		Assert.assertEquals(signpage.displayLoggedinfo(), Sheet1.getRow(6).getCell(1).toString());
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(),Sheet1.getRow(3).getCell(0).toString());
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();

	}

	@Test(priority = 3)
	public void LoginWithInvalidCredential() {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displayLoginText(),Sheet1.getRow(4).getCell(0).toString());
		WebElement LogEmail=signpage.loginemailverify();
		WebElement LogPassword=signpage.loginPasswrdverify();
		Assert.assertEquals(LogEmail.getAttribute("placeholder"), Sheet1.getRow(4).getCell(1).toString());
		Assert.assertEquals(LogPassword.getAttribute("placeholder"), Sheet1.getRow(4).getCell(2).toString());
		LogEmail.sendKeys(Sheet1.getRow(7).getCell(1).toString());
		LogPassword.sendKeys(Sheet1.getRow(7).getCell(2).toString());
		signpage.clickOnLogin();
		Assert.assertEquals(signpage.displayErrorText(),Sheet1.getRow(8).getCell(0).toString());
	}

	@Test(priority = 4)
	public void logoutUser() {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displayLoginText(),Sheet1.getRow(4).getCell(0).toString());
		WebElement LogEmail=signpage.loginemailverify();
		WebElement LogPassword=signpage.loginPasswrdverify();
		Assert.assertEquals(LogEmail.getAttribute("placeholder"), Sheet1.getRow(4).getCell(1).toString());
		Assert.assertEquals(LogPassword.getAttribute("placeholder"), Sheet1.getRow(4).getCell(2).toString());
		LogEmail.sendKeys(Sheet1.getRow(9).getCell(1).toString());
		LogPassword.sendKeys(Sheet1.getRow(9).getCell(2).toString());
		signpage.clickOnLogin();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(10).getCell(1).toString());
		signpage.clickOnLogout();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
	}

	@Test(priority = 5)
	public void registerWithExistEmail() {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displaySignupText(),Sheet1.getRow(0).getCell(0).toString());
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(9).getCell(0).toString());
		EnterEmail.sendKeys(Sheet1.getRow(9).getCell(1).toString());
		signpage.clickOnSignupButton();
	    Assert.assertEquals(signpage.displaySignupError(),Sheet1.getRow(11).getCell(0).toString());
	}

	@Test(priority = 6)
	public void contactUsVerification() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnContactus();
		Assert.assertEquals(homepage.displayCurrentURL(), Sheet.getRow(2).getCell(1).toString());
		Assert.assertEquals(homepage.Contactformtext(),Sheet.getRow(1).getCell(0).toString());
		homepage.fillTheForm("Aparna", "aparna@gmail.com", "Automation demo", "automation working fine");
		WebElement Uploadfile=homepage.ContactUploadfile();
	    Uploadfile.sendKeys(Sheet.getRow(2).getCell(0).toString());
	    homepage.ContSubmit();
	    homepage.Alert();
	    homepage.clickHomebuttn();
	    Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(0).getCell(1).toString());
	    }

	@Test(priority = 7)
	public void testcasePageVerification() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnTestCases();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(3).getCell(1).toString());
	}

	@Test(priority = 8)
	public void productPageVerification() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnProducts();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(4).getCell(1).toString());
		XSSFSheet Sheet2 =ReadExcelFile.readExcelData("Productpage");
		String Producttext = prodpage.productText();
		Assert.assertEquals(Producttext,Sheet2.getRow(0).getCell(0).toString());
		prodpage.productlist();
		prodpage.clickOnViewProduct();
		prodpage.displayProductname();
		Assert.assertEquals(prodpage.displayProductname(), Sheet2.getRow(0).getCell(1).toString());
		prodpage.displayProductCategory();
		Assert.assertEquals(prodpage.displayProductCategory(),Sheet2.getRow(0).getCell(2).toString());
		prodpage.displayProductAmount();
		Assert.assertEquals(prodpage.displayProductAmount(), Sheet2.getRow(0).getCell(3).toString());
		prodpage.displayProductAvailibility();
		Assert.assertEquals(prodpage.displayProductAvailibility(), Sheet2.getRow(0).getCell(4).toString());
		prodpage.displayProductCondition();
		Assert.assertEquals(prodpage.displayProductCondition(), Sheet2.getRow(0).getCell(5).toString());
		prodpage.displayProductBrand();
		Assert.assertEquals(prodpage.displayProductBrand(), Sheet2.getRow(0).getCell(6).toString());
	}

	@Test(priority = 9)
	public void searchProduct() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnProducts();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(4).getCell(1).toString());
		XSSFSheet Sheet2 =ReadExcelFile.readExcelData("Productpage");
		String Producttext = prodpage.productText();
		Assert.assertEquals(Producttext,Sheet2.getRow(0).getCell(0).toString());
		WebElement SearchProd=prodpage.displaysearchProduct();
		Assert.assertEquals(SearchProd.getAttribute("placeholder"),Sheet2.getRow(1).getCell(0).toString());
		Assert.assertTrue(prodpage.displaysearchProduct().isEnabled());
		SearchProd.sendKeys(Sheet2.getRow(1).getCell(1).toString());
		prodpage.clickOnSearchprodbutn();
		prodpage.scrolltoview();
		Assert.assertEquals(prodpage.searchProdText(),Sheet2.getRow(1).getCell(2).toString());
		prodpage.searchProductList();

	}

	@Test(priority = 10)
	public void subscriptionInhomePageVerification() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.scrollToFooter();
		String SubscriptionText = homepage.subscriptionTextVisibility();
		Assert.assertEquals(SubscriptionText,Sheet.getRow(5).getCell(0).toString());
		WebElement SubEmailVerify = homepage.SubscriptionEmailtabverification();
		Assert.assertTrue(SubEmailVerify.isDisplayed());
		Assert.assertTrue(SubEmailVerify.isEnabled());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		SubEmailVerify.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		homepage.subscribeButton();
		String Succesmessg = homepage.successmessg();
		Assert.assertEquals(Succesmessg, Sheet1.getRow(12).getCell(0).toString());
	}

	@Test(priority = 11)
	public void subscriptionInCartpageVerification() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnCart();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(5).getCell(1).toString());
		homepage.scrollToFooter();
		String SubscriptionText = homepage.subscriptionTextVisibility();
		Assert.assertEquals(SubscriptionText,Sheet.getRow(5).getCell(0).toString());
		WebElement SubEmailVerify = homepage.SubscriptionEmailtabverification();
		Assert.assertTrue(SubEmailVerify.isDisplayed());
		Assert.assertTrue(SubEmailVerify.isEnabled());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		SubEmailVerify.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		homepage.subscribeButton();
		String Succesmessg = homepage.successmessg();
		Assert.assertEquals(Succesmessg, Sheet1.getRow(12).getCell(0).toString());
	}
	@Test(priority=12)
	public void addProductInCart() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.viewcartLink();
		cp.productTable();
		
	}
	
	@Test(priority=13)
	public void verifyProductQuantInCart() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
        cp.randomClickOnViewProduct();
        Assert.assertTrue(homepage.displayCurrentURL().contains(Sheet.getRow(6).getCell(1).toString()));
        XSSFSheet Sheet3=ReadExcelFile.readExcelData("Productpage");
        WebElement ProductQty=cp.displayCartQTY();
        ProductQty.clear();
        ProductQty.sendKeys(Sheet3.getRow(2).getCell(0).getRawValue());
        cp.clickOnAddToCart();
        cp.viewcartLink();
        Assert.assertEquals(cp.qtyInCarttable(),Sheet3.getRow(2).getCell(0).getRawValue());
	}
	
	@Test(priority=14)
	public void placeOrderAndRegWhileCheckout() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(5).getCell(1).toString());
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage");
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		cp.clickOnRegLogin();
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(1).getCell(1).toString());
		EnterEmail.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		signpage.clickOnSignupButton();
		Assert.assertEquals(signpage.displayAccountText(),Sheet1.getRow(1).getCell(0).toString());
		signpage.enterTitle();
		WebElement EnterPaswrd=signpage.displayPasswordtab();
		Assert.assertTrue(EnterPaswrd.isDisplayed());
		Assert.assertTrue(EnterPaswrd.isEnabled());
		EnterPaswrd.sendKeys(Sheet1.getRow(1).getCell(3).toString());
		signpage.enterDOBMonths();
		signpage.enterDOBYears();
		signpage.clickOnnewscheckbox();
		signpage.clickOnSpecialoffercheck();
		WebElement Firstname=signpage.displayFirstname();
		Assert.assertTrue(Firstname.isDisplayed());
		Assert.assertTrue(Firstname.isEnabled());
		Firstname.sendKeys(Sheet1.getRow(1).getCell(4).toString());
		WebElement Lastname=signpage.displayLastname();
		Assert.assertTrue(Lastname.isDisplayed());
		Assert.assertTrue(Lastname.isEnabled());
		Lastname.sendKeys(Sheet1.getRow(1).getCell(5).toString());
		WebElement Company=signpage.displayCompany();
		Assert.assertTrue(Company.isDisplayed());
		Assert.assertTrue(Company.isEnabled());
		Company.sendKeys(Sheet1.getRow(1).getCell(6).toString());
		WebElement Address1=signpage.displayAddress1();
		Assert.assertTrue(Address1.isDisplayed());
		Assert.assertTrue(Address1.isEnabled());
		Address1.sendKeys(Sheet1.getRow(1).getCell(7).toString());
        WebElement Address2=signpage.displayAddress2();
		Assert.assertTrue(Address2.isDisplayed());
		Assert.assertTrue(Address2.isEnabled());
		Address2.sendKeys(Sheet1.getRow(1).getCell(8).toString());
		Assert.assertTrue(signpage.displayCountryDrop().isDisplayed());
		Assert.assertTrue(signpage.displayCountryDrop().isEnabled());
		signpage.clickOnCountryDrop();
		WebElement State=signpage.displayState();
		Assert.assertTrue(State.isDisplayed());
		Assert.assertTrue(State.isEnabled());
		State.sendKeys(Sheet1.getRow(1).getCell(9).toString());
		WebElement City=signpage.displayCity();
		Assert.assertTrue(City.isDisplayed());
		Assert.assertTrue(City.isEnabled());
		City.sendKeys(Sheet1.getRow(1).getCell(10).toString());
		WebElement ZipCode=signpage.displayZipcode();		 
		Assert.assertTrue(ZipCode.isDisplayed());
		Assert.assertTrue(ZipCode.isEnabled());
		ZipCode.sendKeys(Sheet1.getRow(1).getCell(11).toString());
		WebElement Mobile=signpage.displayMobile();
		Assert.assertTrue(Mobile.isDisplayed());
		Assert.assertTrue(Mobile.isEnabled());
		Mobile.sendKeys(Sheet1.getRow(1).getCell(12).getRawValue());
		Assert.assertTrue(signpage.displayCreateAccount().isDisplayed());
		Assert.assertTrue(signpage.displayCreateAccount().isEnabled());
		signpage.clickOnCreateaccount();
		Assert.assertEquals(signpage.displayAccountCreate(),Sheet1.getRow(2).getCell(0).toString());
		Assert.assertTrue(signpage.displayACCContinuebutton().isDisplayed());
		Assert.assertTrue(signpage.displayACCContinuebutton().isEnabled());
		signpage.clickOnAccContinue();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(2).getCell(1).toString());
		homepage.clickOnCart();
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		System.out.println(cp.displayDeliveryaddr());
		System.out.println(cp.displayBillingaddr());
		List <String> DeliveryText = cp.displayDeliveryaddr();
		List <String> BillingText = cp.displayBillingaddr();
		for(int i = 0,j=0; i<DeliveryText.size()-1; i++,j++) {
			Assert.assertEquals(DeliveryText.get(i),Sheet4.getRow(1).getCell(j).toString());
		}		
		cp.displayReviewOrderList();
		WebElement commentBox=cp.enterCommentText();
		commentBox.sendKeys(Sheet4.getRow(0).getCell(1).toString());
		cp.clickOnPlaceorder();
		cp.fillPaymentDetails("sara", "5600670078008900", "100", "08", "2030");
		cp.clickOnPayAndConfrm();
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(),Sheet1.getRow(3).getCell(0).toString());
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();
	
	
	}
	@Test(priority=15)
	public void placeOrderAndRegBeforeCheckout() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(5).getCell(1).toString());
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage");
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		cp.clickOnRegLogin();
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(1).getCell(1).toString());
		EnterEmail.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		signpage.clickOnSignupButton();
		Assert.assertEquals(signpage.displayAccountText(),Sheet1.getRow(1).getCell(0).toString());
		signpage.enterTitle();
		WebElement EnterPaswrd=signpage.displayPasswordtab();
		Assert.assertTrue(EnterPaswrd.isDisplayed());
		Assert.assertTrue(EnterPaswrd.isEnabled());
		EnterPaswrd.sendKeys(Sheet1.getRow(1).getCell(3).toString());
		signpage.enterDOBMonths();
		signpage.enterDOBYears();
		signpage.clickOnnewscheckbox();
		signpage.clickOnSpecialoffercheck();
		WebElement Firstname=signpage.displayFirstname();
		Assert.assertTrue(Firstname.isDisplayed());
		Assert.assertTrue(Firstname.isEnabled());
		Firstname.sendKeys(Sheet1.getRow(1).getCell(4).toString());
		WebElement Lastname=signpage.displayLastname();
		Assert.assertTrue(Lastname.isDisplayed());
		Assert.assertTrue(Lastname.isEnabled());
		Lastname.sendKeys(Sheet1.getRow(1).getCell(5).toString());
		WebElement Company=signpage.displayCompany();
		Assert.assertTrue(Company.isDisplayed());
		Assert.assertTrue(Company.isEnabled());
		Company.sendKeys(Sheet1.getRow(1).getCell(6).toString());
		WebElement Address1=signpage.displayAddress1();
		Assert.assertTrue(Address1.isDisplayed());
		Assert.assertTrue(Address1.isEnabled());
		Address1.sendKeys(Sheet1.getRow(1).getCell(7).toString());
        WebElement Address2=signpage.displayAddress2();
		Assert.assertTrue(Address2.isDisplayed());
		Assert.assertTrue(Address2.isEnabled());
		Address2.sendKeys(Sheet1.getRow(1).getCell(8).toString());
		Assert.assertTrue(signpage.displayCountryDrop().isDisplayed());
		Assert.assertTrue(signpage.displayCountryDrop().isEnabled());
		signpage.clickOnCountryDrop();
		WebElement State=signpage.displayState();
		Assert.assertTrue(State.isDisplayed());
		Assert.assertTrue(State.isEnabled());
		State.sendKeys(Sheet1.getRow(1).getCell(9).toString());
		WebElement City=signpage.displayCity();
		Assert.assertTrue(City.isDisplayed());
		Assert.assertTrue(City.isEnabled());
		City.sendKeys(Sheet1.getRow(1).getCell(10).toString());
		WebElement ZipCode=signpage.displayZipcode();		 
		Assert.assertTrue(ZipCode.isDisplayed());
		Assert.assertTrue(ZipCode.isEnabled());
		ZipCode.sendKeys(Sheet1.getRow(1).getCell(11).toString());
		WebElement Mobile=signpage.displayMobile();
		Assert.assertTrue(Mobile.isDisplayed());
		Assert.assertTrue(Mobile.isEnabled());
		Mobile.sendKeys(Sheet1.getRow(1).getCell(12).getRawValue());
		Assert.assertTrue(signpage.displayCreateAccount().isDisplayed());
		Assert.assertTrue(signpage.displayCreateAccount().isEnabled());
		signpage.clickOnCreateaccount();
		Assert.assertEquals(signpage.displayAccountCreate(),Sheet1.getRow(2).getCell(0).toString());
		Assert.assertTrue(signpage.displayACCContinuebutton().isDisplayed());
		Assert.assertTrue(signpage.displayACCContinuebutton().isEnabled());
		signpage.clickOnAccContinue();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(2).getCell(1).toString());
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		System.out.println(cp.displayDeliveryaddr());
		System.out.println(cp.displayBillingaddr());
		List <String> DeliveryText = cp.displayDeliveryaddr();
		List <String> BillingText = cp.displayBillingaddr();
		for(int i = 0,j=0; i<DeliveryText.size()-1; i++,j++) {
			Assert.assertEquals(DeliveryText.get(i),Sheet4.getRow(1).getCell(j).toString());
		}		
		Assert.assertEquals(cp.displayReviewOrder(),Sheet4.getRow(0).getCell(2).toString());
		cp.displayReviewOrderList();
		WebElement commentBox=cp.enterCommentText();
		commentBox.sendKeys(Sheet4.getRow(0).getCell(1).toString());
		cp.clickOnPlaceorder();
		cp.fillPaymentDetails("sara2", "5600670078008900", "100", "08", "2030");
		cp.clickOnPayAndConfrm();
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(),Sheet1.getRow(3).getCell(0).toString());
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();
	}
	@Test(priority=16)
	public void placeOrderLoginBefrChecout() throws InterruptedException{
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displayLoginText(),Sheet1.getRow(4).getCell(0).toString());
		WebElement LogEmail=signpage.loginemailverify();
		WebElement LogPassword=signpage.loginPasswrdverify();
		Assert.assertEquals(LogEmail.getAttribute("placeholder"), Sheet1.getRow(4).getCell(1).toString());
		Assert.assertEquals(LogPassword.getAttribute("placeholder"), Sheet1.getRow(4).getCell(2).toString());
		LogEmail.sendKeys(Sheet1.getRow(11).getCell(1).toString());
		LogPassword.sendKeys(Sheet1.getRow(11).getCell(2).toString());
		signpage.clickOnLogin();
		Assert.assertEquals(signpage.displayLoggedinfo(), Sheet1.getRow(12).getCell(1).toString());
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage"); 
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		System.out.println(cp.displayDeliveryaddr());
		System.out.println(cp.displayBillingaddr());
		List <String> DeliveryText = cp.displayDeliveryaddr();
		for(int i = 0,j=0; i<DeliveryText.size()-1; i++,j++) {
			Assert.assertEquals(DeliveryText.get(i),Sheet4.getRow(2).getCell(j).toString());
		}		
		Assert.assertEquals(cp.displayReviewOrder(),Sheet4.getRow(0).getCell(2).toString());
		cp.displayReviewOrderList();
		WebElement commentBox=cp.enterCommentText();
		commentBox.sendKeys(Sheet4.getRow(0).getCell(1).toString());
		cp.clickOnPlaceorder();
		cp.fillPaymentDetails("rajula", "6500760087009800", "100", "08", "2030");
		cp.clickOnPayAndConfrm();
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(),Sheet1.getRow(3).getCell(0).toString());
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();
	}
	@Test(priority=17)
	  	public void removProductsFrmCart() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();		
		homepage.clickOnCart();
		int TableSizeBefore = cp.tableSize();
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage"); 
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnCartDelete();
		int TableSizeAfter = cp.tableSize();
		Assert.assertNotEquals(TableSizeAfter, TableSizeBefore);
		System.out.println(TableSizeBefore);
		System.out.println(TableSizeAfter);
	}
	@Test(priority=18)
	public void viewCategoryProducts() throws InterruptedException {
		cp.categoriesText();
		System.out.println(cp.categoriesText());
		cp.scrollToview();
		cp.clickOnWomenCategory();
		cp.clickOnwomenCategoryList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
	    Assert.assertTrue(homepage.displayCurrentURL().contains(Sheet.getRow(7).getCell(1).toString()));
	    XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage");
	    Assert.assertEquals(cp.displayWomenCatText(),Sheet4.getRow(3).getCell(0).toString());
	    cp.menCategory();
	    cp.clickOnMenCatList();
	    Assert.assertTrue(homepage.displayCurrentURL().contains(Sheet.getRow(7).getCell(1).toString()));
	    
	}
	@Test(priority=19)
	public void viewCartAndBrandProducts() throws InterruptedException {
		homepage.clickOnProducts();
		cp.brandName();
		cp.scrollToview();
		cp.clickonaanyBrand();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		Assert.assertTrue(homepage.displayCurrentURL().contains(Sheet.getRow(8).getCell(1).toString()));
		cp.displaybrandProductList();
		cp.clickonaanyBrand();
		Assert.assertTrue(homepage.displayCurrentURL().contains(Sheet.getRow(8).getCell(1).toString()));
		cp.displaybrandProductList();
	}
	@Test(priority=20)
	public void searchProdAndVerfyCartAftrLogin() throws InterruptedException {
		homepage.clickOnProducts();
		XSSFSheet Sheet2 =ReadExcelFile.readExcelData("Productpage");
		String Producttext = prodpage.productText();
		Assert.assertEquals(Producttext,Sheet2.getRow(0).getCell(0).toString());
		WebElement SearchProd=prodpage.displaysearchProduct();
		Assert.assertEquals(SearchProd.getAttribute("placeholder"),Sheet2.getRow(1).getCell(0).toString());
		Assert.assertTrue(prodpage.displaysearchProduct().isEnabled());
		SearchProd.sendKeys(Sheet2.getRow(1).getCell(1).toString());
		prodpage.clickOnSearchprodbutn();
		prodpage.scrolltoview();
		Assert.assertEquals(prodpage.searchProdText(),Sheet2.getRow(1).getCell(2).toString());
		prodpage.searchProductList();
        cp.addToCartList();
		homepage.clickOnCart();
		cp.productTable();
		homepage.clickOnSignup();
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displayLoginText(),Sheet1.getRow(4).getCell(0).toString());
		WebElement LogEmail=signpage.loginemailverify();
		WebElement LogPassword=signpage.loginPasswrdverify();
		Assert.assertEquals(LogEmail.getAttribute("placeholder"), Sheet1.getRow(4).getCell(1).toString());
		Assert.assertEquals(LogPassword.getAttribute("placeholder"), Sheet1.getRow(4).getCell(2).toString());
		LogEmail.sendKeys(Sheet1.getRow(9).getCell(1).toString());
		LogPassword.sendKeys(Sheet1.getRow(9).getCell(2).toString());
		signpage.clickOnLogin();
		homepage.clickOnCart();
		cp.productTable();
			
	}
	@Test(priority=21)
	public void addReviewOnProduct() throws InterruptedException {
		homepage.clickOnProducts();
		XSSFSheet Sheet2 =ReadExcelFile.readExcelData("Productpage");
		String Producttext = prodpage.productText();
		Assert.assertEquals(Producttext,Sheet2.getRow(0).getCell(0).toString());
		prodpage.clickOnViewProduct();
		Assert.assertEquals(prodpage.displayReviewText(),Sheet2.getRow(3).getCell(0).toString());
		Assert.assertEquals(prodpage.dispRevname().getAttribute("placeholder"),Sheet2.getRow(3).getCell(1).toString());
		Assert.assertTrue(prodpage.dispRevname().isEnabled());
		Assert.assertEquals(prodpage.dispRevemail().getAttribute("placeholder"),Sheet2.getRow(3).getCell(2).toString());
		Assert.assertTrue(prodpage.dispRevemail().isEnabled());
		Assert.assertEquals(prodpage.dispRevMesgg().getAttribute("placeholder"), Sheet2.getRow(3).getCell(3).toString());
		prodpage.enterReview("aparna", "aparna@gmail.com","quality Product");
		prodpage.clickOnReviewSubmit();
		
	}
	@Test(priority=22)
	public void addtoCartRecomenditems() throws InterruptedException, IOException {
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage");
		cp.recommendedItems();
		Assert.assertEquals(homepage.reccomendText(),Sheet.getRow(9).getCell(0).toString() );
		cp.addRecommendedItemsToCart();
		cp.viewcartLink();
		Assert.assertEquals(cp.cartITEMName(),Sheet4.getRow(4).getCell(0).toString());
		
			
	}
	@Test(priority=23)
	public void addressDetailverifcationInChekout() throws InterruptedException {
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		Assert.assertTrue(signpage.displaySignUpLink().isDisplayed());
		Assert.assertTrue(signpage.displaySignUpLink().isEnabled());
		homepage.clickOnSignup();
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displaySignupText(),Sheet1.getRow(0).getCell(0).toString());
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(1).getCell(1).toString());
		EnterEmail.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		signpage.clickOnSignupButton();
		Assert.assertEquals(signpage.displayAccountText(),Sheet1.getRow(1).getCell(0).toString());
		signpage.enterTitle();
		WebElement EnterPaswrd=signpage.displayPasswordtab();
		Assert.assertTrue(EnterPaswrd.isDisplayed());
		Assert.assertTrue(EnterPaswrd.isEnabled());
		EnterPaswrd.sendKeys(Sheet1.getRow(1).getCell(3).toString());
		signpage.enterDOBMonths();
		signpage.enterDOBYears();
		signpage.clickOnnewscheckbox();
		signpage.clickOnSpecialoffercheck();
		WebElement Firstname=signpage.displayFirstname();
		Assert.assertTrue(Firstname.isDisplayed());
		Assert.assertTrue(Firstname.isEnabled());
		Firstname.sendKeys(Sheet1.getRow(1).getCell(4).toString());
		WebElement Lastname=signpage.displayLastname();
		Assert.assertTrue(Lastname.isDisplayed());
		Assert.assertTrue(Lastname.isEnabled());
		Lastname.sendKeys(Sheet1.getRow(1).getCell(5).toString());
		WebElement Company=signpage.displayCompany();
		Assert.assertTrue(Company.isDisplayed());
		Assert.assertTrue(Company.isEnabled());
		Company.sendKeys(Sheet1.getRow(1).getCell(6).toString());
		WebElement Address1=signpage.displayAddress1();
		Assert.assertTrue(Address1.isDisplayed());
		Assert.assertTrue(Address1.isEnabled());
		Address1.sendKeys(Sheet1.getRow(1).getCell(7).toString());
        WebElement Address2=signpage.displayAddress2();
		Assert.assertTrue(Address2.isDisplayed());
		Assert.assertTrue(Address2.isEnabled());
		Address2.sendKeys(Sheet1.getRow(1).getCell(8).toString());
		Assert.assertTrue(signpage.displayCountryDrop().isDisplayed());
		Assert.assertTrue(signpage.displayCountryDrop().isEnabled());
		signpage.clickOnCountryDrop();
		WebElement State=signpage.displayState();
		Assert.assertTrue(State.isDisplayed());
		Assert.assertTrue(State.isEnabled());
		State.sendKeys(Sheet1.getRow(1).getCell(9).toString());
		WebElement City=signpage.displayCity();
		Assert.assertTrue(City.isDisplayed());
		Assert.assertTrue(City.isEnabled());
		City.sendKeys(Sheet1.getRow(1).getCell(10).toString());
		WebElement ZipCode=signpage.displayZipcode();		 
		Assert.assertTrue(ZipCode.isDisplayed());
		Assert.assertTrue(ZipCode.isEnabled());
		ZipCode.sendKeys(Sheet1.getRow(1).getCell(11).toString());
		WebElement Mobile=signpage.displayMobile();
		Assert.assertTrue(Mobile.isDisplayed());
		Assert.assertTrue(Mobile.isEnabled());
		Mobile.sendKeys(Sheet1.getRow(1).getCell(12).getRawValue());
		Assert.assertTrue(signpage.displayCreateAccount().isDisplayed());
		Assert.assertTrue(signpage.displayCreateAccount().isEnabled());
		signpage.clickOnCreateaccount();
		Assert.assertEquals(signpage.displayAccountCreate(),Sheet1.getRow(2).getCell(0).toString());
		Assert.assertTrue(signpage.displayACCContinuebutton().isDisplayed());
		Assert.assertTrue(signpage.displayACCContinuebutton().isEnabled());
		signpage.clickOnAccContinue();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(2).getCell(1).toString());
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage"); 
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		System.out.println(cp.displayDeliveryaddr());
		System.out.println(cp.displayBillingaddr());
		List <String> DeliveryText = cp.displayDeliveryaddr();
		List <String> BillingText = cp.displayBillingaddr();
		for(int i = 0,j=0; i<DeliveryText.size()-1; i++,j++) {
			Assert.assertEquals(DeliveryText.get(i),Sheet4.getRow(1).getCell(j).toString());
		}		
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(), "ACCOUNT DELETED!");
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();
	}
	@Test(priority=24)
	public void downloadInvoice() throws InterruptedException {
		homepage.clickOnProducts();
		prodpage.scrolltoview();
		cp.addTocartFirstclick();
		cp.continShopp();
		cp.addToCartSecondClick();
		cp.continShopp();
		homepage.clickOnCart();
		XSSFSheet Sheet4=ReadExcelFile.readExcelData("Cartpage"); 
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		cp.clickOnRegLogin();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		Assert.assertEquals(homepage.displayCurrentURL(),Sheet.getRow(1).getCell(1).toString());
		XSSFSheet Sheet1=ReadExcelFile.readExcelData("Signpage");
		Assert.assertEquals(signpage.displaySignupText(),Sheet1.getRow(0).getCell(0).toString());
		WebElement EnterName=signpage.nameFieldVerify();
		WebElement EnterEmail=signpage.emailfieldVerify();
		Assert.assertEquals(EnterName.getAttribute("placeholder"),Sheet1.getRow(0).getCell(1).toString());
		Assert.assertEquals(EnterEmail.getAttribute("placeholder"),Sheet1.getRow(0).getCell(2).toString());
		EnterName.sendKeys(Sheet1.getRow(1).getCell(1).toString());
		EnterEmail.sendKeys(Sheet1.getRow(1).getCell(2).toString());
		signpage.clickOnSignupButton();
		Assert.assertEquals(signpage.displayAccountText(),Sheet1.getRow(1).getCell(0).toString());
		signpage.enterTitle();
		WebElement EnterPaswrd=signpage.displayPasswordtab();
		Assert.assertTrue(EnterPaswrd.isDisplayed());
		Assert.assertTrue(EnterPaswrd.isEnabled());
		EnterPaswrd.sendKeys(Sheet1.getRow(1).getCell(3).toString());
		signpage.enterDOBMonths();
		signpage.enterDOBYears();
		signpage.clickOnnewscheckbox();
		signpage.clickOnSpecialoffercheck();
		WebElement Firstname=signpage.displayFirstname();
		Assert.assertTrue(Firstname.isDisplayed());
		Assert.assertTrue(Firstname.isEnabled());
		Firstname.sendKeys(Sheet1.getRow(1).getCell(4).toString());
		WebElement Lastname=signpage.displayLastname();
		Assert.assertTrue(Lastname.isDisplayed());
		Assert.assertTrue(Lastname.isEnabled());
		Lastname.sendKeys(Sheet1.getRow(1).getCell(5).toString());
		WebElement Company=signpage.displayCompany();
		Assert.assertTrue(Company.isDisplayed());
		Assert.assertTrue(Company.isEnabled());
		Company.sendKeys(Sheet1.getRow(1).getCell(6).toString());
		WebElement Address1=signpage.displayAddress1();
		Assert.assertTrue(Address1.isDisplayed());
		Assert.assertTrue(Address1.isEnabled());
		Address1.sendKeys(Sheet1.getRow(1).getCell(7).toString());
        WebElement Address2=signpage.displayAddress2();
		Assert.assertTrue(Address2.isDisplayed());
		Assert.assertTrue(Address2.isEnabled());
		Address2.sendKeys(Sheet1.getRow(1).getCell(8).toString());
		Assert.assertTrue(signpage.displayCountryDrop().isDisplayed());
		Assert.assertTrue(signpage.displayCountryDrop().isEnabled());
		signpage.clickOnCountryDrop();
		WebElement State=signpage.displayState();
		Assert.assertTrue(State.isDisplayed());
		Assert.assertTrue(State.isEnabled());
		State.sendKeys(Sheet1.getRow(1).getCell(9).toString());
		WebElement City=signpage.displayCity();
		Assert.assertTrue(City.isDisplayed());
		Assert.assertTrue(City.isEnabled());
		City.sendKeys(Sheet1.getRow(1).getCell(10).toString());
		WebElement ZipCode=signpage.displayZipcode();		 
		Assert.assertTrue(ZipCode.isDisplayed());
		Assert.assertTrue(ZipCode.isEnabled());
		ZipCode.sendKeys(Sheet1.getRow(1).getCell(11).toString());
		WebElement Mobile=signpage.displayMobile();
		Assert.assertTrue(Mobile.isDisplayed());
		Assert.assertTrue(Mobile.isEnabled());
		Mobile.sendKeys(Sheet1.getRow(1).getCell(12).getRawValue());
		Assert.assertTrue(signpage.displayCreateAccount().isDisplayed());
		Assert.assertTrue(signpage.displayCreateAccount().isEnabled());
		signpage.clickOnCreateaccount();
		Assert.assertEquals(signpage.displayAccountCreate(),Sheet1.getRow(2).getCell(0).toString());
		Assert.assertTrue(signpage.displayACCContinuebutton().isDisplayed());
		Assert.assertTrue(signpage.displayACCContinuebutton().isEnabled());
		signpage.clickOnAccContinue();
		Assert.assertEquals(signpage.displayLoggedinfo(),Sheet1.getRow(2).getCell(1).toString());
		homepage.clickOnCart();
		Assert.assertEquals(cp.shoppingCarttext(),Sheet4.getRow(0).getCell(0).toString());
		cp.clickOnProcdToCheckout();
		System.out.println(cp.displayDeliveryaddr());
		System.out.println(cp.displayBillingaddr());
		List <String> DeliveryText = cp.displayDeliveryaddr();
		List <String> BillingText = cp.displayBillingaddr();
		for(int i = 0,j=0; i<DeliveryText.size()-1; i++,j++) {
			Assert.assertEquals(DeliveryText.get(i),Sheet4.getRow(1).getCell(j).toString());
		}		
		Assert.assertEquals(cp.displayReviewOrder(),Sheet4.getRow(0).getCell(2).toString());
		cp.displayReviewOrderList();
		WebElement commentBox=cp.enterCommentText();
		commentBox.sendKeys(Sheet4.getRow(0).getCell(1).toString());
		cp.clickOnPlaceorder();
		cp.fillPaymentDetails("sara", "5600670078008900", "100", "08", "2030");
		cp.clickOnPayAndConfrm();
		cp.clickOndownInvoice();
		cp.clickOnDownldCont();
		signpage.clickOnDeleteaccount();
		Assert.assertEquals(signpage.displayAccdeleteinfo(), "ACCOUNT DELETED!");
		Assert.assertTrue(signpage.displaydeletecontinue().isDisplayed());
		Assert.assertTrue(signpage.displaydeletecontinue().isEnabled());
		signpage.clickOnDeleteContinue();
		
	}
	@Test(priority=25)
	public void verifyScrollupArrowbutnAndScrolDwnFunc() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.scrollToFooter();
		String SubscriptionText = homepage.subscriptionTextVisibility();
		Assert.assertEquals(SubscriptionText,Sheet.getRow(5).getCell(0).toString());
		cp.scrollUpArrow();
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());
	}
	@Test(priority=26)
	public void VerifyScrollupWithoutArrowandScrolldown() throws InterruptedException {
		homepage.headerList();
		XSSFSheet Sheet=ReadExcelFile.readExcelData("Homepage");
		String HomeText = homepage.homepageverification(); 
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());	
		homepage.scrollToFooter();
		String SubscriptionText = homepage.subscriptionTextVisibility();
		Assert.assertEquals(SubscriptionText,Sheet.getRow(5).getCell(0).toString());
		cp.scrollUpArrow();
		Assert.assertEquals(HomeText, Sheet.getRow(0).getCell(0).toString());
		
		
	}
	
}

