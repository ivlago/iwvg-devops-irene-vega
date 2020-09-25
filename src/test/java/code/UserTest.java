package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

public class UserTest {
    private User user;

    @BeforeEach
    void before() {
        ArrayList<Fraction> fractions = new ArrayList<Fraction>();
        user = new User("id" ,"name", "familyName", fractions);
    }

    @Test
    void testUser() {
        assertEquals("id", user.getId());
        assertEquals("name", user.getName());
        assertEquals("familyName", user.getFamilyName());
        assertEquals(0, user.getFractions().size());
    }
    @Test
    void testFullName() {
        assertEquals("name familyName", user.fullName());
    }
    @Test
    void testInitials() {
        assertEquals("n.", user.initials());
    }
    @Test
    void testSets() {
        user.setName("Jamal");
        user.setFamilyName("Murray");
        assertEquals("Jamal", user.getName());
        assertEquals("Murray", user.getFamilyName());
    }
}
