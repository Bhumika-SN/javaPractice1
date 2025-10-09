import java.util.Scanner; // Import the Scanner class to read user input

public class StudentGradeCalculator {

    // Method to determine the letter grade based on the average
    public static char getLetterGrade(double average) {
        if (average >= 90) {
            return 'A';
        } else if (average >= 80) {
            return 'B';
        } else if (average >= 70) {
            return 'C';
        } else if (average >= 60) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in); // Create a Scanner object

        System.out.print("Enter the number of grades (1-5): ");
        int numberOfGrades = scanner.nextInt(); // Read the number of grades

        // Input validation for the number of grades
        if (numberOfGrades < 1 || numberOfGrades > 5) {
            System.out.println("Invalid number of grades. Please enter a value between 1 and 5.");
            scanner.close(); // Close the scanner to prevent resource leaks
            return; // Exit the program
        }

        double sumOfGrades = 0; // Initialize a variable to store the sum of grades

        // Loop to get individual grades from the user
        for (int i = 1; i <= numberOfGrades; i++) {
            System.out.print("Enter grade " + i + ": ");
            double grade = scanner.nextDouble(); // Read each grade
            sumOfGrades += grade; // Add the grade to the sum
        }

        double averageGrade = sumOfGrades / numberOfGrades; // Calculate the average
        char letterGrade = getLetterGrade(averageGrade); // Get the letter grade

        System.out.println("Average Grade: " + averageGrade);
        System.out.println("Letter Grade: " + letterGrade);

        scanner.close(); // Close the scanner
    }
}