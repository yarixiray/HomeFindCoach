import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.firefox.internal.ProfilesIni;

public class BaseTest {
    protected WebDriver driver;
    protected String baseUrl = "http://skillsup.ua/";

    public WebDriver getWebdriver() {
        return driver;
    }

    @Before
    public void setUp() {
        ProfilesIni profile = new ProfilesIni();
        FirefoxProfile myprofile = profile.getProfile("default");
        driver = new FirefoxDriver(myprofile);
        driver.manage().window().maximize();
        driver.get(baseUrl);
    }

    @After
    public void tearDown() {
        driver.quit();
    }
}
