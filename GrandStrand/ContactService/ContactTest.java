package ContactService;


import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class ContactTest {

    // Test valid Contact creation
    @Test
    public void testValidContact() {
        Contact contact = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        assertEquals("12345", contact.getContactId());
        assertEquals("Cookie", contact.getFirstName());
        assertEquals("Monster", contact.getLastName());
        assertEquals("1234567890", contact.getPhone());
        assertEquals("123 Drury Lane", contact.getAddress());
    }

    // Test invalid Contact ID (null or longer than 10 characters)
    @Test
    public void testInvalidContactId() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact(null, "Cookie", "Monster", "1234567890", "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345678901", "Cookie", "Monster", "1234567890", "123 Drury Lane"));
    }

    // Test invalid first name (null or longer than 10 characters)
    @Test
    public void testInvalidFirstName() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", null, "Monster", "1234567890", "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookiemonster", "Monster", "1234567890", "123 Drury Lane"));
    }

    // Test invalid last name (null or longer than 10 characters)
    @Test
    public void testInvalidLastName() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", null, "1234567890", "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monsterrrrr", "1234567890", "123 Drury Lane"));
    }

    // Test invalid phone number (null or not exactly 10 digits)
    @Test
    public void testInvalidPhone() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", null, "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", "12345", "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", "12345678901", "123 Drury Lane"));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", "123456abcd", "123 Drury Lane"));
    }

    // Test invalid address (null or longer than 30 characters)
    @Test
    public void testInvalidAddress() {
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", "1234567890", null));
        assertThrows(IllegalArgumentException.class, 
            () -> new Contact("12345", "Cookie", "Monster", "1234567890", "This address is way too long to be valid!"));
    }

    // Test that fields cannot be updated outside of allowed setters
    @Test
    public void testImmutableContactId() {
        Contact contact = new Contact("12345", "Cookie", "Monster", "1234567890", "123 Drury Lane");
        assertThrows(IllegalAccessException.class, 
            () -> contact.getClass().getDeclaredField("contactId").set(contact, "67890"));
    }
}