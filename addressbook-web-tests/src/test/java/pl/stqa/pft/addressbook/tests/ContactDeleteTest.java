package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testContactEdit() {

    app.getNavigationHelper().initHomeView();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createNewContact(new ContactData("Marcin", "Grzeskiewicz",
              "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl", "test1"));
    }
    app.getNavigationHelper().initHomeView();
    app.getNavigationHelper().checkCheckbox();
    app.getNavigationHelper().initDelete();
    app.getNavigationHelper().initOK();


  }
}
