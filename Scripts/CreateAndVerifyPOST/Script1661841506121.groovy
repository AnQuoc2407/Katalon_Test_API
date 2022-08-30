import static com.kms.katalon.core.checkpoint.CheckpointFactory.findCheckpoint
import static com.kms.katalon.core.testcase.TestCaseFactory.findTestCase
import static com.kms.katalon.core.testdata.TestDataFactory.findTestData
import static com.kms.katalon.core.testobject.ObjectRepository.findTestObject
import com.kms.katalon.core.checkpoint.Checkpoint as Checkpoint
import com.kms.katalon.core.checkpoint.CheckpointFactory as CheckpointFactory
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as MobileBuiltInKeywords
import com.kms.katalon.core.mobile.keyword.MobileBuiltInKeywords as Mobile
import com.kms.katalon.core.model.FailureHandling as FailureHandling
import com.kms.katalon.core.testcase.TestCase as TestCase
import com.kms.katalon.core.testcase.TestCaseFactory as TestCaseFactory
import com.kms.katalon.core.testdata.TestData as TestData
import com.kms.katalon.core.testdata.TestDataFactory as TestDataFactory
import com.kms.katalon.core.testobject.ConditionType as ConditionType
import com.kms.katalon.core.testobject.HttpBodyContent as HttpBodyContent
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty as TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject as ResponseObject
import com.kms.katalon.core.testobject.RequestObject as RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent as HttpTextBodyContent
import java.util.List as List
import java.util.concurrent.locks.Condition as Condition
import java.util.ArrayList as ArrayList
import com.kms.katalon.core.cucumber.keyword.CucumberBuiltinKeywords as CucumberKW
import com.kms.katalon.core.windows.keyword.WindowsBuiltinKeywords as Windows
import static com.kms.katalon.core.testobject.ObjectRepository.findWindowsObject
import groovy.json.JsonSlurper
import com.kms.katalon.core.util.KeywordUtil
//POST object
def request = (RequestObject)findTestObject('POST')

//Create string body request
String body = '{ "id": 5, "title": "An Quoc", "author": "An Quoc"}'

try {
	//Set text, charset, contentType to BodyContent
	request.setBodyContent(new HttpTextBodyContent(body, "UTF-8", "application/json"))
}catch(Exception ex) {
	//If error catch Exception and print detail message why it cause eroor
	println(ex.detailMessage)
}

//Make POST request
WS.sendRequest(request)

//Verify response with GET
def response = (RequestObject)findTestObject('GET')

//List<TestObjectProperty> params = new ArrayList();
//params.add(new TestObjectProperty("id", ConditionType.EQUALS, "1"))
//
//params.add(new TestObjectProperty("title", ConditionType.EQUALS, "An Quoc"))
//
//params.add(new TestObjectProperty("author", ConditionType.EQUALS, "An Quoc"))
//
//response.setRestParameters(params)


//Make GET Request
def result = WS.sendRequest(response)

//Count how many element in body content
count = WS.getElementsCount(result, 'posts') - 1

println(count)
//Verify title from response
WS.verifyElementPropertyValue(result, '['+count+'].title', 'An Quoc') ? KeywordUtil.markPassed("Verify successful") : KeywordUtil.markFailedAndStop("Verify fail")

//Verify data is in db or not
CustomKeywords.'Verify.verifyElement'(5, "An Quoc", "An Quoc")? KeywordUtil.markPassed("Verify successful") : KeywordUtil.markFailedAndStop("Verify fail")



