package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class StudentGradeCalculator {
    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("***********************************");
        System.out.println("*     STUDENT GRADE CALCULATOR    *");
        System.out.println("***********************************\n");
        System.out.print("Enter number of students: ");
        int numStudents = sc.nextInt();
        System.out.print("Enter number of subjects: ");
        int numSubjects = sc.nextInt();String[] studentNames = new String[numStudents];
        int[][] marks = new int[numStudents][numSubjects];
        int[] totals = new int[numStudents];
        double[] percentages = new double[numStudents];
        String[] grades = new String[numStudents];
        String[] remarks = new String[numStudents];

        for (int i = 0; i < numStudents; i++) {
            sc.nextLine(); 
            System.out.print("\nEnter name of student " + (i + 1) + ": ");
            studentNames[i] = sc.nextLine();

            int total = 0;
            for (int j = 0; j < numSubjects; j++) {
                int mark;
                while (true) {
                    System.out.print("Enter marks for subject " + (j + 1) + " (0-100): ");
                    mark = sc.nextInt();
                    if (mark >= 0 && mark <= 100) break;
                    else System.out.println(RED + "Invalid input! Marks must be 0-100." + RESET);
                }
                marks[i][j] = mark;
                total += mark;
            }

            totals[i] = total;
            percentages[i] = (double) total / numSubjects;
            if (percentages[i] >= 90) grades[i] = "A+";
            else if (percentages[i] >= 80) grades[i] = "A";
            else if (percentages[i] >= 70) grades[i] = "B";
            else if (percentages[i] >= 60) grades[i] = "C";
            else if (percentages[i] >= 50) grades[i] = "D";
            else grades[i] = "F";

            if (percentages[i] >= 90) remarks[i] = "Excellent!";
            else if (percentages[i] >= 75) remarks[i] = "Very Good";
            else if (percentages[i] >= 60) remarks[i] = "Good";
            else if (percentages[i] >= 50) remarks[i] = "Average";
            else remarks[i] = "Needs Improvement";
        }

        System.out.println("\n=== INDIVIDUAL RESULTS ===");
        for (int i = 0; i < numStudents; i++) {
            System.out.println("\n------------------------------");
            System.out.println(BLUE + "Student: " + studentNames[i] + RESET);
            System.out.println("Total Marks: " + totals[i]);
            System.out.printf("Percentage: %.2f%%\n", percentages[i]);

            if (grades[i].equals("A+") || grades[i].equals("A")) 
            	System.out.println(GREEN + "Grade: " + grades[i] + RESET);
            else if (grades[i].equals("B") || grades[i].equals("C"))
            	System.out.println(YELLOW + "Grade: " + grades[i] + RESET);
            else 
            	System.out.println(RED + "Grade: " + grades[i] + RESET);

            System.out.println("Remarks: " + remarks[i]);
        }
        int highestTotal = totals[0], lowestTotal = totals[0];
        for (int t : totals) {
            if (t > highestTotal) highestTotal = t;
            if (t < lowestTotal) lowestTotal = t;
        }
        double classAverage = 0;
        for (double p : percentages) classAverage += p;
        classAverage /= numStudents;

        System.out.println("\n=== CLASS STATISTICS ===");
        System.out.println("Highest Total Marks: " + highestTotal);
        System.out.println("Lowest Total Marks: " + lowestTotal);
        System.out.printf("Class Average Percentage: %.2f%%\n", classAverage);
        System.out.println("\n=== SUMMARY TABLE ===");
        System.out.printf("%-15s %-10s %-10s %-8s %-20s\n", "Name", "Total", "Percent", "Grade", "Remarks");
        for (int i = 0; i < numStudents; i++) {
            System.out.printf("%-15s %-10d %-10.2f %-8s %-20s\n",
                    studentNames[i], totals[i], percentages[i], grades[i], remarks[i]);
        }
        try {
            FileWriter writer = new FileWriter("student_results.csv");
            writer.write("Student Name");
            for (int j = 1; j <= numSubjects; j++) writer.write(",Subject" + j);
            writer.write(",Total,Percentage,Grade,Remarks\n");

            for (int i = 0; i < numStudents; i++) {
                writer.write(studentNames[i]);
                for (int j = 0; j < numSubjects; j++) writer.write("," + marks[i][j]);
                writer.write("," + totals[i] + "," + String.format("%.2f", percentages[i]) + "," + grades[i] + "," + remarks[i] + "\n");
            }
            writer.close();
            System.out.println("\nResults saved to student_results.csv");
        } catch (IOException e) {
            System.out.println("Error writing to file: " + e.getMessage());
        }

        System.out.println("\nThank you for using Student Grade Calculator!");
        sc.close();
    }
}
