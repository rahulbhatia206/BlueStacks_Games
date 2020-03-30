package com.PageObjects;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.openqa.selenium.WebDriver;

import base.TestBase;

public class GamePage {

static String GameNameEle = "//h1[@class='heading']";
static String TournamentsCount = "//span[@class='count-tournaments']";
static int SerialNo = 1;

/*
 * Author - RahulB 
 * Date - 30th March, 2020 
 * Method - Check the particular game page and print details
 */
public static void VerifyGameLink(WebDriver driver, String LinkURL) throws Exception {

	int statusCode = 0;
	String CountTour = null;
	String gameName = null;
	try {
		HttpClient client = HttpClientBuilder.create().build();
		HttpGet request = new HttpGet(LinkURL);
		HttpResponse response = client.execute(request);

		gameName = TestBase.WaitTimePresence(driver, GameNameEle).getText();
		CountTour = TestBase.WaitTimePresence(driver, TournamentsCount).getText();
		statusCode = response.getStatusLine().getStatusCode();

		System.out.format("%-5s %-70s %-110s %-15s %-40s", SerialNo, gameName, LinkURL, statusCode, CountTour);
		System.out.println();
		}
	
		catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		SerialNo++;
	}
}
