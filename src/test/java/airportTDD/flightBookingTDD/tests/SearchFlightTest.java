package airportTDD.flightBookingTDD.tests;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import airportTDD.flightBookingTDD.testcomponent.BaseTest;
import airportTDD.pageComponents.SearchFlight;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

 
public class SearchFlightTest extends BaseTest {
 
    @Test(dataProvider="MulitiCityOneway")
	public void User_clicks_on_multicity_option(String journeyType,String departCity,String arrivalCity, String month,String dateMonth,String adults,String childs,String infants,String curr) throws InterruptedException {
    	searchflight=travelHomePage.searchFlight();
    	searchflight.selectOption(journeyType);
        searchflight.selectCity(departCity, arrivalCity);
        searchflight.departureDate(journeyType);
        searchflight.selectJourneyDate(month, Integer.parseInt(dateMonth));
        searchflight.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs), Integer.parseInt(infants));
/*        if(journeyType.equalsIgnoreCase("roundTrip")) {
        	User_clicks_on_roundtrip_option(rmonth,rdateMonth);
        }*/
        searchflight.selectCurrency(curr);
		searchflight.search();
	}
    
    @Test(dataProvider="RoundTrip")
    public void User_clicks_on_roundtrip_option(String journeyType,String departCity,String arrivalCity, String month,String dateMonth,String rmonth,String rdateMonth,String adults,String childs,String infants,String curr) throws InterruptedException {
    	searchflight=travelHomePage.searchFlight();
    	searchflight.selectOption(journeyType);
        searchflight.selectCity(departCity, arrivalCity);
        searchflight.departureDate(journeyType);
        searchflight.selectJourneyDate(month, Integer.parseInt(dateMonth));
        searchflight.returnDate();
	    searchflight.selectJourneyDate(rmonth, Integer.parseInt(rdateMonth));
        searchflight.selectPassenger(Integer.parseInt(adults), Integer.parseInt(childs), Integer.parseInt(infants));	
        searchflight.selectCurrency(curr);
		searchflight.search();

}
    
    @DataProvider(name="MulitiCityOneway")
	 
	 public Object[][] getMulitiCityOnewayData() throws IOException{
   Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//data//TestData.xlsx","MulitiCityOneway");	 
	 return d;
	 }
    
    @DataProvider(name="RoundTrip")
	 
	 public Object[][] getRoundTripData() throws IOException{
  Object[][] d=getExcelData(System.getProperty("user.dir") +"//src//test//java//data//TestData.xlsx","RoundTrip");	 
	 return d;
	 }

}
