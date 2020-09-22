package practise.AppiumFramwork;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.ServerSocket;
import java.net.URL;
import java.util.Properties;

import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.service.local.AppiumDriverLocalService;

public class base {
	public static Properties prop;
	public static AndroidDriver<AndroidElement> driver;
	public AppiumDriverLocalService service;

	public AppiumDriverLocalService startServer() {
		boolean flag=checkIfServerIsRunning(4723);
		
		if(!flag) {
		service = AppiumDriverLocalService.buildDefaultService();
		service.start();
		}
		return service;
	}

	public static boolean checkIfServerIsRunning(int port) {
		boolean isServerRunning = false;
		ServerSocket serverSocket;
		try {
			serverSocket = new ServerSocket(port);
			serverSocket.close();
		} catch (IOException e) {
			// if code comes here it means that port is in use
			isServerRunning = true;
		} finally {
			serverSocket = null;
		}
		return isServerRunning;

	}
	
	public static void startEmulator() throws IOException, InterruptedException {
		// C:\Users\abc\git\General-Store-app-automation\AppiumFramwork\src\main\java\resouces\startEmulator.bat
		Runtime.getRuntime().exec(System.getProperty("user.dir") +"\\src\\main\\java\\resouces\\startEmulator.bat");
		Thread.sleep(6000);
	}

	public static AndroidDriver<AndroidElement> Capabilities(String appName) throws IOException, InterruptedException {
		// TODO Auto-generated method stub
		prop = new Properties();
		FileInputStream fis = new FileInputStream(
				System.getProperty("user.dir") + "\\src\\main\\java\\practise\\AppiumFramwork\\global.properties");
		prop.load(fis);
		String device = (String) prop.get("device");
		if(device.contains("Pixel")) {
			startEmulator();
		}
		
		File appDir = new File("src");
		File app = new File(appDir, prop.getProperty("AppName"));
		DesiredCapabilities cap = new DesiredCapabilities();
		// cap.setCapability(MobileCapabilityType.APP, app);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, device);
		// cap.setCapability(MobileCapabilityType.AUTOMATION_NAME, "uiautomator");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		cap.setCapability(MobileCapabilityType.NEW_COMMAND_TIMEOUT, 14);
		AndroidDriver<AndroidElement> driver = new AndroidDriver<>(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		return driver;
	}

}
