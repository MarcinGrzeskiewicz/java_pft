package pl.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactEditTest extends TestBase {

  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().list().size() == 0) {
      app.contact().createNewContact(new ContactData("Marcin", "Grzeskiewicz",
              "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl", "test1"));
    }
  }

  @Test
  public void testContactEdit() {
    List<ContactData> before = app.contact().list();
    int index = before.size() -1 ;
    app.goTo().homeview();
    app.goTo().edit(index);
    ContactData contact = new ContactData(before.get(before.size() - 1).getId(), "Marcinek", "Grzeskiewiczek", "Manieczek",
            "Warszawka", "123-456-000", "MarMarmarcin@marcin.pl", null);
    app.contact().fillContactform(contact);
    app.goTo().update();
    app.contact().homepage();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
  }


}
