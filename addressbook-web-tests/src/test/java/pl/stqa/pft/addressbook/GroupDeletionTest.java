package pl.stqa.pft.addressbook;

import org.testng.annotations.Test;


public class GroupDeletionTest extends TestBase {

  @Test
  public void testGroupDeletion() throws Exception {

    gotoGroupPage();
    selectGroup();
    deleteSelectedGroups();
    returnGroupPage();
  }

}


