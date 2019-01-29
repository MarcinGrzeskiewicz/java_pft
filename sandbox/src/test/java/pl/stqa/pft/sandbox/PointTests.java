package pl.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;


public class PointTests {

  @Test
  public void testArea() {
    Point p1 = new Point(5, 5);
    Point p2 = new Point(2, 1);
    Assert.assertEquals(p1.Distance(p2), 4.0);
  }

  @Test
  public void testArea1() {
    Point p1 = new Point(5, 5);
    Point p2 = new Point(2, 1);
    Assert.assertEquals(p1.Distance(p2), 5.0);
  }

  @Test
  public void testArea2() {
    Point p1 = new Point(5, 5);
    Point p2 = new Point(2, 1);
    Assert.assertEquals(p1.Distance(p2), 6.0);
  }
}