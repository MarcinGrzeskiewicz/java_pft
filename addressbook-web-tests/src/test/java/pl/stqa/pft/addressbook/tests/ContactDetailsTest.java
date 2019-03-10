package pl.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.*;

public class ContactDetailsTest extends TestBase {

  @BeforeMethod
  public void ensureContactPreconditions() {
    app.goTo().homeview();
    if (app.contact().all().size() == 0) {
      app.contact().createNewContact(new ContactData().withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
              .withAddress("Warszawa").withMobilePhone("123-456-789").withEmail("marcin@marcin.pl").withGroup("test1"));
    }
  }

  @Test
  public void testContactDetails() {
    app.goTo().homeview();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    String contactInfoFromDetailsForm = app.contact().infoFromDetailsForm(contact);

    assertThat((cleaned(contactInfoFromDetailsForm)), equalTo(mergeDetails(contactInfoFromEditForm)));

  }


  private String mergeDetails(ContactData contact) {
    return Arrays.asList(contact.getName(), contact.getLastname(), contact.getNickname(), contact.getAddress(),
            contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
            contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> !s.equals(""))
            .map(ContactDetailsTest::cleaned)
            .collect(Collectors.joining());
  }

  public static String cleaned(String details) {
    return details.replaceAll("\\s", "").replaceAll("[-()]", "")
            .replaceAll("\n", "")
            .replaceAll("[H: W:]", "");
  }
}