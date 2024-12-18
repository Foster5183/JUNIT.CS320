package ContactService;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactServiceTest {

    @Test
    public void testAddContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        service.addContact(contact);
        assertEquals(contact, service.getContact("12345"));
    }

    @Test
    public void testDeleteContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        service.addContact(contact);
        service.deleteContact("12345");
        assertNull(service.getContact("12345"));
    }

    @Test
    public void testUpdateContact() {
        ContactService service = new ContactService();
        Contact contact = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        service.addContact(contact);

        // Update fields
        service.updateContact("12345", "Cook", "Monster2", "0987654321", "456 Oak Avenue");
        Contact updatedContact = service.getContact("12345");

        // Assert updated fields
        assertEquals("Cook", updatedContact.getFirstName());
        assertEquals("Monster2", updatedContact.getLastName());
        assertEquals("0987654321", updatedContact.getPhone());
        assertEquals("456 Oak Avenue", updatedContact.getAddress());
    }

    @Test
    public void testAddDuplicateContactId() {
        ContactService service = new ContactService();
        Contact contact1 = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        Contact contact2 = new Contact("12345", "Cook", "Monster", "0987654321", "456 Oak Avenue");
        service.addContact(contact1);

        // Adding a contact with the same ID should throw an exception
        assertThrows(IllegalArgumentException.class, () -> service.addContact(contact2));
    }

    @Test
    public void testDeleteNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, () -> service.deleteContact("12345"));
    }

    @Test
    public void testUpdateNonexistentContact() {
        ContactService service = new ContactService();
        assertThrows(IllegalArgumentException.class, 
            () -> service.updateContact("12345", "Cook", "Monster", "0987654321", "456 Oak Avenue"));
    }
}
