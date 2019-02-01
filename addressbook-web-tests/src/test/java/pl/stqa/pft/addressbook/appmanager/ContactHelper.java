package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import pl.stqa.pft.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobile());
    type(By.name("email"), contactData.getMail());

  }

  public void initNewContact() {
    click(By.linkText("add new"));
  }

}
