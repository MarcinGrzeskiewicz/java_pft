package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteTest extends TestBase {
  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.db().contacts().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobilePhone("123-456-789").withEmail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testDeleteContact() {
    app.goTo().homeview();
    Contacts before = app.db().contacts();
    ContactData deletedContact = before.iterator().next();
    app.goTo().deleteContact(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
