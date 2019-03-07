package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void groupPage() {
    if (isElementPresent(By.tagName("h1"))
            && wd.findElement(By.tagName("h1")).getText().equals("Groups")
            && isElementPresent(By.name("new"))) {
      return;
    }
    click(By.linkText("groups"));
  }

  public void homeview() {
    if (isElementPresent(By.id("maintable"))) {
      return;
    }
    click(By.linkText("home"));
  }

  public void editById(int id) {
    wd.findElement(By.cssSelector("a[href='edit.php?id=" + id + "']")).click();
  }

  public void update() {
    click(By.xpath("//div[@id='content']/form/input[22]"));
  }

    public void checkboxById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void delete() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void initOK() {
    wd.switchTo().alert().accept();
  }

  public void deleteContact(ContactData contact) {
    checkboxById(contact.getId());
    delete();
    initOK();
    homeview();
  }
}
