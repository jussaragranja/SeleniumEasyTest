package br.com.testseleniumeasy.jussara.page.inputforms;


import br.com.testseleniumeasy.jussara.core.PageBase;
import br.com.testseleniumeasy.jussara.util.Constants;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author jussaragranja
 * Class represents the page Ajax Form Submit from site SeleniumEasy
 */

public class PageAjaxFormSubmit extends PageBase<PageAjaxFormSubmit> {

    @FindBy(name = "title")
    private WebElement inputName;

    @FindBy(id = "description")
    private WebElement inputComment;

    @FindBy(name = "btn-submit")
    private WebElement buttonSubmit;

    @FindBy(id = "submit-control")
    private WebElement messageSuccessful;

    public PageAjaxFormSubmit inputNameAndComment(){
        writeInField(inputName, Constants.MENSAGEM_TESTE);
        writeInField(inputComment, Constants.MENSAGEM_TESTE);

        return this;
    }

    public PageAjaxFormSubmit clickButtonSubmit() throws InterruptedException {
        Thread.sleep(1000);
        click(buttonSubmit);

        return this;
    }

    public PageAjaxFormSubmit assertMessageSucessful() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertEquals("Form submited Successfully!", messageSuccessful.getText());

        return this;
    }

    public PageAjaxFormSubmit validateHiddenButton() throws InterruptedException {
        Thread.sleep(1000);
        Assert.assertTrue(!isVisibility(buttonSubmit));

        return this;
    }

}
