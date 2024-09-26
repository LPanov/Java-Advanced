package Generics.Lab.JarOfT;

public class Main {
    public static void main(String[] args) {
        Jar<String> jar = new Jar<>();
        jar.add("PickleOne");
        jar.add("PickleTwo");
        jar.add("PickleThree");

        System.out.println(jar.remove());
    }
}
