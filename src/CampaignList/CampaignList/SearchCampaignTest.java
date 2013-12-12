package CampaignList.CampaignList;


import java.io.IOException;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeClass;
import org.xml.sax.SAXException;

import CampaignList.SearchCampaign;

import com.login.LoginPage;
import com.login.LoginPageTestXML;


public class SearchCampaignTest {
	@BeforeClass
	public void beforeClass() throws InterruptedException, SAXException, IOException {
		LoginPageTestXML lp = new LoginPageTestXML();
		lp.login();
		
	}

	@Test
	public void SearchCampaignOne() throws InterruptedException {
		SearchCampaign sc = new SearchCampaign();
		sc.SearchOneCampaign();

	}
}
