package pl.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.List;

public class ContactTest extends TestBase {


  @Test
  public void testContact() throws Exception {
    List<ContactData> before = app.getContactHelper().getContactList();
    app.getContactHelper().createNewContact(new ContactData("Marcin", "Grzeskiewicz", "Maniek",
            "Warszawa","123-456-789", "marcin@marcin.pl", "test1"));
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}