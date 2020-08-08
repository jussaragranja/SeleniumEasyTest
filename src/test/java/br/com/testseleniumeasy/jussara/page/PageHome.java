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
	
}
