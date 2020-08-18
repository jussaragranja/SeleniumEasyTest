package br.com.testseleniumeasy.jussara.test;

import br.com.testseleniumeasy.jussara.core.BaseTest;
import br.com.testseleniumeasy.jussara.page.PageHome;
import br.com.testseleniumeasy.jussara.page.datapicker.PageBootstrapDatePicker;
import br.com.testseleniumeasy.jussara.util.Utils;
import org.junit.Test;

public class TestDatePickers extends BaseTest {

    PageHome homeSeleniumEasy = new PageHome();

    @Test
    public void selectTodayDateSucessTest() throws InterruptedException {
        homeSeleniumEasy.acessarBootstrapDatePicker();
        new PageBootstrapDatePicker()
                .clickTodayDate()
                .assertTodayDate(Utils.getDataAtualFormatddMMyyyy());

    }

}
