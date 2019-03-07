package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactDeleteTest extends TestBase {
  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().list().size() == 0) {
      app.contact().createNewContact(new ContactData("Marcin", "Grzeskiewicz",
              "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl", "test1"));
    }
  }

  @Test
  public void testDeleteContact() {
    app.goTo().homeview();
    List<ContactData> before = app.contact().list();
    int index = before.size() -1;
    app.goTo().checkbox(index);
    app.goTo().delete();
    app.goTo().initOK();
    app.goTo().homeview();
    List<ContactData> after = app.contact().list();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }
}
