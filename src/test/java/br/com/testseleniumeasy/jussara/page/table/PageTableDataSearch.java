package br.com.testseleniumeasy.jussara.page.table;

import br.com.testseleniumeasy.jussara.core.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageTableDataSearch extends PageBase<PageTableDataSearch> {

    @FindBy(id = "task-table-filter")
    private WebElement inputFilterTask;

    @FindBy(xpath = "//*[@id=\"task-table\"]/tbody")
    private List<WebElement> taskTable;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/table/tbody")
    private List<WebElement> tableListedUsers;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div/div/button/span")
    private WebElement buttonFilter;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[1]/input")
    private WebElement filterUserId;

    public PageTableDataSearch filterTask() throws InterruptedException {
        Thread.sleep(500);
        preencherCampo(inputFilterTask, "bug");

        return this;
    }

    public PageTableDataSearch assertTableTask() throws InterruptedException {
        Thread.sleep(1000);
        for(WebElement element: taskTable){
            Assert.assertEquals(element.getText(), "7 Bug fixing Kilgore Trout in progress");
        }

        return this;
    }


    public PageTableDataSearch clickButtonFilter() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonFilter);

        return this;
    }

    public PageTableDataSearch filterUserById() throws InterruptedException {
        Thread.sleep(1000);
        preencherCampo(filterUserId, "3");

        return this;
    }

    public PageTableDataSearch assertTableUsers(){

        for(WebElement element: tableListedUsers){
            Assert.assertEquals(element.getText(), "3 larrypt Brigade Swarroon");
        }

        return this;
    }

}