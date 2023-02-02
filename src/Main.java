public class Main {
    public static void main(String[] args) {
        Polynomial p1 = new Polynomial(1.1, 5.5, 4.4);
        Polynomial p2 = new Polynomial(1.6, 2.5, 3.4, 4.7, 1.3);

        Polynomial p3 = new Polynomial("poly.txt");

        System.out.println("p1 degree: " + p1.getDegree());
        System.out.println("p2 degree: " + p2.getDegree());
        System.out.println("p3 degree: " + p3.getDegree());

        System.out.println("p1: " + p1);
        System.out.println("p2: " + p2);
        System.out.println("p3: " + p3);

        System.out.println("p1(10): " + p1.evaluate(10));
        System.out.println("p2(10): " + p2.evaluate(10));
        System.out.println("p3(10): " + p3.evaluate(10));

        Polynomial p4 = p1.add(p2);
        System.out.println("p1+p2: " + p4);

        Polynomial p5 = p1.multiply(p2);
        System.out.println("p1*p2: " + p5);

    }
}