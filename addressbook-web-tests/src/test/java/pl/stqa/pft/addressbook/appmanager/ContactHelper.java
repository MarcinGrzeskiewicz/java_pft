package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.ContactData;

import java.util.ArrayList;
import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void clickHomePage() {
    click(By.linkText("home page"));
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

  public void createNewContact(ContactData contactData) {
    initNewContact();
    fillContactform(contactData);
    createContact();
    clickHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public int getContactCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public List<ContactData> getContactList() {
    List<ContactData> contacts = new ArrayList<ContactData>();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr.odd"));
    for(WebElement element : elements) {
      String name = element.getText();
      String lastname = element.getText();
      ContactData contact = new ContactData (name, lastname, null,null,null,null,null);
    contacts.add(contact);
    }
    return contacts;
  }
}
