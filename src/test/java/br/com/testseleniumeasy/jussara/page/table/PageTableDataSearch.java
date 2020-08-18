package br.com.testseleniumeasy.jussara.page.table;

import br.com.testseleniumeasy.jussara.core.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class PageTableDataSearch extends PageBase<PageTableDataSearch> {

    @FindBy(id = "task-table-filter")
    private WebElement inputFilterTask;

    @FindBy(id = "task-table")
    private WebElement taskTable;

    @FindBy(xpath = "./html/body/div[2]/div/div[2]/div[2]/div/table")
    private WebElement tableListedUsers;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/div/div/button/span")
    private WebElement buttonFilter;

    @FindBy(xpath = "/html/body/div[2]/div/div[2]/div[2]/div/table/thead/tr/th[1]/input")
    private WebElement filterUserId;


    public PageTableDataSearch clickButtonFilter() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonFilter);

        return this;
    }

    public PageTableDataSearch filterUserById() throws InterruptedException {
        Thread.sleep(1000);
        preencherCampo(filterUserId, "1");

        return this;
    }

    public PageTableDataSearch assertTableUsers(){
        List<WebElement> table = getLinhaTable(tableListedUsers);
        Assert.assertEquals("display: table-row;", table.get(5).getAttribute("style"));

        return this;
    }

}