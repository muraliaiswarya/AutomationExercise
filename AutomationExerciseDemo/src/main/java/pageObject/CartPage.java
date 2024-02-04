package pageObject;

import java.io.IOException;
import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CartPage {
	WebDriver driver;
	Actions act;
	WebDriverWait wait;

	public CartPage(WebDriver driver) {
		this.driver = driver;

		PageFactory.initElements(driver, this);
		act = new Actions(driver);
		wait=new WebDriverWait(driver,Duration.ofSeconds(10));
	}

	@FindBy(xpath = "(//div[@class='productinfo text-center']/a)[1]")
	WebElement Addtocart1;

	@FindBy(xpath = "//div[@class='modal-footer']/button")
	WebElement Continueshopping;
	@FindBy(xpath = "(//a[@data-product-id='2'])[1]")
	WebElement AddtoCart2;
	@FindBy(xpath = "//p[@class='text-center']/a")
	WebElement ViewCartlink;
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody/tr")
	List<WebElement> Producttable;
	@FindBy(xpath = "//td[@class='cart_description']/h4")
	WebElement ProdNameInCart;
	// @FindBy(xpath = "//div[@class='productinfo text-center']/p[1]")
	// WebElement ProdNameoutcart;
	@FindBy(xpath = "//ul[@class='nav nav-pills nav-justified']/li")
	List<WebElement> RandomViewProduct;
	@FindBy(xpath="//input[@type='number']")
	WebElement CartQuanty;
	@FindBy(xpath = "//button[@type='button']")
	WebElement AddtoCrt;
	@FindBy(xpath="//a[@href='/view_cart']")WebElement ViewCart;
	@FindBy(xpath="//table[@class='table table-condensed']/tbody/tr/td[4]")WebElement QtyInCart;
	@FindBy(xpath = "//ol[@class='breadcrumb']/li[2]")
	WebElement ShoppingCart;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement ProceedToChcOut;
	@FindBy(xpath = "//p[@class='text-center']/a/u")
	WebElement RegLoginlink;
	@FindBy(xpath = "//ul[@class='address item box']/li")
	List<WebElement> Deliveryaddr;
	@FindBy(xpath = "//ul[@class='address alternate_item box']/li")
	List<WebElement> Billingaddr;
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody/tr")
	List<WebElement> ReviewOrder;
	@FindBy(xpath = "(//div[@class='step-one']/h2)[2]")
	WebElement ReviewOrderText;
	@FindBy(xpath = "//textarea[@class='form-control']")
	WebElement CommentText;
	@FindBy(xpath = "//a[@href='/payment']")
	WebElement PlaceOrder;
	@FindBy(name = "name_on_card")
	WebElement PayName;
	@FindBy(xpath = "//input[@name='card_number']")
	WebElement PayCard;
	@FindBy(xpath = "//input[@name='cvc']")
	WebElement PayCVC;
	@FindBy(name = "expiry_month")
	WebElement PayExpMonth;
	@FindBy(name = "expiry_year")
	WebElement PayExpYear;
	@FindBy(id = "submit")
	WebElement PayandConfButton;
	@FindBy(xpath = "(//div[@class='alert-success alert'])[1]")
	WebElement OrderSuccesMessg;
	@FindBy(xpath = "(//a[@class='cart_quantity_delete'][1])")
	WebElement CartDeletecross;
	@FindBy(xpath = "//table[@class='table table-condensed']/tbody/tr")
	List<WebElement> TableSize;
	@FindBy(xpath = "//div[@class='panel-group category-products']")
	WebElement Categorytab;
	@FindBy(xpath = "(//h4[@class='panel-title']/a)[1]")
	WebElement WomenCategory;
	@FindBy(xpath = "(//div[@id='Women']/div/ul/li/a)[2]")
	List<WebElement> WomenCatList;
	@FindBy(xpath = "//h2[@class='title text-center']")
	WebElement WomenText;
	@FindBy(xpath = "(//h4[@class='panel-title']/a)[2]")
	WebElement MenCategory;
	@FindBy(xpath = "//div[@id='Men']/div/ul/li/a")
	List<WebElement> Menslist;
	@FindBy(xpath = "//div[@class='brands-name']/ul/li")
	List<WebElement> BrandList;
	@FindBy(xpath = "//div[@class='productinfo text-center']")
	List<WebElement> BrandProductlist;
	@FindBy(xpath = "//div[@class='productinfo text-center']/a")
	List<WebElement> AddtoCartlist;
	@FindBy(xpath = "(//div[@class='productinfo text-center']/a)[35]")
	WebElement RecAddCart;
	@FindBy(xpath = "//a[@class='btn btn-default check_out']")
	WebElement DownldInVoice;
	@FindBy(xpath = "//a[@class='btn btn-primary']")
	WebElement DownlInvoicecont;
	@FindBy(xpath = "//a[@id='scrollUp']")
	WebElement ScrolUpArrow;
	@FindBy(xpath = "(//div[@class='col-sm-6']/h1)[1]")
	WebElement AutomExerseLogo;
	@FindBy(xpath = "//div[@class='recommended_items']/h2")
	WebElement Recommenditems;
	@FindBy(xpath = "(//div[@class='item active']//div[@class='col-sm-4'])[3]//descendant::div[3]/p")
	private WebElement RecommmendedItemInformation;
	@FindBy(xpath = "(//div[@class='item active']//div[@class='col-sm-4'])[3]//descendant::a")
	private WebElement RecommmendedItemAddToCart;
	@FindBy(xpath = "//u[text()='View Cart']")
	WebElement RecommmendedItemViewCart;
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr/td[2]/h4")
	WebElement CartItemName;
	@FindBy(xpath = "//table[@id='cart_info_table']/tbody/tr/td[3]/p")
	WebElement CartItemPrice;

	public void addTocartFirstclick() throws InterruptedException {

		act.moveToElement(Addtocart1).build().perform();
		Addtocart1.click();
		Thread.sleep(3000);
	}

	public void continShopp() {
		Continueshopping.click();
	}

	public void addToCartSecondClick() throws InterruptedException {

		act.moveToElement(AddtoCart2).build().perform();
		AddtoCart2.click();
		Thread.sleep(3000);
	}

	public void viewcartLink() throws InterruptedException {
		ViewCartlink.click();
		Thread.sleep(1000);
	}

	public List<WebElement> productTable() {
		for (int i = 0; i < Producttable.size(); i++) {
			System.out.println(Producttable.get(i).getText());
		}
		return Producttable;

	}
	/*
	 * public String productNameOutCart() {
	 * System.out.println(ProdNameoutcart.getText()); return
	 * ProdNameoutcart.getText(); }
	 */

	public String ProductNameInCart() {
		System.out.println(ProdNameInCart.getText());
		return ProdNameInCart.getText();

	}

	public void randomClickOnViewProduct() throws InterruptedException {
		Random rand = new Random();
		RandomViewProduct.get(rand.nextInt(RandomViewProduct.size())).click();
		Thread.sleep(5000);

	}

	public WebElement displayCartQTY() {
		return CartQuanty;
	}

	public void clickOnAddToCart() throws InterruptedException {
		AddtoCrt.click();
		Thread.sleep(2000);
	}
	public void viewCART() throws InterruptedException {
		ViewCart.click();
		Thread.sleep(1000);
	}
	public String qtyInCarttable() {
		return QtyInCart.getText();
	}

	public String shoppingCarttext() {
		return ShoppingCart.getText();

	}

	public void clickOnProcdToCheckout() {
		ProceedToChcOut.click();
	}

	public void clickOnRegLogin() {
		RegLoginlink.click();
	}

	public List<String> displayDeliveryaddr() {
		List<String> Text = new ArrayList<String>();
		for (int i = 1; i < Deliveryaddr.size(); i++) {
			Text.add(Deliveryaddr.get(i).getText());
		}
		return Text;
	}

	public List<String> displayBillingaddr() {
		List<String> Text = new ArrayList<String>();
		for (int i = 1; i < Billingaddr.size(); i++) {
			Text.add(Billingaddr.get(i).getText());
		}
		return Text;
	}

	public String displayReviewOrder() {
		return ReviewOrderText.getText();

	}

	public List<WebElement> displayReviewOrderList() {
		for (int i = 0; i < ReviewOrder.size(); i++) {
			System.out.println(ReviewOrder.get(i).getText());
		}
		return ReviewOrder;
	}

	public WebElement enterCommentText() {
		return CommentText;
	}

	public void clickOnPlaceorder() {
		PlaceOrder.click();
	}

	public void fillPaymentDetails(String nam, String crn, String cvv, String Em, String YY) {
		PayName.sendKeys(nam);
		PayCard.sendKeys(crn);
		PayCVC.sendKeys(cvv);
		PayExpMonth.sendKeys(Em);
		PayExpYear.sendKeys(YY);

	}

	public void clickOnPayAndConfrm() throws InterruptedException {
		PayandConfButton.click();
		Thread.sleep(5000);
	}

	public String displaySuccessOrder() {
		return OrderSuccesMessg.getText();

	}

	public void clickOnCartDelete() throws InterruptedException {
		CartDeletecross.click();
		driver.navigate().refresh();
	}

	public int tableSize() {
		return TableSize.size();
	}

	public String categoriesText() {
		return Categorytab.getText();
	}

	public void scrollToview() throws InterruptedException {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("arguments[0].scrollIntoView();", WomenCategory);
		Thread.sleep(1000);
	}

	public void clickOnWomenCategory() throws InterruptedException {
		WomenCategory.click();
		Thread.sleep(5000);
	}

	public void clickOnwomenCategoryList() {
		Random rand = new Random();
		for (int i = 0; i < WomenCatList.size(); i++) {
			WomenCatList.get(rand.nextInt(WomenCatList.size())).click();

		}

	}

	public String displayWomenCatText() {
		return WomenText.getText();

	}

	public void menCategory() throws InterruptedException {
		MenCategory.click();
		Thread.sleep(2000);
	}

	public void clickOnMenCatList() throws InterruptedException {
		Random r = new Random();
		Menslist.get(r.nextInt(Menslist.size())).click();
		Thread.sleep(1000);
	}

	public List<WebElement> brandName() {
		for (int i = 0; i < BrandList.size(); i++) {
			System.out.println(BrandList.get(i).getText());
		}
		return BrandList;
	}

	public void clickonaanyBrand() {
		Random r = new Random();
		BrandList.get(r.nextInt(BrandList.size())).click();
	}

	public List<WebElement> displaybrandProductList() {
		for (int i = 0; i < BrandProductlist.size(); i++) {
			System.out.println(BrandProductlist.get(i).getText());

		}
		return BrandProductlist;
	}

	public void addToCartList() {
		for (int i = 0; i < AddtoCartlist.size(); i++) {
			AddtoCartlist.get(i).click();
			Continueshopping.click();
		}
	}

	
	public void clickOndownInvoice() {
		DownldInVoice.click();
	}

	public void clickOnDownldCont() {
		DownlInvoicecont.click();

	}

	public void scrollUpArrow() throws InterruptedException {
		ScrolUpArrow.click();
		Thread.sleep(1000);
	}

	public void scrollupwithoutArrow() {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		//js.executeScript(window.scrollTo(0, document.body.scrollHeight));
		js.executeScript("arguments[0].scrollIntoView();", AutomExerseLogo);
	}
	
	public void recommendedItems() {
		JavascriptExecutor js=(JavascriptExecutor) driver;
	    js.executeScript("arguments[0].scrollIntoView(true);",Recommenditems);
		  wait.until(ExpectedConditions.visibilityOf(Recommenditems));
	}

	
		
	public void addRecommendedItemsToCart() throws IOException {
		
		wait.until(ExpectedConditions.visibilityOf(RecommmendedItemAddToCart));
		RecommmendedItemAddToCart.click();
		
	}

public String cartITEMName() {
	   return CartItemName.getText();
}
}
	

	
	



