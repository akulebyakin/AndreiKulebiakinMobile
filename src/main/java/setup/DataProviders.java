package setup;

import org.testng.annotations.DataProvider;

public class DataProviders {

    @DataProvider
    public static Object[][] getBudgetActivityName() {
        return new Object[][]{
                {"BudgetActivity", "Budget"}
        };
    }

    @DataProvider
    public static Object[][] getGoogleSearchText() {
        return new Object[][]{
                {"EPAM"}
        };
    }

    @DataProvider
    public static Object[][] getIncorrectEmailOrPasswordText() {
        return new Object[][]{
                {"Incorrect email or password"}
        };
    }
}
