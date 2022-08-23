package lesson6;

import java.util.Arrays;

public class FunctionForTesting {

    public static int[] method1(int[] in) {
        if (in == null)
            return null;

        int indexOfLast4 = 0;
        for (int i = 0; i < in.length; i++)
            if (in[i] == 4)
                indexOfLast4 = i;
        if (in[indexOfLast4] != 4)
            throw new RuntimeException();

        return Arrays.copyOfRange(in, indexOfLast4 + 1, in.length);
    }

    public static boolean method2(int[] in) {
        if (in == null)
            return false;

        boolean found1 = false, found4 = false;
        for (int elem : in) {
            if (elem == 1) found1 = true;
            else if (elem == 4) found4 = true;
        }

        return (found1 & found4);
    }
}
