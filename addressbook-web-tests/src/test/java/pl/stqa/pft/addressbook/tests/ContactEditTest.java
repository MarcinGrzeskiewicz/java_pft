package pl.stqa.pft.addressbook.tests;


import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactEditTest extends TestBase {

  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().list().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testContactEdit() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    app.goTo().homeview();
    app.goTo().editById(modifiedContact.getId());
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Marcinek").withLastname("Grzeskiewiczek")
            .withNickname("Manieczek").withAddress("Warszawka").withMobile("123-456-000")
            .withMail("MarMarmarcin@marcin.pl");
    app.contact().fillContactform(contact);
    app.goTo().update();
    app.contact().homepage();
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(before, after);
  }


}
