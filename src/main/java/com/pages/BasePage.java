package com.pages;

import com.base.Base;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class BasePage extends Base{

	Page page;
	Locator homePageModules;
	Locator sideMenu;
	Locator subMenu; 
	
	public BasePage(Page page) {
		this.page = page;
		initLocator();
	}

	public void initLocator() {
		homePageModules = page.locator("//div[@class='category-cards']/div/div/div[3]/h5");
		sideMenu = page.locator("//span[@class='group-header']/div/div[1]");
		subMenu = page.locator("//li[contains(@class,'btn btn-light ')]/span");
	}

	public void modulesClick(String moduleName) {
		homePageModules.nth(1).waitFor();
		int size = homePageModules.count();
		for (int i = 0; i <= size - 1; i++) {
			if(homePageModules.nth(i).textContent().trim().equals(moduleName.trim())) {
				homePageModules.nth(i).scrollIntoViewIfNeeded();
				homePageModules.nth(i).click();
				break;
			}
		}
	}

	public void sideMenuClick(String sideMenuName) {
		sideMenu.nth(1).waitFor();
		int size = sideMenu.count();
		for (int i = 0; i <= size - 1; i++) {
			if(sideMenu.nth(i).textContent().trim().equals(sideMenuName.trim())) {
				sideMenu.nth(i).scrollIntoViewIfNeeded();
				sideMenu.nth(i).click();
				break;
			}
		}
	}
	
	public void subMenuClick(String subMenuName) {
		//subMenu.nth(1).waitFor();
		int size = subMenu.count();
		for (int i = 0; i <= size - 1; i++) {
			if(subMenu.nth(i).textContent().trim().equals(subMenuName.trim())) {
				subMenu.nth(i).scrollIntoViewIfNeeded();
				subMenu.nth(i).click();
				break;
			}
		}
	}
}
