package pageObjects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;

public class FormPage {
	
	public FormPage(AndroidDriver<AndroidElement> driver) {
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}
	@AndroidFindBy(id="com.androidsample.generalstore:id/nameField")
	private WebElement nameField;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioFemale")
	private WebElement femaleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/radioMale")
	private WebElement maleOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/spinnerCountry")
	private WebElement countryOption;
	
	@AndroidFindBy(id="com.androidsample.generalstore:id/btnLetsShop")
	private WebElement letShop_button;
	
	public WebElement nameField() {
		System.out.println("tring to find name field");
		return nameField;
	}
	
	public WebElement femaleOption() {
		System.out.println("tring to find female option");
		return femaleOption;
	}
	
	public WebElement maleOption() {
		System.out.println("tring to find male option");
		return maleOption;
	}
	
	public WebElement countryOption() {
		System.out.println("tring to find country dropdown field");
		return countryOption;
	}
	
	public WebElement letShop_button() {
		System.out.println("tring to find let's Shop button");
		return letShop_button;
	}
}
