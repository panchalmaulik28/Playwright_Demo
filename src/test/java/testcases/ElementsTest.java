package testcases;

import org.testng.annotations.Test;
import com.base.Base;
import com.pages.BasePage;
import com.pages.elements.CheckBoxPage;
import com.pages.elements.RadioButtonPage;
import com.pages.elements.TextBoxPage;

public class ElementsTest extends Base {

	BasePage basePage;

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
}
