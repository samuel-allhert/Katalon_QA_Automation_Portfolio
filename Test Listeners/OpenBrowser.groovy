import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject

import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testobject.TestObject as TestObject

import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile

import internal.GlobalVariable as GlobalVariable

import com.kms.katalon.core.annotation.BeforeTestCase
import com.kms.katalon.core.annotation.BeforeTestSuite
import com.kms.katalon.core.annotation.AfterTestCase
import com.kms.katalon.core.annotation.AfterTestSuite
import com.kms.katalon.core.context.TestCaseContext
import com.kms.katalon.core.context.TestSuiteContext
import com.kms.katalon.core.webui.driver.DriverFactory

import org.openqa.selenium.chrome.ChromeDriver
import org.openqa.selenium.chrome.ChromeOptions

class OpenBrowser {
	
	@BeforeTestCase
	def OpenBrowserAndMaximize() {
		
		try {
            // Try to use existing browser
            WebUI.getWindowIndex()
        } catch (Exception e) {

            ChromeOptions options = new ChromeOptions()

            options.addArguments("--disable-save-password-bubble")
            options.addArguments("--disable-password-manager-reauthentication")
            options.addArguments("--disable-notifications")
            options.addArguments("--incognito")

            options.setExperimentalOption("prefs", [
                "credentials_enable_service": false,
                "profile.password_manager_enabled": false
            ])

            DriverFactory.changeWebDriver(new ChromeDriver(options))

            WebUI.navigateToUrl("https://katalon-demo-cura.herokuapp.com/")
            WebUI.maximizeWindow()
        }

	}
}
