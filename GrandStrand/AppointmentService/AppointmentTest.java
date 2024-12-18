package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import java.util.Date;

class AppointmentTest {

    @Test
    void testValidAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000); // Future date
        Appointment appointment = new Appointment("10068", futureDate, "CheckIn");
        assertEquals("10068", appointment.getAppointmentId());
        assertEquals(futureDate, appointment.getAppointmentDate());
        assertEquals("CheckIn", appointment.getDescription());
    }

    @Test
    void testInvalidAppointmentId() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment(null, futureDate, "CheckIn"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("12345678901", futureDate, "CheckIn"));
    }

    @Test
    void testInvalidAppointmentDate() {
        Date pastDate = new Date(System.currentTimeMillis() - 100000); // Past date
        assertThrows(IllegalArgumentException.class, () -> new Appointment("10068", pastDate, "CheckIn"));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("10068", null, "CheckIn"));
    }

    @Test
    void testInvalidDescription() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        assertThrows(IllegalArgumentException.class, () -> new Appointment("10068", futureDate, null));
        assertThrows(IllegalArgumentException.class, () -> new Appointment("10068", futureDate, "X".repeat(51)));
    }
}