package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class IndividualInvestorHomePage extends BaseClass{

	public WebDriver driver;

	public IndividualInvestorHomePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	@FindBy(linkText="Fund compare")
	WebElement fundCompareBtn;

	@FindBy(id="fundAutocomplete")
	WebElement findProductBtn;

	public WebElement getFundCompareBtn() {
		return fundCompareBtn;
	}

	public WebElement getFindProductBtn() {
		return findProductBtn;
	}
}
	