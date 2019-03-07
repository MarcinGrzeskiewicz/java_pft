package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactDeleteTest extends TestBase {
  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().list().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testDeleteContact() {
    app.goTo().homeview();
    Set<ContactData> before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.goTo().deleteContact(deletedContact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(deletedContact);
    Assert.assertEquals(before, after);
  }


}
