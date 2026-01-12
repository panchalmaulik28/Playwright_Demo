package com.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class CheckBoxPage {

	Page page;

	// CheckBox
	Locator checkBoxList;
	Locator checkBoxNameList;
	Locator expandAll;

	public CheckBoxPage(Page page) {
		this.page = page;
		initCheckBoxLocator();
	}

	public void initCheckBoxLocator() {
		checkBoxList = page.locator("//span[@class='rct-checkbox']");
		checkBoxNameList = page.locator("//span[@class='rct-title']");
		expandAll = page.locator("//button[@title='Expand all']");
	}

	public void verifyCheckBoxIsChecked(String[] name) {
		int size = checkBoxNameList.count();
		if (size == 1) {
			expandAll.click();
		}
		for (int i = 0; i < size; i++) {
		    size = checkBoxNameList.count();
		    int j = 0;
		    while (j < name.length) {
		        if (checkBoxNameList.nth(i).textContent().trim().equals(name[j].trim())) {
		            checkBoxList.nth(i).click();
		            break; 
		        }
		        j++; 
		    }
		}
	}
}
