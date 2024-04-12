import org.testng.annotations.DataProvider;

public class TestDataProvider {
    @DataProvider(name ="NegativeLoginTestData")
    public static Object[][] getDataFromDataProvider(){
        return new Object[][]{
                {"invalidEmail","invalid"},
                {"k.potsina@testpro.io","testproA57*"},
                {"kseniya.potsina@testpro.io","invalid"},
                {" ", " "}
        };
    }
}
