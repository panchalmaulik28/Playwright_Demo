package testcases;

import org.testng.annotations.Test;

import com.base.Base;
import com.pages.BasePage;
import com.pages.elements.CheckBoxPage;
import com.pages.elements.RadioButtonPage;
import com.pages.elements.TextBoxPage;
import com.pages.elements.WebTablesPage;

public class ElementsTest extends Base {

	BasePage basePage;
	WebTablesPage webTablesPage;

	String fullName = "Maulik Panchal";
	String email = "maulik@yopmail.com";
	String current_address = "Gota";
	String perment_Address = "Zundal";

	@Test(priority = 0)
	public void verifyTextBoxAddedData() {
		basePage = new BasePage(page);
		TextBoxPage textBoxPage = new TextBoxPage(page);

		basePage.modulesClick("Elements");
		basePage.subMenuClick("Text Box");
		textBoxPage.fillTheTextBox(fullName, email, current_address, perment_Address);

		softAssert.assertEquals(textBoxPage.getOutPut("name"), "Name:" + fullName);
		softAssert.assertEquals(textBoxPage.getOutPut("email"), "Email:" + email);
		softAssert.assertEquals(textBoxPage.getOutPut("currentAdd"), "Current Address :" + current_address);
		softAssert.assertEquals(textBoxPage.getOutPut("perAdd"), "Permananet Address :" + perment_Address);
	}

	@Test(priority = 1)
	public void verifyCheckBox() {
		String[] value = { "Desktop", "WorkSpace", "Veu", "Public", "Private", "Classified", "Excel File.doc" };
		basePage = new BasePage(page);
		CheckBoxPage checkBoxPage = new CheckBoxPage(page);

		basePage.modulesClick("Elements");
		basePage.subMenuClick("Check Box");
		checkBoxPage.verifyCheckBoxIsChecked(value);
	}

	@Test(priority = 2)
	public void verifyRadioButton() {
		String radioButtonNameYes = "Yes";
		String radioButtonNameNo = "No";
		String radioButtonNameImpressive = "Impressive";

		basePage = new BasePage(page);
		RadioButtonPage radioButtonPage = new RadioButtonPage(page);

		basePage.modulesClick("Elements");
		basePage.subMenuClick("Radio Button");
		radioButtonPage.selectRadio(radioButtonNameImpressive);
		softAssert.assertEquals(radioButtonPage.getRadioButtonName(), radioButtonNameImpressive);
	}

	@Test(priority = 3)
	public void verifyAddUser() {
		basePage = new BasePage(page);
		webTablesPage = new WebTablesPage(page);

		String firstName = "Maulik";
		String lastNamee = "Panchal";
		String email = "maulik@yopmail.com";
		String age = "18";
		String salary = "100000";
		String department = "Information Technology";

		basePage.modulesClick("Elements");
		basePage.subMenuClick("Web Tables");

		webTablesPage.clickOnAddBtn();
		webTablesPage.fillFirstName(firstName);
		webTablesPage.fillLastName(lastNamee);
		webTablesPage.fillEmail(email);
		webTablesPage.fillAge(age);
		webTablesPage.fillSalary(salary);
		webTablesPage.fillDepartment(department);
		webTablesPage.clickOnSubmitBtn();
	}

	@Test(priority = 4)
	public void verifyEditUser() {
		verifyAddUser();

		String firstName = "Maulik Update";
		String lastNamee = "Panchal Update";
		String oldEmail = "maulik@yopmail.com";
		String email = "maulikupdate@yopmail.com";
		String age = "20";
		String salary = "150000";
		String department = "Quality Analyst";

		webTablesPage.clickOnEditBtn(oldEmail);
		webTablesPage.fillFirstName(firstName);
		webTablesPage.fillLastName(lastNamee);
		webTablesPage.fillEmail(email);
		webTablesPage.fillAge(age);
		webTablesPage.fillSalary(salary);
		webTablesPage.fillDepartment(department);
		webTablesPage.clickOnSubmitBtn();
	}
	
	@Test(priority = 5)
	public void verifyDeleteUser() {
		verifyEditUser();
		
		String email = "maulikupdate@yopmail.com";
	
		webTablesPage.deleteUser(email);
	}
}
