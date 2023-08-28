package abstract_example;

public class Test {
    public static void main(String[] args) {
                Animal a= new Animal() {
                    @Override
                    public void cry() {
                        System.out.println("miao");
                    }
                };
                a.cry();
    }
}

