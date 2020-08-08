package br.com.testseleniumeasy.jussara.page.inputforms;

import br.com.testseleniumeasy.jussara.core.PageBase;
import br.com.testseleniumeasy.jussara.util.Conversions;
import br.com.testseleniumeasy.jussara.util.Log;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;


/**
 * @author jussaragranja
 * Class represents the page Simple Form Demo from site SeleniumEasy
 */

public class PageSimpleFormDemo extends PageBase<PageSimpleFormDemo> {

	@FindBy(id = "user-message")
	private WebElement inputMsg;

	@FindBy(xpath ="//*[@id=\"get-input\"]/button")
	private WebElement labelYourMessage;
	
	@FindBy(id = "display")
	private WebElement labelTextoSuaMsg;

	@FindBy(id = "sum1")
	private WebElement inputEnterNumberA;

	@FindBy(id = "sum2")
	private WebElement inputEnterNumberB;

	@FindBy(xpath ="//button[contains(text(),'Get Total')]")
	private WebElement buttonGetTotal;

	@FindBy(id = "displayvalue")
	private WebElement labelSum;

	private int sumNumberA;
	private int sumNumberB;

	public PageSimpleFormDemo enterMessage(String texto){
		preencherCampo(inputMsg, texto);
		Log.info("Preechendo texto");

		return this;
	}

	public PageSimpleFormDemo clickShowMessage(){
		aguardarElementoVisivel(labelYourMessage);
		click(labelYourMessage);
		Log.info("Click show message");

		return this;
	}

	public PageSimpleFormDemo assertMessage(String texto) {
		Assert.assertEquals(texto, labelTextoSuaMsg.getText());
		Log.info("Validaçao de texto da mensagem concluída com sucesso!");

		return this;
	}

	public PageSimpleFormDemo enterA(int numberA){
		aguardarElementoVisivel(inputEnterNumberA);
		preencherCampo(inputEnterNumberA, Conversions.intToString(numberA));
		Log.info("Escrevendo Número no campo Enter A");
		sumNumberA = numberA;

		return this;
	}

	public PageSimpleFormDemo enterB(int numberB){
		aguardarElementoVisivel(inputEnterNumberB);
		preencherCampo(inputEnterNumberB, Conversions.intToString(numberB));
		Log.info("Escrevendo Número no campo Enter B");
		sumNumberB = numberB;

		return this;
	}

	public PageSimpleFormDemo clickGetTotal(){
		aguardarElementoVisivel(buttonGetTotal);
		click(buttonGetTotal);
		Log.info("Clicando no Botão de Soma");

		return this;
	}

	public PageSimpleFormDemo assertSumEnterAEnterBSucess(){
		aguardarElementoVisivel(labelSum);
		Assert.assertEquals(Conversions.intToString(sumNumberA+sumNumberB), labelSum.getText());
		Log.info("Validação de soma concluída com sucesso!");
		return this;
	}

	public PageSimpleFormDemo assertSumEnterAEnterBError(){
		aguardarElementoVisivel(labelSum);
		Assert.assertEquals("NaN", labelSum.getText());
		Log.info("Validação de soma concluída com sucesso!");
		return this;
	}

}
