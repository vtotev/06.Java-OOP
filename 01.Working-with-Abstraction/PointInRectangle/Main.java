package WorkingWithAbstraction.PointInRectangle;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int[] coordinates = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
        Rectangle rect = new Rectangle(new Point(coordinates[0], coordinates[1]),
                                       new Point(coordinates[2], coordinates[3]));
        int count = Integer.parseInt(scan.nextLine());
        for (int i = 0; i < count; i++) {
            int[] points = Arrays.stream(scan.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            System.out.println(rect.contains(points[0], points[1]));
        }
    }
}
