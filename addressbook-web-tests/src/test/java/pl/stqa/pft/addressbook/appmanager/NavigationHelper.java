package pl.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper extends HelperBase {

  public NavigationHelper(WebDriver wd) {
    super(wd);
  }

  public void gotoGroupPage() {
    click(By.linkText("groups"));
  }

  public void initHomeView() {
    click(By.linkText("home"));
}

    public void initContactEdit() {click(By.xpath("//table[@id='maintable']/tbody/tr[3]/td[8]/a/img")); }

    public void initUpdate(){click(By.xpath("//div[@id='content']/form/input[22]"));}

  }
