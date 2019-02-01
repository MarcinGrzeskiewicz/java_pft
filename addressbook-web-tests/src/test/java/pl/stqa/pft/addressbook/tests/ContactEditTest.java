package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactEditTest extends TestBase {
  @Test

  public void testContactEdit() {

    app.getNavigationHelper().initHomeView();
    app.getNavigationHelper().initContactEdit();
    app.getContactHelper().fillContactform(new ContactData("Marcinek", "Grzeskiewiczek", "Manieczek", "Warszawka", "123-456-000", "MarMarmarcin@marcin.pl"));
    app.getNavigationHelper().initUpdate();
  }


}
