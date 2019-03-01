package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testDeleteContact() {

    app.getNavigationHelper().initHomeView();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createNewContact(new ContactData("Marcin", "Grzeskiewicz",
              "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl", "test1"));
    }

    app.getNavigationHelper().initHomeView();
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().checkCheckbox(before.size() - 1);
    app.getNavigationHelper().initDelete();
    app.getNavigationHelper().initOK();
    app.getNavigationHelper().initHomeView();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);
  }
}
