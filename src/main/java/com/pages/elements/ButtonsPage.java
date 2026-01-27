package com.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.options.MouseButton;

public class ButtonsPage {

	Page page;
	private Locator doubleClickBtn;
	private Locator rightClickBtn;
	private Locator clickMeBtn;
	private Locator doubleClickMessage;
	private Locator rightClickMessage;
	private Locator clickMeMessage;

	public ButtonsPage(Page page) {
		this.page = page;
		initLocator();
	}

	private void initLocator() {
		doubleClickBtn = page.locator("//button[@id='doubleClickBtn']");
		doubleClickMessage = page.locator("//p[@id='doubleClickMessage']");
		rightClickBtn = page.locator("//button[@id='rightClickBtn']");
		rightClickMessage = page.locator("//p[@id='rightClickMessage']");
		clickMeBtn = page.locator("//button[text()='Click Me']");
		clickMeMessage = page.locator("//p[@id='dynamicClickMessage']");
	}

	public void doubleClickOnButton() {
		doubleClickBtn.dblclick();
	}

	public String getDoubleClickMessage() {
		return doubleClickMessage.textContent().trim();
	}

	public void rightClickOnButton() {
		rightClickBtn.click(new Locator.ClickOptions().setButton(MouseButton.RIGHT));

	}

	public String getRightClickOnMessage() {
		return rightClickMessage.textContent().trim();
	}

	public void clickMeOnButton() {
		clickMeBtn.click();
	}

	public String getclickMeMessage() {
		return clickMeMessage.textContent().trim();
	}
}
