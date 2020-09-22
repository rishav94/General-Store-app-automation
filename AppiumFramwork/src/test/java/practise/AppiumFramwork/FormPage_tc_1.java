package practise.AppiumFramwork;



import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import pageObjects.FormPage;

public class FormPage_tc_1  extends base{
	
	

	@Test
	public void testcase_1() throws IOException, InterruptedException{
		service=startServer();
		// TODO Auto-generated method stub
		AndroidDriver<AndroidElement> driver=Capabilities("AppName");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		FormPage formpage=new FormPage(driver);
		
		formpage.nameField().sendKeys("hello");
		formpage.femaleOption().click();
		formpage.countryOption().click();
		Utilities u=new Utilities(driver);
		u.scrollToText("Argentina");
		driver.findElementByXPath("//*[@text='Argentina']").click();
		formpage.letShop_button().click();
		
		service.stop();

	}

}
