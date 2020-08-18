package br.com.testseleniumeasy.jussara.test;

import br.com.testseleniumeasy.jussara.core.BaseTest;
import br.com.testseleniumeasy.jussara.page.PageHome;
import br.com.testseleniumeasy.jussara.page.table.PageTableDataSearch;
import org.junit.Test;

/**
 * @author jussaragranja
 * Testing the tab pages Table
 */

public class TestTableDataSearch extends BaseTest {

    PageHome homeSeleniumEasy = new PageHome();

    @Test
    public void tableFilterTaskSucessTest() throws InterruptedException {
        homeSeleniumEasy.acessarTableDataSearch();
        new PageTableDataSearch()
                .filterTask()
                .assertTableTask();

    }

    @Test
    public void tableFilterListedUsersSucessTest() throws InterruptedException {
        homeSeleniumEasy.acessarTableDataSearch();
        new PageTableDataSearch()
                .clickButtonFilter()
                .filterUserById()
                .assertTableUsers();

    }

}
