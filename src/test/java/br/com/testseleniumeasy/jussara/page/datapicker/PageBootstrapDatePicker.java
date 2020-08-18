package br.com.testseleniumeasy.jussara.page.datapicker;

import br.com.testseleniumeasy.jussara.core.PageBase;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.Date;

public class PageBootstrapDatePicker extends PageBase<PageBootstrapDatePicker> {

    @FindBy(xpath = "//*[@id=\"sandbox-container1\"]/div/span")
    private WebElement buttonSelectDate;

    @FindBy(xpath = "/html/body/div[3]/div[1]/table/tfoot/tr[1]/th")
    private WebElement todayDate;

    @FindBy(xpath = "//*[@id=\"sandbox-container1\"]/div/input")
    private WebElement date;


    public PageBootstrapDatePicker clickTodayDate() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonSelectDate);
        Thread.sleep(1000);
        click(todayDate);

        return this;
    }

    public PageBootstrapDatePicker assertTodayDate(String dataAtual){
        Assert.assertEquals(date.getAttribute("value"), dataAtual);

        return this;
    }

}
