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

    Point P1 = new Point (2, 5);
    Point P2 = new Point (5, 9);
    System.out.println("Odległość = " + Distance(P1,P2));


    Point p1 = new Point (2, 1);
    Point p2 = new Point (5, 5);
    System.out.println("Odległość między dwoma punktami (" + p1.x +" ; "+ p1.y +") i (" + p2.x +" ; "+p2.y+ ") = " + (Distance(P1,P2)));
  }

  public static void hello(String somebody) {
    System.out.println("Hello, " + somebody + "!");
  }

  public static double Distance(Point P1, Point P2) {
    return Math.sqrt((P2.x-P1.x)*(P2.x-P1.x) +(P2.y-P1.y)*(P2.y-P1.y) );
    
  }

}