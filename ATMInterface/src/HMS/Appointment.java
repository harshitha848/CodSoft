package HMS;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private String patientName;
    private String doctorName;
    private LocalDateTime dateTime;

    public Appointment(String patientName, String doctorName, LocalDateTime dateTime) {
        this.patientName = patientName;
        this.doctorName = doctorName;
        this.dateTime = dateTime;
    }

    public void displayAppointment() {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm");
        System.out.println("Patient: " + patientName);
        System.out.println("Doctor: " + doctorName);
        System.out.println("Date & Time: " + dateTime.format(formatter));
    }
}
