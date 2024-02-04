package pageObject;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class SignUpOrLoginPage {

	public SignUpOrLoginPage(WebDriver driver) {
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@href='/login']")
	WebElement Signuplink;
	@FindBy(xpath = "//div[@class='signup-form']/h2")
	WebElement SignupText;
	@FindBy(xpath = "//input[@type='text']")
	WebElement SignupNametab;
	@FindBy(xpath = "//input[@data-qa='signup-email']")
	WebElement SignUpEmailtab;
	@FindBy(xpath = "//button[@data-qa='signup-button']")
	WebElement SignUpButton;
	@FindBy(xpath = "//h2[@class='title text-center']/b[1]")
	WebElement AccountinfoText;
	@FindBy(xpath = "//div[@class='radio-inline'][2]/label")
	WebElement TitleElement;
	@FindBy(xpath = "//input[@id='name']")
	WebElement Name;
	@FindBy(id = "email")
	WebElement Email;
	@FindBy(id = "password")
	WebElement Password;
	@FindBy(id = "days")
	WebElement DOBDays;
	@FindBy(id = "months")
	WebElement DOBMonths;
	@FindBy(id = "years")
	WebElement DOBYears;
	@FindBy(id = "newsletter")
	WebElement SignUpcheckbox;
	@FindBy(id = "optin")
	WebElement SpecialoffrChekbox;
	@FindBy(id = "first_name")
	WebElement FirstName;
	@FindBy(id = "last_name")
	WebElement LastName;
	@FindBy(id = "company")
	WebElement Company;
	@FindBy(id = "address1")
	WebElement Address1;
	@FindBy(id = "address2")
	WebElement Address2;
	@FindBy(id = "country")
	WebElement Country;
	@FindBy(id = "state")
	WebElement State;
	@FindBy(id = "city")
	WebElement City;
	@FindBy(id = "zipcode")
	WebElement Zipcode;
	@FindBy(id = "mobile_number")
	WebElement MobileNumber;
	@FindBy(xpath = "//button[@data-qa='create-account']")
	WebElement CreateAccntButton;
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement Accountcreatinfo;
	@FindBy(xpath = "//div[@class='pull-right']/a")
	WebElement AcccreateContinue;
	@FindBy(xpath = "//ul[@class='nav navbar-nav']/li[10]/a")
	WebElement Loggedininfo;
	@FindBy(xpath = "//a[@href='/delete_account']")
	WebElement DeleteAccount;
	@FindBy(xpath = "//h2[@data-qa='account-deleted']")
	WebElement Accountdeleteinfo;
	@FindBy(xpath = "//a[text()='Continue']")
	WebElement Accdeletecontinue;
	@FindBy(xpath = "//h2[text()=\"Login to your account\"]")
	WebElement LoginText;
	@FindBy(xpath = "//input[@data-qa='login-email']")
	WebElement Loginemail;
	@FindBy(xpath = "//input[@data-qa='login-password']")
	WebElement Loginpasswrd;
	@FindBy(xpath = "//button[@data-qa='login-button']")
	WebElement Loginbutn;
	@FindBy(xpath = "//div[@class='login-form']/form/p")
	WebElement Errortext;
	@FindBy(xpath = "//a[text()=\" Logout\"]")
	WebElement Logoutlink;
	@FindBy(xpath = "//div[@class='signup-form']/form/p")
	WebElement Signuperror;

	public WebElement displaySignUpLink() {
		return Signuplink;
	}

	public void clickSignup() {
		Signuplink.click();
	}

	public String displaySignupText() {
		return SignupText.getText();
	}

	public WebElement nameFieldVerify() {
		return SignupNametab;

	}

	public WebElement emailfieldVerify() {
		return SignUpEmailtab;
	}

	public void enterNameAndEmail(String name, String email) {
		SignupNametab.sendKeys(name);
		SignUpEmailtab.sendKeys(email);
	}

	public void clickOnSignupButton() {
		SignUpButton.click();
	}

	public String displayAccountText() {
		return AccountinfoText.getText();
	}

	public void enterTitle() {
		TitleElement.click();

	}

	public WebElement displayPasswordtab() {
		return Password;

	}

	public void enterPassword(String pw) {
		Password.sendKeys(pw);
	}

	public WebElement enterDOBDays() {
		Select s = new Select(DOBDays);
		DOBDays.click();
		s.selectByVisibleText("10");
		return DOBDays;
	}

	public WebElement enterDOBMonths() {
		Select s = new Select(DOBMonths);
		DOBMonths.click();
		s.selectByVisibleText("January");
		return DOBMonths;
	}

	public WebElement enterDOBYears() {
		Select s = new Select(DOBYears);
		DOBYears.click();
		s.selectByVisibleText("2013");
		return DOBYears;
	}

	public void clickOnnewscheckbox() {
		SignUpcheckbox.click();
	}

	public void clickOnSpecialoffercheck() {
		SpecialoffrChekbox.click();
	}

	public WebElement displayFirstname() {
		return FirstName;
	}

	public void enterFirstname(String fn) {
		FirstName.sendKeys(fn);
	}

	public WebElement displayLastname() {
		return LastName;
	}

	public void enterLastname(String ln) {
		LastName.sendKeys(ln);
	}

	public WebElement displayCompany() {
		return Company;

	}

	public void enterCompany(String cm) {
		Company.sendKeys(cm);
	}

	public WebElement displayAddress1() {
		return Address1;

	}

	public void enterAddress1(String add1) {
		Address1.sendKeys(add1);
	}

	public WebElement displayAddress2() {
		return Address2;

	}

	public void enterAddress2(String add2) {
		Address2.sendKeys(add2);

	}

	public WebElement displayCountryDrop() {
		return Country;

	}

	public WebElement clickOnCountryDrop() {
		Select s = new Select(Country);
		Country.click();
		s.selectByVisibleText("India");
		return Country;
	}

	public WebElement displayState() {
		return State;

	}

	public void enterState(String st) {
		State.sendKeys(st);
	}

	public WebElement displayCity() {
		return City;

	}

	public void enterCity(String cty) {
		City.sendKeys(cty);

	}

	public WebElement displayZipcode() {
		return Zipcode;

	}

	public void enterZipcode(String zip) {
		Zipcode.sendKeys(zip);
	}

	public WebElement displayMobile() {
		return MobileNumber;

	}

	public void enterMobilenum(String mn) {
		MobileNumber.sendKeys(mn);
	}

	public WebElement displayCreateAccount() {
		return CreateAccntButton;

	}

	public void clickOnCreateaccount() {
		CreateAccntButton.click();
	}

	public String displayAccountCreate() {
		return Accountcreatinfo.getText();

	}

	public WebElement displayACCContinuebutton() {
		return AcccreateContinue;
	}

	public void clickOnAccContinue() throws InterruptedException {
		AcccreateContinue.click();
		Thread.sleep(1000);
	}

	public String displayLoggedinfo() {
		return Loggedininfo.getText();
	}

	public void clickOnDeleteaccount() {
		DeleteAccount.click();
	}

	public String displayAccdeleteinfo() {
		return Accountdeleteinfo.getText();

	}

	public WebElement displaydeletecontinue() {
		return Accdeletecontinue;
	}

	public void clickOnDeleteContinue() {
		Accdeletecontinue.click();
	}

	public String displayLoginText() {
		return LoginText.getText();

	}

	public WebElement loginemailverify() {
		return Loginemail;

	}

	public WebElement loginPasswrdverify() {
		return Loginpasswrd;

	}

	public void enterEmailAndPassword(String nm, String pw) {
		Loginemail.sendKeys(nm);
		Loginpasswrd.sendKeys(pw);
	}

	public void clickOnLogin() {
		Loginbutn.click();
	}

	public String displayErrorText() {
		return Errortext.getText();

	}

	public void clickOnLogout() {
		Logoutlink.click();
	}

	public String displaySignupError() {
		return Signuperror.getText();
	}

	
	

}
