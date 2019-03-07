package pl.stqa.pft.addressbook.tests;


import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;

public class ContactEditTest extends TestBase {

  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().all().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobile("123-456-789").withMail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testContactEdit() {
    Contacts before = app.contact().all();
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
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before. without(modifiedContact).withAdded(contact)));
  }
}
