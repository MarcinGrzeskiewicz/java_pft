package pl.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ContactDeleteTest extends TestBase {
  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().all().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testDeleteContact() {
    app.goTo().homeview();
    Contacts before = app.contact().all();
    ContactData deletedContact = before.iterator().next();
    app.goTo().deleteContact(deletedContact);
    assertThat(app.contact().count(), equalTo(before.size() - 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.without(deletedContact)));
  }
}
