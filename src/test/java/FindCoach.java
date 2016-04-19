import org.hamcrest.CoreMatchers;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class FindCoach extends BaseTest {
    protected String menuName = "О нас";
    protected String elMenu = "Наша команда";
    protected String coachGal = "Александр Галковский";
    protected String coachChokan = "Михаил Чокан";
    protected String coachSensei = "Артем Карпов";

    @Test
    public void testFindCoach() {
        WebElement menu = driver.findElement(By.linkText(menuName));
        String checkMenu = menu.getText();
        Assert.assertEquals(menuName, checkMenu);
        Actions action = new Actions(driver);
        action.moveToElement(menu).perform();
        driver.findElement(By.linkText(elMenu)).click();
        WebElement coach1 = driver.findElement(By.partialLinkText(coachGal));
        String coach1Name = coach1.getText();
        Assert.assertThat(coach1Name, CoreMatchers.containsString(coachGal));
        WebElement coach2 = driver.findElement(By.partialLinkText(coachChokan));
        String coach2Name = coach2.getText();
        Assert.assertThat(coach2Name, CoreMatchers.containsString(coachChokan));
        try {
            WebElement coach3 = driver.findElement(By.partialLinkText(coachSensei));
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled: " + e);
        }

    }

}
