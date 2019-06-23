package vangaurdtestsuite;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.FundComparePage;
import pages.IndividualInvestorHomePage;
import pages.InvesterHomePage;


import java.io.IOException;

public class fundCompareTest extends BaseTest {

    private static final Logger log = LogManager.getLogger(fundCompareTest.class.getName());

    @Test(priority = 0)
    public void fundCompare() throws IOException, InterruptedException {
        InvesterHomePage investerHomePage = new InvesterHomePage(driver);
        IndividualInvestorHomePage individualInvestorHomePage = new IndividualInvestorHomePage(driver);
        FundComparePage fundComparePage = new FundComparePage(driver);

        log.info("Starting the fund compare test flow");
        loadURL(driver, properties.getProperty("URL"));
        investerHomePage.getIndividualSmsfBtn().click();
        explicitWait(individualInvestorHomePage.getFindProductBtn(), 5);
        Assert.assertTrue(individualInvestorHomePage.getFindProductBtn().isDisplayed());
        individualInvestorHomePage.getFundCompareBtn().click();
        windowSwitcher();
        explicitWait(fundComparePage.getInfoIcon(), 5);
        Assert.assertTrue(fundComparePage.getInfoIcon().isDisplayed());
        fundComparePage.getFundIdentifierInputOne().sendKeys(properties.getProperty("FUNDONE"));
        fundComparePage.getSearchLink().click();
        Assert.assertTrue(fundComparePage.getReplaceBtn().isDisplayed());
        fundComparePage.getFundIdentifierInputTwo().sendKeys(properties.getProperty("FUNDTWO"));
        fundComparePage.getFundLinks().click();
        Assert.assertTrue(fundComparePage.getRemoveBtn().isDisplayed());
        log.info("Fund Compare successfully completed");
    }


}