package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTest extends TestBase {

  @Test
  public void testContact() throws Exception {
    app.goTo().homeview();
    Contacts before = app.contact().all();
    ContactData contact = new ContactData()
            .withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
            .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1");
    app.contact().createNewContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

}