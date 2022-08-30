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
import com.kms.katalon.core.testobject.ConditionType
import com.kms.katalon.core.testobject.HttpBodyContent
import com.kms.katalon.core.testobject.ObjectRepository as ObjectRepository
import com.kms.katalon.core.testobject.TestObject as TestObject
import com.kms.katalon.core.testobject.TestObjectProperty
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WSBuiltInKeywords
import com.kms.katalon.core.webservice.keyword.WSBuiltInKeywords as WS
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUiBuiltInKeywords
import com.kms.katalon.core.webui.keyword.WebUiBuiltInKeywords as WebUI
import internal.GlobalVariable as GlobalVariable
import com.kms.katalon.core.testobject.ResponseObject
import com.kms.katalon.core.testobject.RequestObject
import com.kms.katalon.core.testobject.impl.HttpTextBodyContent
import java.util.List
import java.util.concurrent.locks.Condition
import java.util.ArrayList
import com.kms.katalon.core.util.KeywordUtil
//DELETE object
def request = (RequestObject)findTestObject('DELETE')

try{
	//Get URL and replace it with certain element want to update
	def url = request.getRestUrl()
	url = url.replace('{postid}','5')
	request.setRestUrl(url)
}
catch(Exception ex){
	//If error catch Exception and print detail message why it cause eroor
	println (ex.detailMessage)
}
//Make DELETE requestf
def response = WS.sendRequest(request)
//Verify HTTP Status Code after sent
WS.verifyResponseStatusCode(response, 200) ? KeywordUtil.markPassed("Verify successful") : KeywordUtil.markFailedAndStop("Verify fail")

//Verify data has been delete or not
CustomKeywords.'Verify.verifyElement'(5, "An Quoc Changed", "An Quoc Changed")? KeywordUtil.markFailedAndStop("Delete fail") : KeywordUtil.markPassed("Delete successful")


////Verify response with GET
//def response = (RequestObject)findTestObject('GET')

//List<TestObjectProperty> params = new ArrayList();
//params.add(new TestObjectProperty("id", ConditionType.EQUALS, "21"))
//response.setRestParameters(params)

////Make GET Request
//def result = WS.sendRequest(response)
////Verify title from response
//WS.verifyResponseStatusCode(result, 200)



