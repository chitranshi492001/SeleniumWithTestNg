import org.testng.annotations.DataProvider;

public class PropertyFile {
    @DataProvider(name = "LoginDataProvider1")
    public static  Object[][] positiveLoginCredentials()
    {
        Object[][] data={{"standard_user", "secret_sauce"}};
        return data;
    }

        @DataProvider(name = "LoginDataProvider2")
        public static  Object[][] negativeLoginCredentials()
        {
            Object[][] data={{"locked_out_user","secret_sauce"}};
            return data;
    }
}
