package br.com.testseleniumeasy.jussara.test;

import br.com.testseleniumeasy.jussara.core.BaseTest;
import br.com.testseleniumeasy.jussara.page.PageHome;
import br.com.testseleniumeasy.jussara.page.inputforms.*;
import br.com.testseleniumeasy.jussara.util.Constants;
import org.junit.Test;

/**
 * @author jussaragranja
 * Testing the tab pages Input Forms
 */

public class TestInputForms extends BaseTest {

	PageHome homeSeleniumEasy = new PageHome();

	//Test Page SimpleFormDemo

	@Test
	public void simpleFormSingleInputFieldSucessTest(){
		homeSeleniumEasy.accessSimpleFormDemo();
		new PageSimpleFormDemo().enterMessage(Constants.MENSAGEM_TESTE)
				.clickShowMessage()
				.assertMessage(Constants.MENSAGEM_TESTE);
	}

/*

	@Test
	public void simpleFormTwoInputFileldSucessTest(){
		homeSeleniumEasy.accessSimpleFormDemo();
		new PageSimpleFormDemo()
				.enterA(2)
				.enterB(2)
				.clickGetTotal()
				.assertSumEnterAEnterBSucess();
	}

	@Test
	public void simpleFormSingleInputFileldErrorTest(){
		homeSeleniumEasy.accessSimpleFormDemo();
		new PageSimpleFormDemo().clickShowMessage()
				.assertMessage(Constants.MENSAGEM_VAZIA);
	}

	@Test
	public void simpleFormTwoInputFileldErrorTest(){
		homeSeleniumEasy.accessSimpleFormDemo();
		new PageSimpleFormDemo()
				.clickGetTotal()
				.assertSumEnterAEnterBError();
	}
*/

	//Test Page CheckBoxDemo

	@Test
	public void singleCheckboxDemoSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarCheckBoxDemo();
		new PageCheckboxDemo().clickSingleCheckBoxDemo().assertClickCheckBoxSingle();
	}

	@Test
	public void multipleCheckboxDemoCheckAllSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarCheckBoxDemo();
		new PageCheckboxDemo().clickCheckUncheckAll().assertClickCheckAll();
	}

	@Test
	public void multipleCheckboxDemoUncheckAllSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarCheckBoxDemo();
		new PageCheckboxDemo().clickCheckUncheckAll().clickCheckUncheckAll().assertClickUncheckAll();
	}

	@Test
	public void multipleCheckboxDemoUncheckOneSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarCheckBoxDemo();
		new PageCheckboxDemo().clickCheckUncheckAll().assertClickCheckAll().clickOption1().assertClickUncheckAll();
	}

	//Test Page RadioButtonsDemo

	@Test
	public void clickRadioButtonDemoGenderFemaleSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarRadioButtonsDemo();
		new PageRadioButtonsDemo()
				.clickButtonSex(Constants.GENDER_FEMALE)
				.clickGetCheckedValue()
				.assertClickRadioButton(Constants.GENDER_FEMALE);

	}

	@Test
	public void clickRadioButtonDemoGenderMaleSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarRadioButtonsDemo();
		new PageRadioButtonsDemo()
				.clickButtonSex(Constants.GENDER_MALE)
				.clickGetCheckedValue()
				.assertClickRadioButton(Constants.GENDER_MALE);
	}

	@Test
	public void clickRadioButtonDemoErrorTest() throws InterruptedException {
		homeSeleniumEasy.acessarRadioButtonsDemo();
		new PageRadioButtonsDemo()
				.clickGetCheckedValue()
				.assertClickGetCheckedValue();
	}

	@Test
	public void clickGroupRadioButtonsDemoFelameTest() throws InterruptedException {
		String sex = "Female";
		String age = "15 - 50";
		homeSeleniumEasy.acessarRadioButtonsDemo();
		new PageRadioButtonsDemo()
				.clickSexFemaleGroupRadioButtons()
				.clickAgeGroupRadioButtons(age)
				.assertGroupRadioButtons(sex, age);
	}

	@Test
	public void clickGroupRadioButtonsDemoMaleTest() throws InterruptedException {
		String sex = "Male";
		String age = "5 - 15";
		homeSeleniumEasy.acessarRadioButtonsDemo();
		new PageRadioButtonsDemo()
				.clickSexMaleGroupRadioButtons()
				.clickAgeGroupRadioButtons(age)
				.assertGroupRadioButtons(sex, age);
	}

	//Test Page Select Dropdown List

	@Test
	public void selectListDemoSucessTest(){
		homeSeleniumEasy.acessarSelectDropdownList();
		new PageSelectDropdownList()
				.selectADayListDemo(Constants.MONDAY)
				.assertDaySelected(Constants.MONDAY);
	}

	@Test
	public void selecMultitListDemoSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarSelectDropdownList();
		new PageSelectDropdownList()
				.selectMultiListDemo("New Jersey")
				.clickButtonFirstSelected()
				.assertSelectMultiListDemo("New Jersey");

	}

	//Test Page Ajax Form Submit

	@Test
	public void inputNameAndCommentSucessTest() throws InterruptedException {
		homeSeleniumEasy.acessarAjaxFormSubmit();
		new PageAjaxFormSubmit()
				.inputNameAndComment()
				.clickButtonSubmit()
				.assertMessageSucessful()
				.validateHiddenButton();

	}


}
