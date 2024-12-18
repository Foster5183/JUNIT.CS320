//Object Test
package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskTest {

    @Test
    public void testTaskCreationSuccess() {
        Task task = new Task("12345", "Test Task", "This is a test description.");
        assertEquals("12345", task.getTaskId());
        assertEquals("Test Task", task.getName());
        assertEquals("This is a test description.", task.getDescription());
    }

    @Test
    public void testTaskCreationInvalidId() {
        assertThrows(IllegalArgumentException.class, () -> new Task(null, "Name", "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345678901", "Name", "Description"));
    }

    @Test
    public void testTaskCreationInvalidName() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", null, "Description"));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "This name is way too long to be valid", "Description"));
    }

    @Test
    public void testTaskCreationInvalidDescription() {
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", null));
        assertThrows(IllegalArgumentException.class, () -> new Task("12345", "Name", "This description is way too long to be valid and exceeds fifty characters."));
    }

    @Test
    public void testSetters() {
        Task task = new Task("12345", "Task Name", "Task Description");
        task.setName("Updated Name");
        task.setDescription("Updated Description");
        assertEquals("Updated Name", task.getName());
        assertEquals("Updated Description", task.getDescription());
    }
}