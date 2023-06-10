package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.testng.Assert;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;
import airportTDD.pageComponents.SearchFlight;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;


public class ErrorMessageTest extends BaseTest {
	
	@Test(dataProvider="errorTestData")
	public void User_selects_more_than_9_Passanger(String journeyType,String departCity,String arrivalCity,String month,String dateMonth,String adults,String childs,String errorMesg) throws InterruptedException, IOException {

		travelHomePage.setBookingStrategy(travelHomePage.multiTrip());
		travelHomePage.selectOption();
		travelHomePage.selectCity(departCity, arrivalCity);
		travelHomePage.departureDate();
		travelHomePage.journeyDate(month, Integer.parseInt(dateMonth));
		travelHomePage.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs));
		String alertMesg=travelHomePage.getErrorMesg();
		Assert.assertEquals(alertMesg, errorMesg);
		System.out.println(alertMesg);
	}
	
	
	

	@DataProvider(name="errorTestData")
	 
	 public Object[][] getData() throws IOException{
    Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//airportTDD//flightBookingTDD//testdata//TestData.xlsx","ErrorTestData");	 
	 return d;
	 }
	
}
