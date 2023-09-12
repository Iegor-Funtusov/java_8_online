package ua.com.alevel;

public class LinkMethodTest {

    public void test() {
        int a = sum(4, 9);
        System.out.println("a = " + a);

        Anonim anonim = new Anonim() {
            @Override
            public int sum(int a, int b) {
                return a + b;
            }
        };

        Anonim anonim1 = (b1, b2) -> b1 + b2;
        System.out.println(anonim1.sum(4, 9));

        Anonim anonim2 = this::sum;
        System.out.println(anonim2.sum(4, 9));

        SumTest sumTest = new SumTest();
        Anonim anonim3 = sumTest::sum;
        System.out.println(anonim3.sum(4, 9));

        Anonim anonim4 = SumTest::staticSum;
        System.out.println(anonim4.sum(4, 9));

        Anonim anonim5 = Integer::sum;
        System.out.println(anonim5.sum(4, 9));
    }

    private int sum(int a, int b) {
        return a + b;
    }
}
