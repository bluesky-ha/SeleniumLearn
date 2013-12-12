package com.creativelist;

import java.io.IOException;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.xml.sax.SAXException;

import CampaignList.SearchCampaign;

import com.login.LoginPageTestXML;

public class CreativeList {
	@BeforeClass
	public void beforeClass() throws InterruptedException, SAXException, IOException{
		LoginPageTestXML lp = new LoginPageTestXML();
		lp.login();
		
		SearchCampaign sc = new SearchCampaign();
		sc.SearchOneCampaign();
		
	}
	@Test
	public void creativeList(){
		SearchCampaign sc = new SearchCampaign();
		sc.goCreativePage();
	}

}
