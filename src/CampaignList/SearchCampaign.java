package CampaignList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import com.login.MyWebDriver;
import com.login.XmlParse;

public class SearchCampaign {
	private WebDriver wd;

	public void SearchOneCampaign() throws InterruptedException {
		String keyword = XmlParse.parse("keywords");
		wd = MyWebDriver.getInstance();
		WebElement Keyword = wd
				.findElement(By
						.xpath("//div[@id='search']/span[@id='srSpan']/input[@id='keyword']"));
		Keyword.sendKeys(keyword);
		Thread.sleep(2000);
		WebElement SearchBtn = wd.findElement(By
				.xpath("//input[@class='btn_search']"));
		SearchBtn.click();
	}

	public void goCreativePage() {

		wd = MyWebDriver.getInstance();
		wd.findElement(By.xpath("//tbody/tr/td[@class ='list taleft']/input"))
				.click();
	}
}
