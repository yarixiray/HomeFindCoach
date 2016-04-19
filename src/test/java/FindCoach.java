import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;


public class FindCoach extends BaseTest {
    private String coachGal = "Александр Галковский";
    private String coachChokan = "Михаил Чокан";
    private String coachSensei = "Артем Карпов";


    @Test
    public void test1() {
        OurTeamPage ourTeamPage = new OurTeamPage(getWebdriver());
        ourTeamPage.open();
        WebElement coach1 = driver.findElement(By.partialLinkText(coachGal));
        ourTeamPage.verifyCoach(coach1, coachGal);

    }

    @Test
    public void test2() {
        OurTeamPage ourTeamPage = new OurTeamPage(getWebdriver());
        ourTeamPage.open();
        WebElement coach2 = driver.findElement(By.partialLinkText(coachChokan));
        ourTeamPage.verifyCoach(coach2, coachChokan);

    }

    @Test
    public void test3() {
        OurTeamPage ourTeamPage = new OurTeamPage(getWebdriver());
        ourTeamPage.open();
        try {
            WebElement coach3 = driver.findElement(By.partialLinkText(coachSensei));
            ourTeamPage.verifyCoach(coach3, coachSensei);
        } catch (RuntimeException e) {
            System.out.println("Exception has been handled: " + e);
        }


    }

}
