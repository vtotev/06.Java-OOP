package WorkingWithAbstraction;

import java.util.Arrays;
import java.util.Scanner;

public class JediGalaxy {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[][] matrix = readMatrix(getMatrixDimensions(scanner));

        long sum = getSum(scanner, matrix);

        System.out.println(sum);
    }

    private static long getSum(Scanner scanner, int[][] matrix) {
        long sum = 0;
        String command = scanner.nextLine();
        while (!command.equals("Let the Force be with you")) {
            int[] ivo = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
            int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int xE = evil[0];
            int yE = evil[1];

            while (xE >= 0 && yE >= 0) {
                if (xE >= 0 && xE < matrix.length && yE >= 0 && yE < matrix[0].length) {
                    matrix[xE][yE] = 0;
                }
                xE--;
                yE--;
            }

            int xI = ivo[0];
            int yI = ivo[1];

            while (xI >= 0 && yI < matrix[1].length) {
                if (xI >= 0 && xI < matrix.length && yI >= 0 && yI < matrix[0].length) {
                    sum += matrix[xI][yI];
                }

                yI++;
                xI--;
            }

            command = scanner.nextLine();
        }
        return sum;
    }

    private static int[][] readMatrix(int[] dimensions) {
        int[][] matrix = new int[dimensions[0]][dimensions[1]];
        int value = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                matrix[i][j] = value++;
            }
        }
        return matrix;
    }

    public static int[] getMatrixDimensions(Scanner scanner) {
        return Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
    }
}
