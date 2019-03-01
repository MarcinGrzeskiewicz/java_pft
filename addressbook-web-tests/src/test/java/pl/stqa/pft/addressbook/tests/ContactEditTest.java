package pl.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.HashSet;
import java.util.List;

public class ContactEditTest extends TestBase {
  @Test

  public void testContactEdit() {

    app.getNavigationHelper().initHomeView();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createNewContact(new ContactData("Marcin", "Grzeskiewicz",
              "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl", "test1"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getNavigationHelper().initHomeView();
    app.getNavigationHelper().initContactEdit(before.size() - 1);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Marcinek", "Grzeskiewiczek", "Manieczek",
            "Warszawka", "123-456-000", "MarMarmarcin@marcin.pl", null);
    app.getContactHelper().fillContactform(contact);
    app.getNavigationHelper().initUpdate();
    app.getContactHelper().clickHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(before.size()-1);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }


}
