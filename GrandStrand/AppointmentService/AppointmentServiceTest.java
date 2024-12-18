// Test ObjectManagement
package AppointmentService;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

class AppointmentServiceTest {
    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    @Test
    void testAddAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("10068", futureDate, "CheckIn");
        appointmentService.addAppointment(appointment);
        assertEquals(appointment, appointmentService.getAppointment("10068"));
    }

    @Test
    void testAddDuplicateAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("10068", futureDate, "CheckIn");
        appointmentService.addAppointment(appointment);
        assertThrows(IllegalArgumentException.class, () -> appointmentService.addAppointment(appointment));
    }

    @Test
    void testDeleteAppointment() {
        Date futureDate = new Date(System.currentTimeMillis() + 100000);
        Appointment appointment = new Appointment("10068", futureDate, "CheckIn");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("10068");
        assertNull(appointmentService.getAppointment("10068"));
    }

    @Test
    void testDeleteNonExistentAppointment() {
        assertThrows(IllegalArgumentException.class, () -> appointmentService.deleteAppointment("94715"));
    }
}
