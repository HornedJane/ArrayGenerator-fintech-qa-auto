import java.util.Arrays;
import java.util.Scanner;

public class Main {

    private static final int DEFAULT_ARRAY_SIZE = 10;

    public static void main(final String[] args) {
        int modifier;
        int[] array1;
        int[] array2;
        int[] array3;
        int[] array4;
        int[] array5;

        modifier = getModifier();

        array1 = getFilledArray(DEFAULT_ARRAY_SIZE, modifier, Integer::sum);
        System.out.println(Arrays.toString(array1));

        array2 = getFilledArray(DEFAULT_ARRAY_SIZE, modifier, (m, i) -> m * i);
        System.out.println(Arrays.toString(array2));

        array3 = getFilledArray(DEFAULT_ARRAY_SIZE, modifier, (m, i) -> {
            if (i % 2 == 0) {
                return i / 2 + m;
            } else {
                return i * i - m;
            }
        });
        System.out.println(Arrays.toString(array3));

        //Число = 1, если индекс делиться нацело на модификатор, 0, если нет.
        array4 = getFilledArray(DEFAULT_ARRAY_SIZE, modifier, (m, i) -> {
            if (m == 0 || !(i % m == 0)) {
                return 0;
            } else {
                return 1;
            }
        });
        System.out.println(Arrays.toString(array4));

        //Число = модификатор в степени индекса.
        array5 = getFilledArray(DEFAULT_ARRAY_SIZE, modifier, (m, i) -> {
            int result = 1;
            for (int j = 0; j < i; j++) {
                result = result * m;
            }
            return result;
        });
        System.out.println(Arrays.toString(array5));
    }

    public static int[] getFilledArray(final int size, final int modifier, final Generator generator) {
        int[] filledArray = new int[size];

        for (int i = 0; i < filledArray.length; i++) {
            filledArray[i] = generator.process(modifier, i);
        }
        return filledArray;
    }

    public static int getModifier() {
        Scanner in = new Scanner(System.in);
        System.out.println("Input number");
        int result = in.nextInt();
        in.close();
        return result;
    }
}
