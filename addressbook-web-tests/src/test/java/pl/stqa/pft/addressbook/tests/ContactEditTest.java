package pl.stqa.pft.addressbook.tests;


import org.openqa.selenium.By;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.OtherContactData;

public class ContactEditTest extends TestBase {
  @Test

  public void testContactEdit() {

    app.getNavigationHelper().initHomeView();
    app.getNavigationHelper().initContactEdit();
    app.getContactHelper().fillContactform(new ContactData("Marcinek", "Grzeskiewiczek", "Manieczek"));
    app.getContactHelper().fillOtherContactForm(new OtherContactData("Warszawka", "123-456-000", "MarMarmarcin@marcin.pl"));
    app.getNavigationHelper().initUpdate();
  }


}
