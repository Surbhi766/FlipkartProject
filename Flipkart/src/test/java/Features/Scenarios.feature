Feature: flipkart sceanarios

@GoogleSearch
Scenario: Search items in flipkart
Given User is on google search page 
When Search with Keyword Flipkart
And Print all the search result in console
And Press enter and open the flipkart application
And Close the login popup on the website
And Click on “TV & Appliances” dropdown button
And Navigate to “AirConditioners > Window AC’s” page 
And Click on the “Add To Compare” checkbox of the 2nd 3rd and 6th products displayed.  
And Click on the compare button
And Print Name and price of all three products in the console
And Add all the 3 products into the cart
And Go to the cart add area Pincode and check the availability
And Print message for availabilty and delivery 
And Click the ‘Deliver to’ input box, 
And Add another pin code and check the availability
And Print the message getting displayed for the availability/delivery of the product in the console for the changed Pincode
Then close the browser