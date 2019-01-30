package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.OtherContactData;

public class ContactTest extends TestBase {


  @Test
  public void testContact() throws Exception {

    app.getContactHelper().initNewContact();
    app.getContactHelper().fillContactform(new ContactData("Marcin", "Grzeskiewicz", "Maniek"));
    app.getContactHelper().fillOtherContactForm(new OtherContactData("Warszawa", "123-456-789", "marcin@marcin.pl"));
    app.getContactHelper().createContact();
  }

}