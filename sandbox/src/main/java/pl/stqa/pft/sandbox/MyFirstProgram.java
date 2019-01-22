package pl.stqa.pft.sandbox;

import java.sql.SQLOutput;

public class MyFirstProgram {

  public static void main(String[] args) {
    hello("world");
    hello("user");
    hello("Marcin");

    Square s = new Square(5);
    System.out.println("Powierzchnia kwadratu o boku " + s.l + "=" + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Powierzchnia prostokąta o boku " + r.a + " i " + r.b + " = " + r.area());

    Point p = new Point (2, 1,6, 4);
    System.out.println("Odległość między dwoma punktami (" + p.x1 +" ; "+ p.y1 +") i (" + p.x2 +" ; "+p.y2+ ") = " + p.Distance());
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }



}