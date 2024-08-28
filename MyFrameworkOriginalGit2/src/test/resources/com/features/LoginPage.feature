Feature: OrangeHRM Login page feature

Scenario: Verify Login page Title
Given User is on login page
When user gets the title of the page
Then page title should be "OrangeHRM"	


Scenario: Login to OrangeHRM with valid credentials
Given User is on login page
When user enters username "Admin"
And user enters password "admin123"
And user clicks on login button 
Then OrangeHRM homepage displayed with url "https://opensource-demo.orangehrmlive.com/web/index.php/dashboard/index" 