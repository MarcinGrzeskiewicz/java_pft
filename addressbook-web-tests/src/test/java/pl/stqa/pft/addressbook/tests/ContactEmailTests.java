package pl.stqa.pft.addressbook.tests;


import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTests extends TestBase {
  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().all().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobilePhone("123-456-789").withEmail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testContactEmail() {
    app.goTo().homeview();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);

    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    }

  public static String cleaned (String email) {
    return email.replaceAll("\\s", "").replaceAll("[-)(]", "");
  }
  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
                    .map(ContactEmailTests::cleaned).collect(Collectors.joining("\n"));
  }
}