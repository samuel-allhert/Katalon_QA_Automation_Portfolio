import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testng.keyword.TestNGBuiltinKeywords as TestNGKW
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import internal.GlobalVariable as GlobalVariable
import org.openqa.selenium.Keys as Keys

WebUI.callTestCase(findTestCase('Successful Login'), [:], FailureHandling.STOP_ON_FAILURE)

int randomNum = new Random().nextInt(3) + 1

println('Random Facility = ' + randomNum)

WebUI.click(findTestObject('Appointment Page/Dropdown - Facility'))

WebUI.click(findTestObject('Appointment Page/Dropdown Option - Facility', [('index') : randomNum]))

WebUI.click(findTestObject('Home Page/Checkbox - Hospital readmission'))

randomNum = (new Random().nextInt(3) + 1)

println('Random Healthcare = ' + randomNum)

WebUI.click(findTestObject('Appointment Page/Radio - Healthcare Program', [('index') : randomNum]))

WebUI.click(findTestObject('Appointment Page/Button - Open Calendar'))

WebUI.click(findTestObject('Appointment Page/Button - Date'))

WebUI.sendKeys(findTestObject('Appointment Page/Textfield - Comment'), Comment)

WebUI.click(findTestObject('Appointment Page/Button - Book Appointment'))

WebUI.verifyElementPresent(findTestObject('Appointment Page/Text - Please be informed---'), 10)

