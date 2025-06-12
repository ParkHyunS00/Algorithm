import java.util.HashMap;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String, Double> table = new HashMap<>(){{
            put("A+", 4.5);
            put("A0", 4.0);
            put("B+", 3.5);
            put("B0", 3.0);
            put("C+", 2.5);
            put("C0", 2.0);
            put("D+", 1.5);
            put("D0", 1.0);
            put("F", 0.0);
        }};

        double gradeSum = 0;
        double subjectSum = 0;
        for (int i=0; i<20; i++) {
            String[] gradeData = sc.nextLine().split(" ");
            if (!gradeData[2].equals("P") && table.containsKey(gradeData[2])) {
                gradeSum += Double.parseDouble(gradeData[1]);
                subjectSum += (Double.parseDouble(gradeData[1]) * table.get(gradeData[2]));
            }
        }

        System.out.print(subjectSum / gradeSum);
    }
}