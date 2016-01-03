package nl.ap.hillclimbing;

public class Queens {

    public static boolean isConsistent(int[] queens, int number) {
        for (int i = 0; i < number; i++) {
            if (queens[i] == queens[number]) {
                return false; // same column
            }

            if ((queens[i] - queens[number]) == (number - i)) {
                return false; // same major diagonal
            }

            if ((queens[number] - queens[i]) == (number - i)) {
                return false; // same minor diagonal
            }
        }

        return true;
    }

    public static void printQueens(int[] q) {
        int length = q.length;

        for (int i = 0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (q[i] == j) {
                    System.out.print("Q  ");
                } else {
                    System.out.print("*  ");
                }
            }

            System.out.println();
        }

        System.out.println();
    }

    public static void calculate(int length) {
        int[] a = new int[length];

        calculate(a, 0);
    }

    public static boolean calculate(int[] queens, int number) {
        int length = queens.length;

        if (number == length) {
            printQueens(queens);

            return true;
        } else {
            for (int i = 0; i < length; i++) {
                queens[number] = i;

                if (isConsistent(queens, number)) {
                    if (calculate(queens, number + 1)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }


    public static void main(String[] args) {
//        calculate(new int[]{0, 0, 0, 0, 0, 0, 0, 0}, 0);
//
//        calculate(new int[]{5, 0, 0, 0, 0, 0, 0, 0}, 1);
//
//        calculate(new int[]{5, 3, 0, 0, 0, 0, 0, 0}, 2);
//
//        calculate(new int[]{5, 3, 0, 0, 0, 0, 0, 0, 5, 3, 0, 0, 0, 0, 0, 0}, 0);
//
//        calculate(new int[]{5, 3, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0}, 0);
//
//        calculate(new int[]{0, 0, 0, 0, 0, 0}, 0);
//
//        calculate(new int[]{0, 0, 0, 0}, 0);
//
//        calculate(new int[]{0}, 0);

        calculate(1);

        calculate(8);
    }

}
