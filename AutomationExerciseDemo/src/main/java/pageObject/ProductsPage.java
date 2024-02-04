package pageObject;

import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProductsPage {

	WebDriver driver;
	

	public ProductsPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement ProductText;
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	List<WebElement> Productlist;
	@FindBy(xpath = "//a[@href='/products']")
	WebElement Productlink;
	@FindBy(xpath = "//a[@href='/product_details/1']")
	WebElement ViewProduct;
	@FindBy(xpath = "//div[@class='product-information']/h2")
	WebElement Productname;
	@FindBy(xpath = "//div[@class='product-information']/p")
	WebElement ProductCategory;
	@FindBy(xpath = "//div[@class='product-information']/span/span")
	WebElement ProductAmount;
	@FindBy(xpath = "//div[@class='product-information']/p[2]")
	WebElement ProductAvailability;
	@FindBy(xpath = "//div[@class='product-information']/p[3]")
	WebElement Productcondition;
	@FindBy(xpath = "//div[@class='product-information']/p[4]")
	WebElement ProductBrand;
	@FindBy(id = "search_product")
	WebElement Searchproduct;
	@FindBy(id = "submit_search")
	WebElement ClickSearch;
	@FindBy(xpath = "//h2[text()='Searched Products']")
	WebElement SearchprodText;
	@FindBy(xpath = "//div[@class='single-products']/div/p")
	List<WebElement> SearchProductList;
	@FindBy(xpath="//ul[@class='nav nav-tabs']/li/a")WebElement ReviewText;
	@FindBy(id="name")WebElement ReviewName;
	@FindBy(id="email")WebElement ReviewEmail;
	@FindBy(id="review")WebElement ReviewMessg;
	@FindBy(id="button-review")WebElement ReviewSubmt;
	public void ClickproductLink() {
		Productlink.click();
	}

	public String productText() {
		return ProductText.getText();
	}

	public List<WebElement> productlist() {
		for (int i = 0; i < Productlist.size(); i++) {
			System.out.println(Productlist.get(i).getText());
		}
		return Productlist;
	}

	public void clickOnViewProduct() {
		ViewProduct.click();
	}

	public String displayProductname() {
		return Productname.getText();
	}

	public String displayProductCategory() {
		return ProductCategory.getText();

	}

	public String displayProductAmount() {
		return ProductAmount.getText();
	}

	public String displayProductAvailibility() {
		return ProductAvailability.getText();

	}

	public String displayProductCondition() {
		return Productcondition.getText();
	}

	public String displayProductBrand() {
		return ProductBrand.getText();
	}

	public WebElement displaysearchProduct() {
		return Searchproduct;
	}

	public void enterProductname(String pname) {
		Searchproduct.sendKeys(pname);
	}

	public void clickOnSearchprodbutn() {
		ClickSearch.click();
	}

	public String searchProdText() {

		return SearchprodText.getText();
	}

	public List<WebElement> searchProductList() {
		for(int i=0;i<SearchProductList.size();i++) {
		System.out.println(SearchProductList.get(i).getText());	
		}
		return SearchProductList;
		
	}
	public void scrolltoview() throws InterruptedException {
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();",ProductText);
		Thread.sleep(1000);
		}
	public String displayReviewText() {
		return ReviewText.getText();
	}
	public WebElement dispRevname() {
		return ReviewName;
	}
	public WebElement dispRevemail() {
		return  ReviewEmail;
	}
	public WebElement dispRevMesgg() {
		return ReviewMessg;
	}

	public void enterReview(String nm, String em, String rv) {
	ReviewName.sendKeys(nm);
	ReviewEmail.sendKeys(em);
	ReviewMessg.sendKeys(rv);	
	}
	
	public void clickOnReviewSubmit() {
		ReviewSubmt.click();
	}
}
