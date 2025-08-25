package HMS;

import java.util.Scanner;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

public class Admindashboard {
    private Patient[] patients = new Patient[100];
    private Doctor[] doctors = new Doctor[50];
    private Appointment[] appointments = new Appointment[200];

    private int patientCount = 0, doctorCount = 0, appointmentCount = 0;

    Scanner sc = new Scanner(System.in);

    public void start() {
        preloadData(); // Load sample data
        if (!adminLogin()) return;

        int choice;
        do {
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("\n--------------------------------------------------------------------------------------------------------------------------------------------------------------");
            System.out.println("--- Hospital Management Dashboard ---");
            System.out.println("1. Add Patient");
            System.out.println("2. Add Doctor");
            System.out.println("3. View Patients");
            System.out.println("4. View Doctors");
            System.out.println("5. Book Appointment (Auto Match Doctor)");
            System.out.println("6. View Appointments");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();
            sc.nextLine(); // clear buffer

            

            switch (choice) {
                case 1 -> addPatient();
                case 2 -> addDoctor();
                case 3 -> viewPatients();
                case 4 -> viewDoctors();
                case 5 -> bookAppointment();
                case 6 -> viewAppointments();
                case 7 -> System.out.println("Thank you for using the system.");
                default -> System.out.println("Invalid choice.");
            }

            System.out.println("\n----------------------------------------\n");

        } while (choice != 7);
    }

    private boolean adminLogin() {
        System.out.println("==== Admin Login ====");
        System.out.print("Username: ");
        String username = sc.nextLine().trim();
        System.out.print("Password: ");
        String password = sc.nextLine().trim();
        System.out.println("\nWelcome, " + username + "! Login successful.\n");
        return true;
    }

    private void preloadData() {
        // Preloaded Patients
        patients[patientCount++] = new Patient("Anika Sharma", 25, "Fever");
        patients[patientCount++] = new Patient("Rahul Mehta", 30, "Cough");
        patients[patientCount++] = new Patient("Priya Kumar", 20, "Infection");

        // Preloaded Doctors
        doctors[doctorCount++] = new Doctor("Dr. Ramesh B", 45, "Fever Specialist");
        doctors[doctorCount++] = new Doctor("Dr. Neha Verma", 38, "Pediatrician");
        doctors[doctorCount++] = new Doctor("Dr. Suresh K", 50, "Skin & Infection");
    }

    private void addPatient() {
        System.out.print("Enter Patient Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        patients[patientCount++] = new Patient(name, age, disease);
        System.out.println("\n✅ Patient added successfully.");
    }

    private void addDoctor() {
        System.out.print("Enter Doctor Name: ");
        String name = sc.nextLine();
        System.out.print("Enter Age: ");
        int age = sc.nextInt(); sc.nextLine();
        System.out.print("Enter Specialization: ");
        String specialization = sc.nextLine();

        doctors[doctorCount++] = new Doctor(name, age, specialization);
        System.out.println("\n✅ Doctor added successfully.");
    }

    private void viewPatients() {
        if (patientCount == 0) {
            System.out.println("No patients found.");
            return;
        }
        System.out.println("--- List of Patients ---");
        for (int i = 0; i < patientCount; i++) {
            System.out.println("Patient #" + (i + 1));
            patients[i].displayInfo();
            System.out.println();
        }
    }

    private void viewDoctors() {
        if (doctorCount == 0) {
            System.out.println("No doctors found.");
            return;
        }
        System.out.println("--- List of Doctors ---");
        for (int i = 0; i < doctorCount; i++) {
            System.out.println("Doctor #" + (i + 1));
            doctors[i].displayInfo();
            System.out.println();
        }
    }

    private void bookAppointment() {
        if (doctorCount == 0) {
            System.out.println("No doctors available. Please add doctors first.");
            return;
        }

        System.out.print("Enter Patient Name: ");
        String patientName = sc.nextLine();
        System.out.print("Enter Disease: ");
        String disease = sc.nextLine();

        // Auto-add patient with unknown age
        patients[patientCount++] = new Patient(patientName, 0, disease);

        // Find matching doctors
        Doctor[] matchedDoctors = new Doctor[doctorCount];
        int matchCount = 0;
        for (int i = 0; i < doctorCount; i++) {
            if (doctors[i].getSpecialization().toLowerCase().contains(disease.toLowerCase())) {
                matchedDoctors[matchCount++] = doctors[i];
            }
        }

        if (matchCount == 0) {
            System.out.println("❌ No doctor found for disease: " + disease);
            return;
        }

        System.out.println("\nAvailable Doctors for \"" + disease + "\":");
        for (int i = 0; i < matchCount; i++) {
            System.out.println((i + 1) + ". " + matchedDoctors[i].getName() + " (" + matchedDoctors[i].getSpecialization() + ")");
        }

        System.out.print("Select Doctor (number): ");
        int dIndex = sc.nextInt() - 1;
        sc.nextLine(); // clear buffer

        // Read date in proper format
        LocalDateTime dateTime = null;
        boolean valid = false;
        while (!valid) {
            System.out.print("Enter Appointment Date and Time (dd-MM-yyyy HH:mm): ");
            String input = sc.nextLine();
            try {
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
                dateTime = LocalDateTime.parse(input, formatter);
                valid = true;
            } catch (DateTimeParseException e) {
                System.out.println("⚠ Invalid format! Please try again.");
            }
        }

        appointments[appointmentCount++] = new Appointment(patientName, matchedDoctors[dIndex].getName(), dateTime);
        System.out.println("\n✅ Appointment booked successfully.");
    }

    private void viewAppointments() {
        if (appointmentCount == 0) {
            System.out.println("No appointments booked.");
            return;
        }
        System.out.println("--- Appointments ---");
        for (int i = 0; i < appointmentCount; i++) {
            appointments[i].displayAppointment();
            System.out.println();
        }
    }
}
