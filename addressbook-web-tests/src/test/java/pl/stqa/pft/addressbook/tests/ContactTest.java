package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactTest extends TestBase {

  @Test
  public void testContact() throws Exception {
    app.goTo().homeview();
    Contacts before = app.contact().all();
    File photo = new File("src/test/resources/photo.jpg");
    ContactData contact = new ContactData()
            .withName("Ola").withLastname("Grzeskiewicz").withNickname("Maniek")
            .withAddress("Warszawa").withMobilePhone("123-456-789").withEmail("marcin@marcin.pl").withGroup("test1")
            .withPhoto(photo);
    app.contact().createNewContact(contact);
    assertThat(app.contact().count(), equalTo(before.size() + 1));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withAdded(contact.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));

  }

  @Test
  public void testCurrentDir()
  {File currentDir = new File("");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/photo.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());

  }
}