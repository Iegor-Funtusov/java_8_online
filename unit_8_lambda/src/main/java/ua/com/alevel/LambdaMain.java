package ua.com.alevel;

public class LambdaMain {

    public static void main(String[] args) {
        Anonim anonim1 = new AnonimImpl();
        System.out.println(anonim1.sum(10,4));

        Anonim anonim2 = new Anonim() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };
        System.out.println(anonim2.sum(10,4));

        Anonim anonim3 = (a, b) -> a + b;
        System.out.println(anonim3.sum(10,4));


        Console console1 = new Console() {
            @Override
            public void print(String s) {
                System.out.println("s = " + s);
            }
        };

        Console console2 = (s) -> System.out.println("s = " + s);

        console1.print("Hello");
        console2.print("Hello");

        MathAnonim mathAnonim1 = new MathAnonim() {
            @Override
            public Anonim getAnonim() {
                return new Anonim() {
                    @Override
                    public int sum(int a, int b) {
                        return a + b;
                    }
                };
            }
        };

        System.out.println("mathAnonim = " + mathAnonim1.getAnonim().sum(10, 4));

        MathAnonim mathAnonim2 = () -> (a, b) -> a + b;

        System.out.println("mathAnonim2 = " + mathAnonim2.getAnonim().sum(10, 4));

        ConsoleWrap consoleWrap1 = new ConsoleWrap() {
            @Override
            public void print(Console c, String s) {
                c.print(s);
            }
        };

        ConsoleWrap consoleWrap2 = (c, s) -> c.print(s);
        consoleWrap2.print((s) -> System.out.println("s = " + s), "Bla Bla");

        System.out.println();

        LinkMethodTest linkMethodTest = new LinkMethodTest();
        linkMethodTest.test();
    }
}
