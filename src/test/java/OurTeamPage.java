import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

public class OurTeamPage extends BasePage {

    protected String menuName = "О нас";
    protected String elMenu = "Наша команда";

    @FindBy(partialLinkText = "Александр Галковский")
    private WebElement coach_1;

    @FindBy(partialLinkText = "Михаил Чокан")
    private WebElement coach_2;

    @FindBy(partialLinkText = "Артем Карпов")
    private WebElement coach_3;

    @FindBy(linkText = "О нас")
    private WebElement menu;


    public void verifyCoach(WebElement element, String expected) {
        String coachName = element.getText();
        Assert.assertThat(coachName, CoreMatchers.containsString(expected));
    }


    @Override
    public void open() {
        String checkMenu = menu.getText();
        Assert.assertEquals(menuName, checkMenu);
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        driver.findElement(By.linkText(elMenu)).click();
    }

    public OurTeamPage(WebDriver driver) {
        super(driver);
    }
}
