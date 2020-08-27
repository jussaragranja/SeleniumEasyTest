package br.com.testseleniumeasy.jussara.page.inputforms;

import br.com.testseleniumeasy.jussara.core.PageBase;
import br.com.testseleniumeasy.jussara.util.Constants;
import br.com.testseleniumeasy.jussara.util.Log;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

/**
 * @author jussaragranja
 * Class represents the page Select Dropdown List from site SeleniumEasy
 */

public class PageSelectDropdownList extends PageBase<PageSelectDropdownList> {

    @FindBy(id = "select-demo")
    private WebElement selectDay;

    @FindBy(css = ".selected-value")
    private WebElement messageSelectedValue;

    @FindBy(id = "multi-select")
    private WebElement multiSelectListDemo;

    @FindBy(id = "printMe")
    private WebElement buttonFirstSelected;

    @FindBy(id = "printAll")
    private WebElement buttonGetAllSelected;

    @FindBy(css = ".getall-selected")
    private WebElement messageOptionsSelected;


    public PageSelectDropdownList selectADayListDemo(String day){
        selectElementByVisibleText(selectDay, day);

        return this;
    }

    public PageSelectDropdownList assertDaySelected(String day){
        Assert.assertEquals("Day selected :- "+day, messageSelectedValue.getText());
        Log.info("Validação Concluída com sucesso");

        return this;
    }

    public PageSelectDropdownList selectMultiListDemo(String state){
         selectElementByVisibleText(multiSelectListDemo, state);

        return this;
    }

    public PageSelectDropdownList clickButtonGetAllSelected(){
        click(buttonGetAllSelected);

        return this;
    }

    public PageSelectDropdownList clickButtonFirstSelected() throws InterruptedException {
        Thread.sleep(500);
        click(buttonFirstSelected);

        return this;
    }

    public PageSelectDropdownList assertSelectMultiListDemo(String state) throws InterruptedException {
        Thread.sleep(500);
        Assert.assertEquals("First selected option is : "+state, messageOptionsSelected.getText());
        Log.info("Validação Concluída com sucesso");

        return this;
    }


}
