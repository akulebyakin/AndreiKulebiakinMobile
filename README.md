# AndreiKulebiakinMobile
Clone project with implemented Appium tests for EPAM Test Automation Training Homework

<b>Steps to run tests</b>
1. run Appium and start new session using Android emulator or real device
2. configure file test.properties if needed
3. run Native tests via command line: mvn clean test -Pnative
4. run Web test via command line: mvn clean test -Pweb

<b>Native tests: </b>
1. <b>testIncorrectLoginErrorMessage</b> - additional task. Check error message when we click on SIGN IN without providing correct login and password.<br>

<i>Error message screenshot:</i><br>
![Error message](http://joxi.ru/EA4wl8qcpXZMB2.png)

Test uses https://ocr.space/ to get text from error screenshot made by WebDriver.

2. <b>testRegisterNewAccount</b> - register a new account and then sign in and check that we are on the BudgetActivity page.

<b>Web test: </b>
1. <b>testGoogleSearch</b> - Go to the Google search page and make a search using keyword ‘EPAM’. Check that there are some relevant results (non-empty list).
