#Author: rahulbhatia206@gmail.com
#Date: 30th March, 2020

Feature: Game Verify
  This feature will be used to verify Games

Scenario Outline: Verify Game Details
 Given User Opens the "<URL>" in "<Browser>" 
 When User Navigates to Games Tiles and Verify Games
 Then Close Browser

Examples: 
 					| URL 										| Browser |
          | https://www.game.tv/   	| Chrome  |
          
  
