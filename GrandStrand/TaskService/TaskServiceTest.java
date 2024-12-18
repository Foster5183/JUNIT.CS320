//Object Management Testing
package TaskService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class TaskServiceTest {

    @Test
    public void testAddTaskSuccess() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        service.addTask(task);
        assertEquals(task, service.getTask("12345"));
    }

    @Test
    public void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("12345", "Test Task 1", "Description 1");
        Task task2 = new Task("12345", "Test Task 2", "Description 2");
        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> service.addTask(task2));
    }

    @Test
    public void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        service.addTask(task);
        service.deleteTask("12345");
        assertNull(service.getTask("12345"));
    }

    @Test
    public void testDeleteTaskNotFound() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteTask("12345"));
    }

    @Test
    public void testUpdateTaskName() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        service.addTask(task);
        service.updateTaskName("12345", "Updated Task Name");
        assertEquals("Updated Task Name", service.getTask("12345").getName());
    }

    @Test
    public void testUpdateTaskDescription() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Test Task", "This is a test description.");
        service.addTask(task);
        service.updateTaskDescription("12345", "Updated Description");
        assertEquals("Updated Description", service.getTask("12345").getDescription());
    }

    @Test
    public void testUpdateTaskNotFound() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskName("12345", "Name"));
        assertThrows(IllegalArgumentException.class, () -> service.updateTaskDescription("12345", "Description"));
    }
}