package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;

public class ContactTest extends TestBase {


  @Test
  public void testContact() throws Exception {

    initNewContact();
    fillContactform(new ContactData("Marcin", "Grzeskiewicz", "Maniek", "Warszawa", "123-456-789", "marcin@marcin.pl"));
    createContact();
  }
}
