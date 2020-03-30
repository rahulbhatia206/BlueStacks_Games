package com.PageObjects;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import base.TestBase;

public class HomePage {
	
/*
* Author - RahulB 
* Date - 30th March, 2020 
* Method - Perform the main operations
*/
public static void VerifyGames(WebDriver driver) {
	int linksCount = 0;
	String[] link_url = null;

	try {
		WebElement AllGamesDiv = driver.findElement(By.xpath("//h3[text()='Available Games']"));

		Point point = AllGamesDiv.getLocation();

		int x_coordinate = point.getX();

		int y_coordinate = point.getY();

		TestBase.scrollDown(driver, x_coordinate, y_coordinate);

		List<WebElement> allGames = driver.findElements(By.xpath("//li[@class='games-item']//a"));
		linksCount = allGames.size();

		System.out.println("Total no. of Games Available: " + linksCount);
		System.out.println();

		link_url = new String[linksCount];

		for (int i = 0; i < linksCount; i++) {
			link_url[i] = allGames.get(i).getAttribute("href");
		}

		TestBase.waitFor(3);

		// Print the list objects in tabular format.
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.printf("%-5s %-70s %-110s %-5s %-20s", "#", "GameName", "PageURL", "PageStatus", "TournamentCount");
		System.out.println();
		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

		// navigate to each Game Link on the Homepage
		for (int i = 0; i < linksCount; i++) {
			TestBase.waitFor(3);
			driver.navigate().to(link_url[i]);
			TestBase.waitFor(3);
			GamePage.VerifyGameLink(driver, link_url[i]);
		}

		System.out.println("-------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------------");

	} catch (Exception e) {
		System.err.println("!----------- Error in Navigating to Games Link ---------!");
			e.printStackTrace();
		}

	}

}
