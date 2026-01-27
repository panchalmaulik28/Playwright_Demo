package com.pages.elements;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;

public class WebTablesPage {

	Page page;

	private Locator addBtn;
	private Locator searchBox;
	private Locator editBtnList;
	private Locator deleteBtnList;
	private Locator emailList;
	private Locator popupTitle;
	private Locator firstNameTxt;
	private Locator lastNameTxt;
	private Locator emailTxt;
	private Locator ageTxt;
	private Locator salaryTxt;
	private Locator departmentTxt;
	private Locator submitBtn;

	public WebTablesPage(Page page) {
		this.page = page;
		initLocator();
	}

	private void initLocator() {
		addBtn = page.locator("//button[@id='addNewRecordButton']");
		searchBox = page.locator("//input[@id='searchBox']");
		editBtnList = page.locator("//span[@title='Edit']");
		deleteBtnList = page.locator("//span[@title='Delete']");

		// Form locator
		popupTitle = page.locator("//div[@id='registration-form-modal']");
		firstNameTxt = page.locator("//input[@id='firstName']");
		lastNameTxt = page.locator("//input[@id='lastName']");
		emailTxt = page.locator("//input[@id='userEmail']");
		ageTxt = page.locator("//input[@id='age']");
		salaryTxt = page.locator("//input[@id='salary']");
		departmentTxt = page.locator("//input[@id='department']");
		submitBtn = page.locator("//button[@id='submit']");
	}

	public void clickOnAddBtn() {
		addBtn.click();
	}

	public String getPopupTitle() {
		return popupTitle.textContent();
	}

	public void clickOnEditBtn(String email) {
		searchBox.fill(email);
		if (editBtnList.count() != 0) {
			for (int i = 0; i <= editBtnList.count(); i++) {
				emailList = page.locator("//div[@class='rt-td'][position()=4]");

				if (emailList.nth(i).textContent().trim().equals(email.trim())) {
					editBtnList.nth(i).click();
					break;
				}
			}
		}
	}

	public void fillFirstName(String firstName) {
		clearTextBox(firstNameTxt);
		firstNameTxt.fill(firstName);
	}

	public void fillLastName(String lastName) {
		clearTextBox(lastNameTxt);
		lastNameTxt.fill(lastName);
	}

	public void fillEmail(String email) {
		clearTextBox(emailTxt);
		emailTxt.fill(email);
	}

	public void fillAge(String age) {
		clearTextBox(ageTxt);
		ageTxt.fill(age);
	}

	public void fillSalary(String salary) {
		clearTextBox(salaryTxt);
		salaryTxt.fill(salary);
	}

	public void fillDepartment(String department) {
		clearTextBox(departmentTxt);
		departmentTxt.fill(department);
	}

	public void clickOnSubmitBtn() {
		submitBtn.click();
	}

	public void clearTextBox(Locator textBox) {
		textBox.clear();
	}

	public void clearSearchBox() {
		searchBox.clear();
	}

	public void deleteUser(String email) {
		searchBox.fill(email);
		if (editBtnList.count() != 0) {
			for (int i = 0; i <= editBtnList.count(); i++) {
				emailList = page.locator("//div[@class='rt-td'][position()=4]");

				if (emailList.nth(i).textContent().trim().equals(email.trim())) {
					deleteBtnList.nth(i).click();
					break;
				}
			}
		}
	}
}
