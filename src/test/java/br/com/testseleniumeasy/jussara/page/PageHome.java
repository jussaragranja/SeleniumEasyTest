package br.com.testseleniumeasy.jussara.page;

import br.com.testseleniumeasy.jussara.core.PageBase;
import br.com.testseleniumeasy.jussara.util.Log;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * @author jussaragranja
 * Class represents the page Home from site SeleniumEasy
 */

public class PageHome extends PageBase<PageHome> {

	@FindBy(id = "image-darkener")
	private WebElement alertLearnSelenium;

	@FindBy(xpath = "//*[@id=\"at-cv-lightbox-button-holder\"]/a[2]")
	private WebElement botaoNoThanks;

	@FindBy(linkText="Input Forms")
	private WebElement inputForms;

	@FindBy(linkText="Simple Form Demo")
	private WebElement simpleFormDemo;

	@FindBy(linkText="Checkbox Demo")
	private WebElement checkBoxDemo;

	@FindBy(linkText="Radio Buttons Demo")
	private WebElement radioButtonsDemo;

	@FindBy(linkText="Select Dropdown List")
	private WebElement selectDropdownList;

	@FindBy(linkText="Input Form Submit")
	private WebElement inputFormSubmit;

	@FindBy(linkText="Ajax Form Submit")
	private WebElement ajaxFormSubmit;

	@FindBy(linkText="JQuery Select dropdown")
	private WebElement jQuerySelectDropdown;

	@FindBy(id="btn_basic_example")
	private WebElement botaoStart;

	@FindBy(linkText="Table")
	private WebElement table;

	@FindBy(linkText = "Table Data Search")
	private WebElement tableDataSearch;

	@FindBy(linkText="Date pickers")
	private WebElement datePickers;

	@FindBy(linkText = "Bootstrap Date Picker")
	private WebElement bootstrapDatePicker;


	public void recusarAlertLearnSelenium(){
		if(isVisibility(alertLearnSelenium)){
			botaoNoThanks.click();
		}
	}

	public void acessarSimpleFormDemo(){
		recusarAlertLearnSelenium();
		click(inputForms);
		aguardarElementoVisivel(simpleFormDemo);
		click(simpleFormDemo);
		Log.info("Acessando página SimpleFormDemo");
	}

	public void acessarCheckBoxDemo(){
		recusarAlertLearnSelenium();
		click(inputForms);
		aguardarElementoVisivel(checkBoxDemo);
		click(checkBoxDemo);
		Log.info("Acessando página CheckBoxDemo");
	}

	public void acessarRadioButtonsDemo(){
		recusarAlertLearnSelenium();
		click(inputForms);
		aguardarElementoVisivel(radioButtonsDemo);
		click(radioButtonsDemo);
		Log.info("Acessando página RadioButtonsDemo");
	}

	public void acessarSelectDropdownList(){
		recusarAlertLearnSelenium();
		click(inputForms);
		aguardarElementoVisivel(selectDropdownList);
		click(selectDropdownList);
		Log.info("Acessando página SelectDropdown List");
	}

	public void acessarAjaxFormSubmit(){
		recusarAlertLearnSelenium();
		click(inputForms);
		aguardarElementoVisivel(ajaxFormSubmit);
		click(ajaxFormSubmit);
		Log.info("Acessando página Ajax Form Submit");
	}

	public void acessarTableDataSearch(){
		recusarAlertLearnSelenium();
		click(table);
		aguardarElementoVisivel(tableDataSearch);
		click(tableDataSearch);
	}

	public void acessarBootstrapDatePicker(){
		recusarAlertLearnSelenium();
		click(datePickers);
		aguardarElementoVisivel(bootstrapDatePicker);
		click(bootstrapDatePicker);
	}
	
}
