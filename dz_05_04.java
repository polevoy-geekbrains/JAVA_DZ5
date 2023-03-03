import java.util.Arrays;

public class dz_05_04 {
            public static Integer[][] field = new Integer[][]{
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0},
    };

    public static void main(String[] args) {
        searchSolution(4, 1, 0);
    }

    public static void searchSolution(int x, int y, int ferz) {
        if (!Arrays.deepToString(field).contains("0")) {
            return;
        }
        for (int i = x; i < 8; i++) {
            for (int j = y; j < 8; j++) {
                if (field[i][j] == 0) {
                    fillArray(i, j);
                    printFormatFiled(field);
                    ferz++;
                }
            }
        }
        System.out.println("\n\n" + " ФЕРЗЕЙ НА ДОСКЕ -> " + ferz);
        searchSolution(0, 0, ferz);
    }

    public static void fillArray(Integer x, Integer y) {
        field[x][y] = 8;
        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field.length; j++) {
                if (field[i][y] == 0) field[i][y] = 1;
                if (field[x][j] == 0) field[x][j] = 1;
                if (i - x == j - y && field[i][j] == 0) field[i][j] = 1;
                if (i == y - j + x && field[i][j] == 0) field[i][j] = 1;

            }
        }
    }

    public static void printFormatFiled(Integer[][] field) {
        System.out.println();
        for (Integer[] integers : field) {
            System.out.println();
            for (int j = 0; j < field.length; j++) {
                if (integers[j] == 1) System.out.print("x" + "  ");
                else if (integers[j] == 8) System.out.print("O" + "  ");
                else System.out.print("." + "  ");
            }
        }
    }
}