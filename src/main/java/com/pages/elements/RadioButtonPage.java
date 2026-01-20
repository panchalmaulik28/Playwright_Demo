package com.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class RadioButtonPage {

	Page page;
	Locator yesTxt;
	Locator impressiveTxt;
	Locator noTxt;
	Locator text;

	public RadioButtonPage(Page page) {
		this.page = page;
		initRadioButtonLocator();
	}

	private void initRadioButtonLocator() {
		yesTxt = page.locator("//label[@for='yesRadio']");
		impressiveTxt = page.locator("//label[@for='impressiveRadio']");
		noTxt = page.getByLabel("//label[@for='noRadio']");
		text = page.locator("//span[@class='text-success']");

	}

	public void selectRadio(String radioButtonName) {
		switch (radioButtonName) {
		case "Yes":
			yesTxt.waitFor();
			yesTxt.click();
			break;

		case "No":
			noTxt.waitFor();
			noTxt.click();
			break;

		case "Impressive":
			impressiveTxt.waitFor();
			impressiveTxt.click();
			break;

		default:
			System.out.println("Wrong Radio Button Name..!");
			break;
		}
	}

	public String getRadioButtonName() {
		return text.textContent().trim();
	}
}
