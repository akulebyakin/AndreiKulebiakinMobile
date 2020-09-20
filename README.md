# AndreiKulebiakinMobile
Clone project with implemented Appium tests for EPAM Test Automation Training Homework

<h3>Steps to tun tests on EPAM Mobile Cloud</h3>
1. Create a '.env' file in the project directory. Put your Epam Mobile API Key there. <br>
<i>example of .env content:</i><br>
emc.api.key=########-####-####-####-############<br>
2. Configure test.properties file <br> 
<i>path to file:</i> src/test/resources/test.properties<br>
3. Run EPAM Mobile Cloud Web Test for iOS via command line: mvn clean test -PcloudWebiOS<br>
4. Run EPAM Mobile Cloud Native Test for iOS via command line: mvn clean test -PcloudNativeiOS<br>
5. Run EPAM Mobile Cloud Web Test for Android via command line: mvn clean test -PcloudWebAndroid<br>
6. Run EPAM Mobile Cloud Native Test for Android via command line: mvn clean test -PcloudNativeAndroid<br>

<h3>Steps to run local tests</h3>
1. Run Appium and start new session using Android emulator or real device<br>
2. Configure file test.properties if needed<br>
3. Run Native tests via command line: mvn clean test -Pnative<br>
4. Run Web test via command line: mvn clean test -Pweb<br>

<b>Native tests: </b>
1. <b>testIncorrectLoginErrorMessage</b> - additional task. Check error message when we click on SIGN IN without providing correct login and password.<br>

<i>Error message screenshot:</i><br>
![Error message](http://joxi.ru/EA4wl8qcpXZMB2.png)

Test uses https://ocr.space/ to get text from error screenshot made by WebDriver.

2. <b>testRegisterNewAccount</b> - register a new account and then sign in and check that we are on the BudgetActivity page.

<b>Web test: </b>
1. <b>testGoogleSearch</b> - Go to the Google search page and make a search using keyword ‘EPAM’. Check that there are some relevant results (non-empty list).
