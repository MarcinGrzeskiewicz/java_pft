package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactTest extends TestBase {


  @Test
  public void testContact() throws Exception {

    app.getContactHelper().createNewContact(new ContactData("Marcin", "Grzeskiewicz", "Maniek",
            "Warszawa","123-456-789", "marcin@marcin.pl", "test1"));

  }

}