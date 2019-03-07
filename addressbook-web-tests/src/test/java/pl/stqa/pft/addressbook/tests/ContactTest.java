package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Set;

public class ContactTest extends TestBase {

  @Test
  public void testContact() throws Exception {
    app.goTo().homeview();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
            .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1");
    app.contact().createNewContact(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() + 1);

    contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt());
    before.add(contact);
    Assert.assertEquals(before, after);
  }

}