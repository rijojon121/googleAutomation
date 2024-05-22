package demo;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class selenuim {
    
    public static void main(String[] args) throws InterruptedException {
        
        WebDriver driver = new ChromeDriver();

        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

        driver.get("https://www.google.ca/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//*[@title='Search']")).sendKeys("selenium");
       // driver.findElement(By.xpath("(//input[@value='Google Search' and @role='button'])[2]")).click();
        Thread.sleep(3000);
        
        List <WebElement>  list =  driver.findElements(By.xpath("//ul[@role='listbox']//li//div[@role='option']"));
        
        System.out.println(list.size());
        
        for (int i=0;i<list.size();i++){
            System.out.println(list.get(i).getText());
            if(list.get(i).getText().equals("Selenium")){
                list.get(i).click();;
                break;
            }
        }

        /* if you use capital 'S' instead of small 's' it will not find the 'i' it with print out the whole list like 

        10
selenium
selenium benefits
selenium rich foods
selenium webdriver
selenium ide
selenium element
selenium sulfide
selenium supplements
selenium foods
selenium sulfide shampoo

other wise its only 

10
selenium
        */ 
        
        Thread.sleep(3000);
        driver.quit();

    }
}
