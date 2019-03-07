package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import pl.stqa.pft.addressbook.model.ContactData;
import pl.stqa.pft.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {

  public ContactHelper(WebDriver wd) {
    super(wd);
  }

  public void createContact() {
    click(By.xpath("(//input[@name='submit'])[2]"));
  }

  public void homepage() {

    click(By.linkText("home page"));
  }

  public void fillContactform(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getLastname());
    type(By.name("nickname"), contactData.getNickname());
    type(By.name("address"), contactData.getAddress());
    type(By.name("mobile"), contactData.getMobilePhone());
    type(By.name("email"), contactData.getMail());
  }


  public void initNewContact() {
    click(By.linkText("add new"));
  }


  public void createNewContact(ContactData contactData) {
    initNewContact();
    fillContactform(contactData);
    createContact();
    contactCache = null;
    homepage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.xpath("//table[@id='maintable']/tbody/tr[2]/td/input"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Contacts contactCache = null;

   public Contacts all() {
     if (contactCache != null) {
       return new Contacts (contactCache);
     }

     contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for(WebElement element : elements) {
      List<WebElement> cells = element.findElements(By.tagName("td"));
      String name = cells.get(2).getText();
      String lastname = cells.get(1).getText();
      String allPhones = cells.get(5).getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      contactCache.add(new ContactData().withId(id).withName(name).withLastname(lastname)
      .withAllPhones(allPhones));
    }
    return new Contacts (contactCache);
  }

  public ContactData infoFromEditForm(ContactData contact) {
     initContactModificationById(contact.getId());
     String firstname =wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname =wd.findElement(By.name("lastname")).getAttribute("value");
    String homephone =wd.findElement(By.name("home")).getAttribute("value");
    String mobilephone =wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone =wd.findElement(By.name("work")).getAttribute("value");
    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withName(firstname).withLastname(lastname)
            .withHomePhone(homephone).withMobilePhone(mobilephone).withWorkPhone(workphone);
  }

private void initContactModificationById(int id) {
     wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
}
}

