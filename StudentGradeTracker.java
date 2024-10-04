import java.util.ArrayList;
import java.util.Scanner;

public class StudentGradeTracker {

    public static void main(String[] args) {
        ArrayList<Double> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Student Grade Tracker!");
        System.out.println("Enter student grades one by one. Type 'done' when you are finished.");

        // Input loop
        while (true) {
            System.out.print("Enter a student's grade (0-100) or 'done': ");
            String input = scanner.nextLine().trim();

            if (input.equalsIgnoreCase("done")) {
                break;
            }
            try {
                double grade = Double.parseDouble(input);
                if (grade >= 0 && grade <= 100) {
                    grades.add(grade);
                } else {
                    System.out.println("Please enter a grade between 0 and 100.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a numeric grade.");
            }
        }

        // Calculate and display results
        if (grades.size() > 0) {
            double average = calculateAverage(grades);
            double highest = calculateHighest(grades);
            double lowest = calculateLowest(grades);

            System.out.printf("\nAverage grade: %.2f%n",average);
            System.out.printf("Highest grade: %.2f%n", highest);
            System.out.printf("Lowest grade: %.2f%n", lowest);
        } else {
            System.out.println("No grades were entered.");
        }

        scanner.close();
    }

    private static double calculateAverage(ArrayList<Double> grades) {
        double total = 0;
        for (double grade : grades) {
            total += grade;
        }
        return total / grades.size();
    }

    private static double calculateHighest(ArrayList<Double> grades) {
        double highest = grades.get(0);
        for (double grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    private static double calculateLowest(ArrayList<Double> grades) {
        double lowest = grades.get(0);
        for (double grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
