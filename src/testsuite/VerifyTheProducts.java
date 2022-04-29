package testsuite;

import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.Utility;

import java.util.List;

public class VerifyTheProducts extends Utility {

    String baseUrl="https://www.amazon.co.uk/";

    @Before
    public void setup(){ openBrowser(baseUrl);}

    @Test
    public void verifyTheProducts(){
        // Accept cookies
        driver.findElement(By.id("sp-cc-accept")).click();

        // Type in searchbar " Dell Laptop" and click on search button
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Dell Laptop");
        clickOnElement(By.id("nav-search-submit-button"));

        // Click the checkbox against brand "Dell" on the left side.
        driver.findElement(By.xpath("//body[1]/div[1]/div[2]/div[1]/div[2]/div[1]/div[3]/span[1]/div[1]/div[1]/div[1]/div[4]/ul[1]/li[1]/span[1]/a[1]/div[1]/label[1]/i[1]")).click();

        // List of Images is constant changing (Between 31 & 35) depends
        int imageList=driver.findElements(By.className("s-image")).size();
        System.out.println(imageList);

        // List of Products (30)
        int productList=driver.findElements(By.tagName("h2")).size();
        System.out.println(productList);

        // List of product name (30)
        List<WebElement> allLinks = driver.findElements(By.tagName("h2"));
        for (WebElement link: allLinks)
            System.out.println(link.getText());

        // Close the Window
        driver.quit();

    }



}
