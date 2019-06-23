package pages;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class FundComparePage extends BaseClass{

	public WebDriver driver;

	public FundComparePage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id="infoIcon")
	WebElement infoIcon;

	@FindBy(id = "fundInput0")
	WebElement fundIdentifierInputOne;

	@FindBy(id = "fundInput1")
	WebElement fundIdentifierInputTwo;

	@FindBy(id = "fundInput2")
	WebElement fundIdentifierInputThree;

	@FindBy(id = "fundInput3")
	WebElement fundIdentifierInputFour;

	@FindBy(id = "searchLink")
	WebElement searchLink;

	@FindBy(id="fcSearchResults")
	WebElement fundLink;

	@FindBy(xpath = "//a[contains(text(), 'Vanguard Australian Corporate Fixed Interest Index ETF')]")
	WebElement fundLinks;

	@FindBy(id = "replaceButton0")
	WebElement replaceBtn;

	@FindBy(id="removeButton1")
	WebElement removeBtn;
	

	public WebElement getInfoIcon() {
		return infoIcon;
	}

	public WebElement getFundIdentifierInputOne() {
		return fundIdentifierInputOne;
	}

	public WebElement getFundIdentifierInputTwo() {
		return fundIdentifierInputTwo;
	}

	public WebElement getFundIdentifierInputThree() {
		return fundIdentifierInputThree;
	}

	public WebElement getFundIdentifierInputFour() {
		return fundIdentifierInputFour;
	}

	public WebElement getSearchLink() {
		return searchLink;
	}

	public WebElement getReplaceBtn() {
		return replaceBtn;
	}

	public WebElement getFundLink() {
		return fundLink;
	}

	public WebElement getFundLinks() {
		return fundLinks;
	}

	public WebElement getRemoveBtn(){
		return removeBtn;
	}

}
	