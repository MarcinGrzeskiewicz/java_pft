package pl.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;

public class ContactDeleteTest extends TestBase {

  @Test
  public void testContactEdit() {

    app.getNavigationHelper().initHomeView();
    app.getNavigationHelper().checkCheckbox();
    app.getNavigationHelper().initDelete();
    app.getNavigationHelper().initOK();
    

  }
}
