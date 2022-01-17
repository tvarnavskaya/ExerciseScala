public class JavaPlayground {
    public static void main(String[] args) {
        System.out.println("Hello, Java");
        System.out.println(Person.N_EYES);
        System.out.println(Person.test());
    }
}

class Person {
    public static final int N_EYES = 2;
    public static String test() {
        return "test";
    }
}
