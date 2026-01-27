package com.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class TextBoxPage {

	Page page;
	Locator centerHeaderTxt;

	// TextBoxPage
	Locator fullNameTxt;
	Locator fullNameOutPut;
	Locator emailTxt;
	Locator emailOutPut;
	Locator currentAddressTxt;
	Locator currentAddressOutPut;
	Locator permentAddressTxt;
	Locator permentAddressOutPut;
	Locator submitBtn;

	public TextBoxPage(Page page) {
		this.page = page;
		initTextBoxLocator();
	}

	public void initTextBoxLocator() {
		centerHeaderTxt = page.locator("//h1[@class='text-center']");

		// Form
		fullNameTxt = page.locator("//input[@placeholder='Full Name']");
		emailTxt = page.locator("//input[@id='userEmail']");
		currentAddressTxt = page.locator("//textarea[@id='currentAddress']");
		permentAddressTxt = page.locator("//textarea[@id='permanentAddress']");
		submitBtn = page.locator("//button[text()='Submit']");

		// output
		fullNameOutPut = page.locator("//div[@id='output']/div/p[@id='name']");
		emailOutPut = page.locator("//div[@id='output']/div/p[@id='email']");
		currentAddressOutPut = page.locator("//div[@id='output']/div/p[@id='currentAddress']");
		permentAddressOutPut = page.locator("//div[@id='output']/div/p[@id='permanentAddress']");
	}

	public void fillTheTextBox(String fullName, String email, String address, String per_address) {
		if (centerHeaderTxt.textContent().trim().equals("Text Box")) {
			fullNameTxt.fill(fullName);
			emailTxt.fill(email);
			currentAddressTxt.fill(address);
			permentAddressTxt.fill(per_address);
			submitBtn.click();
		}
	}

	public String getOutPut(String output) {
		String value = null;
		switch (output) {

		case "name":
			value = fullNameOutPut.textContent().trim();
			break;

		case "email":
			value = emailOutPut.textContent().trim();
			break;

		case "currentAdd":
			value = currentAddressOutPut.textContent().trim();
			break;

		case "perAdd":
			value = permentAddressOutPut.textContent().trim();
			break;

		default:
			break;
		}
		return value;
	}
}
