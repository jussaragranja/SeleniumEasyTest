package br.com.testseleniumeasy.jussara.core;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import static org.junit.Assert.fail;


/**
 * @author jussaragranja
 * Class Page Actions
 */

public abstract class PageBase<T> {

	private static final int LOAD_TIMEOUT = 30;
	private String windowHandleJanelaInicial;

	public WebDriver driver;

	public PageBase(){
		this.driver = BaseTest.getDriver();
		PageFactory.initElements(BaseTest.getDriver(), this);
	}

	public void preencherCampo(WebElement element, String keysToSend){
		try {
			element.clear();
			element.sendKeys(keysToSend);
		} catch (WebDriverException e) {
			fail("Nao foi possivel encontrar o elemento para preencher: "+element +". Pagina: " +this.driver.getTitle()+"\n "+e.getMessage());
			
		}
	}
	public void click(WebElement element){
		try {
			aguardarElementoVisivel(element);
			element.click();
		} catch (Exception e) {
			fail("Nao foi possivel encontrar o elemento para clicar: "+element +". Pagina: " +this.driver.getTitle()+"\n "+e.getMessage());
		}
	}
	
	public String getTextElement(WebElement element){
		if(!isVisibility(element)){
			fail("Erro ao buscar texto em tela. Elemento: ["+element+"] Favor verificar evidencia.");
		}
		return element.getText();
	}
	
	public String getValorAtributo(WebElement element){
		return element.getAttribute("value");
	}
	
	public void selectElementByVisibleText(WebElement element, String textVisible){
		try {
			new Select(element).selectByVisibleText(textVisible);
		} catch (NoSuchElementException e){
			fail("Erro ao selecionar no elemento: ["+element.getTagName()+ "] com o o valor: "+textVisible);
		}
	}

	public void selectElementByVisibleValue(WebElement element, String valueVisibel){
		try {
			new Select(element).selectByValue(valueVisibel);
		} catch (NoSuchElementException e){
			fail("Erro ao selecionar no elemento: ["+element.getTagName()+ "] com o o valor: "+valueVisibel);
		}
	}

	public WebElement selectRandonElement(WebElement elemento) {

		Select comboBox = new Select(elemento);
		int randomIndex = new Random().nextInt(comboBox.getOptions().size());
		comboBox.selectByIndex(randomIndex);

		return elemento;
	}

	public void acceptAlert(){
		try {
	        Alert alert = this.driver.switchTo().alert();
	        alert.accept();
	    } catch (Exception e) {
	    	fail("Erro ao realizar a confirmacao do Alerta");
	    }
	}
	
	public String getAlert(){
		String alerta="";
		try {
			Alert alert = this.driver.switchTo().alert();
			alerta = alert.getText();
		} catch (Exception e) {
		}
		return alerta;
	}
	public void aguardarElementoVisivel(WebElement element){
		try {
			WebDriverWait driverWait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOf(element));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar elemento: "+element);
		}
	}
	public void aguardarListElementoVisivel(List<WebElement> elements){
		try {
			WebDriverWait driverWait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.visibilityOfAllElements(elements));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar o elemento List: "+elements);
		}
	}
	public void aguardarElementoDesaparecer(By locator){
		try {
			WebDriverWait driverWait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.invisibilityOfElementLocated(locator));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar elemento desaparecer da tela: "+locator);
		}
	}
	
	public void aguardarElementoVisivelComTexto(WebElement element, String text){
		try {
			WebDriverWait driverWait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			driverWait.until(ExpectedConditions.textToBePresentInElement(element, text.trim()));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar elemento: "+element);
		}
	}
	public void aguardarElementoClicavel(WebElement element){
		try {
			WebDriverWait wait = new WebDriverWait(this.driver, LOAD_TIMEOUT);
			wait.until(ExpectedConditions.elementToBeClickable(element));
		} catch (Exception e) {
			fail("Tempo excedido para aguardar elemento: "+element);
		}
	}

	public boolean isVisibility(WebElement elemento){
		try {
			return elemento.isDisplayed();	
		} catch (NoSuchElementException e){
			return false;
		}
	}
	
	public boolean isVisibility(By locator){
        try {
            WebElement element = this.driver.findElement(locator);
            element.isDisplayed();
        } catch (Exception e) {
            return false;
        }
        return true;
    }
	
	public void clicarBotaoDireito(WebElement elemento){
		try {
			Actions action = new Actions(this.driver);
			action.contextClick(elemento).build().perform();
		} catch (Exception e) {
			Actions action = new Actions(this.driver);
			action.contextClick().build().perform();
		}
	}
	
	public void moverCursorPara(WebElement elemento){
		Actions action = new Actions(this.driver);
		action.moveToElement(elemento).build().perform();
	}
	
	public boolean containsText(WebElement elemento, String texto){
		aguardarElementoVisivel(elemento);
		return elemento.getText().contains(texto);
	}
	
	/**
	 * redirects to new window
	 */
	public void alternarJanela(){
		windowHandleJanelaInicial = this.driver.getWindowHandle();
		Set<String> windowHandles = this.driver.getWindowHandles();
		for (String windowHandle : windowHandles) {
			if(!windowHandle.equals(windowHandleJanelaInicial)) {
				this.driver.switchTo().window(windowHandle);
			}
		}
		setWindowHandleJanelaInicial(windowHandleJanelaInicial);
	}

	public String getWindowHandleJanelaInicial(){
		return windowHandleJanelaInicial;
	}

	public void setWindowHandleJanelaInicial(String windowHandleJanelaInicial){
		this.windowHandleJanelaInicial = windowHandleJanelaInicial;
	}
	
	/**
	 * @return previous window
	 */
	public void retornarJanelaOriginal(){
		this.driver.switchTo().window(getWindowHandleJanelaInicial());
	}
	

	public WebElement getElementBy(By by){
		return this.driver.findElement(by);
	}

	public void clearElement(WebElement element){
		try {
			element.clear();
		} catch (Exception e) {
			fail("Erro ao limpar campo em tela. "+element);
		}
	}

	public String getTitle(){
		return this.driver.getTitle();
	}

	public List<List<WebElement>> getTable(WebElement table) {
		aguardarElementoVisivel(table);

		List<WebElement> tr = table.findElements(By.cssSelector("tr"));
		List<List<WebElement>> tabela = new ArrayList<List<WebElement>>();

		tr.forEach(linhas -> {
			List<WebElement> celulas = linhas.findElements(By.cssSelector("td"));
			List<WebElement> linha = new ArrayList<WebElement>();

			celulas.forEach(celula -> {
				linha.add(celula);
			});

			tabela.add(linha);
		});

		return tabela;
	}

	public List<WebElement> getLinhaTable(WebElement table){

		List<WebElement> tr = table.findElements(By.cssSelector("tr"));
		tr = table.findElements(By.cssSelector("tr"));

		return tr;
	}
}
