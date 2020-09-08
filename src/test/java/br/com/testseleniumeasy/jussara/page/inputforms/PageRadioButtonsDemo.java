package br.com.testseleniumeasy.jussara.page.inputforms;

import br.com.testseleniumeasy.jussara.core.PageBase;
import br.com.testseleniumeasy.jussara.util.Log;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author jussaragranja
 * Class represents the page Radio Buttons Demo from site SeleniumEasy
 */

public class PageRadioButtonsDemo extends PageBase<PageRadioButtonsDemo> {

    @FindBy(css = "input[value = 'Male']")
    private WebElement inputRadioButtonMale;

    @FindBy(css = "input[value = 'Female']")
    private WebElement inputRadioButtonFemale;

    @FindBy(id = "buttoncheck")
    private WebElement buttonGetCheckedValue;

    @FindBy(css = ".radiobutton")
    private WebElement messageRadioButtonChecked;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[1]/input")
    private WebElement radioButtonGroupMale;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label[2]/input")
    private WebElement radioButtonGroupFemale;

    @FindBy(css = "input[value = '0 - 5']")
    private WebElement inputRadioButtonAge0to5;

    @FindBy(css = "input[value = '5 - 15']")
    private WebElement inputRadioButtonAge5to15;

    @FindBy(css = "input[value = '15 - 50']")
    private WebElement inputRadioButtonAge15to50;

    @FindBy(xpath = "//button[text()='Get values']")
    private WebElement buttonGetValuesGroup;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/p[2]")
    private WebElement messageValuesGroupRadioButtons;


    public PageRadioButtonsDemo clickButtonSex(String sex) throws InterruptedException {
        WebElement buttonSex = driver.findElement(By.cssSelector("input[value = '"+sex+"']"));
        Thread.sleep(1000);
        Log.info("Aguardando aparecer radio button "+sex);
        aguardarElementoClicavel(buttonSex);
        click(buttonSex);
        Log.info("Click Button Sex "+sex);
        return this;
    }

    public PageRadioButtonsDemo clickGetCheckedValue() throws InterruptedException {
        Thread.sleep(500);
        waitForElement(buttonGetCheckedValue);
        click(buttonGetCheckedValue);
        Log.info("Click Button Get Checked Value");
        return this;
    }

    public PageRadioButtonsDemo assertClickRadioButton(String sex) throws InterruptedException {
        waitForElement(messageRadioButtonChecked);
        Assert.assertEquals("Radio button '"+sex+"' is checked", messageRadioButtonChecked.getText());
        Log.info("Validação Concluída com sucesso");
        return this;
    }

    public PageRadioButtonsDemo assertClickGetCheckedValue(){
        waitForElement(messageRadioButtonChecked);
        Assert.assertEquals("Radio button is Not checked", messageRadioButtonChecked.getText());
        Log.info("Validação Concluída com sucesso");
        return this;
    }

    public PageRadioButtonsDemo clickSexMaleGroupRadioButtons() throws InterruptedException {
        Thread.sleep(500);
        click(radioButtonGroupMale);

        return this;
    }

    public PageRadioButtonsDemo clickSexFemaleGroupRadioButtons() throws InterruptedException {
        Thread.sleep(500);
        click(radioButtonGroupFemale);

        return this;
    }

    public PageRadioButtonsDemo clickAgeGroupRadioButtons(String age) throws InterruptedException {
        WebElement radioButtonAge = driver.findElement(By.cssSelector("input[value = '"+age+"']"));
        Thread.sleep(1000);
        click(radioButtonAge);

        return this;
    }

    public PageRadioButtonsDemo assertGroupRadioButtons(String sex, String age) throws InterruptedException {
        click(buttonGetValuesGroup);
        waitForElement(messageValuesGroupRadioButtons);
        Assert.assertEquals("Sex : "+sex+"\nAge group: "+age, messageValuesGroupRadioButtons.getText());
        Log.info("Validação Concluída com sucesso");

        return this;
    }

}

