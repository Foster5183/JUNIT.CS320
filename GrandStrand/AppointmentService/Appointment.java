// Object Creation 
package AppointmentService;
import java.util.Date;

public class Appointment {
    private final String appId;
    private final Date appDate;
    private final String description;

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("Invalid appointment ID");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("Invalid appointment date");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid description");
        }
        this.appId = appointmentId;
        this.appDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appId;
    }

    public Date getAppointmentDate() {
        return appDate;
    }

    public String getDescription() {
        return description;
    }
}