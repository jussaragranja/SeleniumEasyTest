package br.com.testseleniumeasy.jussara.page.inputforms;

import br.com.testseleniumeasy.jussara.core.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author jussaragranja
 * Class represents the page Checkbox Demo from site SeleniumEasy
 */

public class PageCheckboxDemo extends PageBase<PageCheckboxDemo> {

    @FindBy(id = "isAgeSelected")
    private WebElement inputCheckBoxSingle;

    @FindBy(id = "txtAge")
    private WebElement messageCheckedSingle;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[1]/label/input")
    private WebElement inputCheckBoxMultipleOption1;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[2]/label/input")
    private WebElement inputCheckBoxMultipleOption2;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[3]/label/input")
    private WebElement inputCheckBoxMultipleOption3;

    @FindBy(xpath = "//*[@id=\"easycont\"]/div/div[2]/div[2]/div[2]/div[4]/label/input")
    private WebElement inputCheckBoxMultipleOption4;

    @FindBy(id = "check1")
    private WebElement buttonCheckUncheckAll;

    public PageCheckboxDemo clickSingleCheckBoxDemo() throws InterruptedException {
        Thread.sleep(500);
        click(inputCheckBoxSingle);

        return this;
    }

    public PageCheckboxDemo assertClickCheckBoxSingle() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("Success - Check box is checked", messageCheckedSingle.getText());

        return this;
    }

    public PageCheckboxDemo clickCheckUncheckAll() throws InterruptedException {
        Thread.sleep(500);
        click(buttonCheckUncheckAll);

        return this;
    }

    public PageCheckboxDemo clickOption1(){
        aguardarElementoClicavel(inputCheckBoxMultipleOption1);
        click(inputCheckBoxMultipleOption1);

        return this;
    }

    public PageCheckboxDemo assertClickCheckAll() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("Uncheck All", buttonCheckUncheckAll.getAttribute("value"));

        return this;
    }

    public PageCheckboxDemo assertClickUncheckAll() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("Check All", buttonCheckUncheckAll.getAttribute("value"));

        return this;
    }

}
