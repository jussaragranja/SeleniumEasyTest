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

    @FindBy(css = "input[value = 'Check All']")
    private WebElement buttonCheckAll;

    @FindBy(css = "input[value = 'Uncheck All']")
    private WebElement buttonUncheckAll;

    public PageCheckboxDemo clickSingleCheckBoxDemo() throws InterruptedException {
        Thread.sleep(1000);
        click(inputCheckBoxSingle);

        return this;
    }

    public PageCheckboxDemo assertClickCheckBoxSingle() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Success - Check box is checked", messageCheckedSingle.getText());

        return this;
    }

    public PageCheckboxDemo clickButtonCheckAll() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonCheckAll);

        return this;
    }

    public PageCheckboxDemo clickButtonUncheckAll() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonUncheckAll);

        return this;
    }

    public PageCheckboxDemo clickOption1() throws InterruptedException {
        Thread.sleep(1000);
        click(inputCheckBoxMultipleOption1);

        return this;
    }

    public PageCheckboxDemo assertClickCheckAll() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Uncheck All", buttonUncheckAll.getAttribute("value"));

        return this;
    }

    public PageCheckboxDemo assertClickUncheckAll() throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("Check All", buttonCheckAll.getAttribute("value"));

        return this;
    }

}
