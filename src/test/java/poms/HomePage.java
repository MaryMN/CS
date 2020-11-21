package poms;

import base.Base;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Map;

public class HomePage extends Base {

    private final By searchField = By.xpath("//div[@class = 'header-bot']//input[@type='search']");
    private final By searchButton = By.xpath("//div[@class = 'header-bot']//input[@type='submit']");
    private final By registrationForm = By.xpath("//*[@id='myModal2']/div/div");
    private final By signUpButton = By.xpath("//a[contains(text(), 'Sign Up')]");
    private final By regNameField = By.xpath("//*[@id='myModal2']//input[@name='Name']");
    private final By regEmailField = By.xpath("//*[@id='myModal2']//input[@name='Email']");
    private final By regPwdField = By.xpath("//*[@id='myModal2']//input[@name='password']");
    private final By regConfPwdField = By.xpath("//*[@id='myModal2']//input[@name='Confirm Password']");
    private final By regSignUpButton = By.xpath("//*[@id='myModal2']//input[@type='submit']");
    private final By authenticationForm = By.xpath("//*[@id='myModal']/div/div");
    private final By signInButton = By.xpath("//a[contains(text(), 'Sign In')]");
    private final By signInUsernameField = By.xpath("//*[@id='myModal']//input[@name='Name']");
    private final By signInEmailField = By.xpath("//*[@id='myModal']//input[@name='Email']");
    private final By logInBtn = By.xpath("//*[@id='myModal']//input[@type='submit']");
    private final By item = By.xpath("(//div[@class ='col-md-3 product-men' ])[1]");
    private final By addToCartButton = By.xpath("//input[@value='Add to cart'][1]");
    private final By cart = By.xpath("//*[@id='PPMiniCart']/form/ul/li");
    private final By itemAddedToCart = By.xpath("//*[@id='PPMiniCart']/form");
    private final By quickViewButton = By.xpath("//a[contains(text(),'Quick View')][1]");
    private final By itemName = By.xpath("//a[contains(text(),'Formal Blue Shirt')]");
    private final By returnedItem = By.xpath("//span[@class='item_price'][1]/parent::p/preceding-sibling::h3");


    public HomePage(WebDriver driver) {
        super(driver);
    }

    public void search(String element) {
        WebElement clickOnSearchField = driver.findElement(searchField);
        WebElement typeElementsOnSearchField = driver.findElement(searchField);
        WebElement clickOnSearchButton = driver.findElement(searchButton);


        clickOnSearchField.click();
        typeElementsOnSearchField.sendKeys(element);
        clickOnSearchButton.submit();
    }


    public void clickOnSignUpBtn() {
        WebElement clickOnSignUpBtn = driver.findElement(signUpButton);
        clickOnSignUpBtn.click();
    }

    public void registrationForm() {
        WebElement findRegistrationForm = driver.findElement(registrationForm);
        findRegistrationForm.isDisplayed();
    }

    public void registrationFillForm(Map<String, String> map) {
        String name = map.get("username");
        String email = map.get("email");
        String password = map.get("password");
        String confirm_password = map.get("confirm_password");

        WebElement fillRegNameField = driver.findElement(regNameField);
        WebElement fillRegEmailField = driver.findElement(regEmailField);
        WebElement fillRegPwdField = driver.findElement(regPwdField);
        WebElement fillRegConfPwdField = driver.findElement(regConfPwdField);

        WebElement RegSignUpButton = driver.findElement(regSignUpButton);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(fillRegNameField));


        if (!"n/a".equals(name)) {
            fillRegNameField.clear();
            fillRegNameField.sendKeys(name);
        }
        if (!"n/a".equals(email)) {
            fillRegEmailField.clear();
            fillRegEmailField.sendKeys(email);
        }
        if (!"n/a".equals(password)) {
            fillRegPwdField.clear();
            fillRegPwdField.sendKeys(password);
        }
        if (!"n/a".equals(confirm_password)) {
            fillRegConfPwdField.clear();
            fillRegConfPwdField.sendKeys(confirm_password);
        }
//        RegSignUpButton.submit();

    }

    public void submitRegForm() {
        WebElement fillRegSignUpButton = driver.findElement(regSignUpButton);
        fillRegSignUpButton.submit();
    }


    public void clickOnLogInBtn() {
        WebElement clickOnSignInBtn = driver.findElement(signInButton);
        clickOnSignInBtn.click();
    }

    public void authenticationForm() {
        WebElement findAuthenticationForm = driver.findElement(authenticationForm);
        findAuthenticationForm.isDisplayed();
    }

    public void authenticationFillForm(Map<String, String> map) {
        String username = map.get("username");
        String email = map.get("email");

        WebElement fillSignInUsernameField = driver.findElement(signInUsernameField);
        WebElement fillSignInEmailField = driver.findElement(signInEmailField);

        WebElement logInBtnForm = driver.findElement(logInBtn);

        WebDriverWait wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOf(fillSignInUsernameField));


        if (!"n/a".equals(username)) {
            fillSignInUsernameField.clear();
            fillSignInUsernameField.sendKeys(username);
        }
        if (!"n/a".equals(email)) {
            fillSignInEmailField.clear();
            fillSignInEmailField.sendKeys(email);
        }

//        logInBtnForm.submit();

    }

    public void submitLogInForm() {
        WebElement logInButton = driver.findElement(logInBtn);
        logInButton.submit();
    }


    public void chooseItem() {
        WebElement findItem = driver.findElement(item);
        scrollToElement(findItem);
        Actions action = new Actions(driver);
        action.moveToElement(findItem).perform();
        findItem.isDisplayed();
    }

    public void clickOnAddToCartBtn() {
        WebElement clickOnAddToCartButton = driver.findElement(addToCartButton);
        clickOnAddToCartButton.click();
    }

    public void cartAppears() {
        WebElement cartElement = driver.findElement(cart);
        cartElement.isDisplayed();
    }

    public void itemAddedToCart() {
        WebElement itemOnCart = driver.findElement(itemAddedToCart);
        itemOnCart.isDisplayed();
//        WebElement quickViewBtn = driver.findElement(quickViewButton);
        //quickViewBtn.isDisplayed();
//        quickViewBtn.click();
    }

    //    public void displayQuickViewBtn(){
//        WebElement quickViewBtn = driver.findElement(quickViewButton);
//        quickViewBtn.isDisplayed();
//        //quickViewBtn.click();
//    }
    public void clickQuickViewBtn() {
        WebElement quickViewBtn = driver.findElement(quickViewButton);
        quickViewBtn.isDisplayed();
        quickViewBtn.click();
    }

    public String getItemName() {
        WebElement itemNameGet = driver.findElement(itemName);
        return itemNameGet.getText();
    }

    public String getReturnedItem() {
        WebElement returnedItemName = driver.findElement(returnedItem);
        return returnedItemName.getText();
    }

    public void scrollToElement(WebElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
    }

}


