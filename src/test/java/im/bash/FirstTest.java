package im.bash;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


public class FirstTest extends WebDriverSettings {

    @Test
    public void firstTest() {
        driver.get("https://bash.im/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Цитатник Рунета"));
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector("[href=\"/index/3308\"]")));
        String pageFirst = driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/input")).getAttribute("value");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[3]/a[1]")).click();
        String pageSecond = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/input")).getAttribute("value");
        driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/a[4]")).click();
        String pageThird = driver.findElement(By.xpath("/html/body/div[1]/main/div[2]/input")).getAttribute("value");

        try {
            int pageFirstInt = Integer.parseInt(pageFirst.trim());
            int pageSecondInt = Integer.parseInt(pageSecond.trim());
            int pageThirdInt = Integer.parseInt(pageThird.trim());
            Assert.assertTrue(pageFirstInt == pageSecondInt + 1);
            Assert.assertTrue(pageThirdInt == 1);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }

    }

    @Test
    public void secondTest() {
        driver.get("https://bash.im/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Цитатник Рунета"));
        String quantityLikesFirst = driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[3]")).getText();
        driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[4]")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String quantityLikesSecond = driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[3]")).getText();

        try {
            int quantityLikesFirstInt = Integer.parseInt(quantityLikesFirst.trim());
            int quantityLikesSecondInt = Integer.parseInt(quantityLikesSecond.trim());

            Assert.assertTrue(quantityLikesSecondInt == quantityLikesFirstInt + 1);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


    }

    @Test
    public void thirdTest() {
        driver.get("https://bash.im/");
        String title = driver.getTitle();
        Assert.assertTrue(title.equals("Цитатник Рунета"));
        String quantityLikesFirst = driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[3]")).getText();
        driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[2]")).click();

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        String quantityLikesSecond = driver.findElement(By.xpath("/html/body/div[1]/main/section/article[1]/div/footer/div[3]")).getText();
        System.out.println(quantityLikesFirst + " " + quantityLikesSecond);


        try {
            int quantityLikesFirstInt = Integer.parseInt(quantityLikesFirst.trim());
            int quantityLikesSecondInt = Integer.parseInt(quantityLikesSecond.trim());

            Assert.assertTrue(quantityLikesSecondInt == quantityLikesFirstInt - 1);

        } catch (NumberFormatException nfe) {
            System.out.println("NumberFormatException: " + nfe.getMessage());
        }


    }
}


