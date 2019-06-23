package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class InvesterHomePage extends BaseClass{
	
	public WebDriver driver;
	
	public InvesterHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Individual & SMSF investors")
	WebElement individualSmsfBtn;
	

	public WebElement getIndividualSmsfBtn() {
		return individualSmsfBtn;
	}

}
	