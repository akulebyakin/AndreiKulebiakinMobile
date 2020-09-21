# AndreiKulebiakinMobile
Clone project with implemented Appium tests for EPAM Test Automation Training Homework

<h3>Steps to tun tests on EPAM Mobile Cloud</h3>
<b>1.</b> Create a '.env' file in the project directory. Put your Epam Mobile Cloud API Key there. <br>
<i>example of .env content:</i> <br>
emc.api.key=########-####-####-####-############ <br>
<b>2.</b> Configure test.properties file <br> 
<i>path to file:</i> src/test/resources/test.properties <br>
You must specify these properties to run tests on proper devices: <br>
ios.device.udid <br>
android.device.udid <br>
<b>3.</b> Run EPAM Mobile Cloud Web Test for iOS via command line: mvn clean test -PcloudWebiOS <br>
<b>4.</b> Run EPAM Mobile Cloud Native Test for iOS via command line: mvn clean test -PcloudNativeiOS <br>
<b>5.</b> Run EPAM Mobile Cloud Web Test for Android via command line: mvn clean test -PcloudWebAndroid <br>
<b>6.</b> Run EPAM Mobile Cloud Native Test for Android via command line: mvn clean test -PcloudNativeAndroid <br>

<h3>Steps to run local tests</h3>
<b>1.</b> Run Appium and start new session using Android emulator or real device <br>
<b>2.</b> Configure file test.properties if needed <br>
<b>3.</b> Run Native tests via command line: mvn clean test -Pnative <br>
<b>4.</b> Run Web test via command line: mvn clean test -Pweb <br>

<b>Native tests: </b> <br>
<b>1. testIncorrectLoginErrorMessage</b> - additional task. Check error message when we click on SIGN IN without providing correct login and password. <br>

<i>Error message screenshot:</i> <br>
![Error message](http://joxi.ru/EA4wl8qcpXZMB2.png)

Test uses https://ocr.space/ to get text from error screenshot made by WebDriver. <br>

<b>2. testRegisterNewAccount</b> - register a new account and then sign in and check that we are on the BudgetActivity page. <br>

<b>Web test: </b> <br>
<b>1. testGoogleSearch</b> - Go to the Google search page and make a search using keyword ‘EPAM’. Check that there are some relevant results (non-empty list).
