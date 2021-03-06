package code;

import es.upm.miw.iwvg_devops.code.Fraction;
import es.upm.miw.iwvg_devops.code.User;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.jupiter.api.Assertions.assertEquals;

class UserTest {
    private User user;

    @BeforeEach
    void before() {
        ArrayList<Fraction> fractions = new ArrayList<>();
        user = new User("id", "name", "familyName", fractions);
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
    void testToString() {
        user.toString();
        assertEquals("id", user.getId());
        assertEquals("name", user.getName());
        assertEquals("familyName", user.getFamilyName());
    }

    @Test
    void testSets() {
        user.setName("Jamal");
        user.setFamilyName("Murray");
        assertEquals("Jamal", user.getName());
        assertEquals("Murray", user.getFamilyName());
    }

    @Test
    void findUserIdBySomeProperFraction() {
        assertEquals(List.of("1", "2", "3", "5"), user.findUserIdBySomeProperFraction().collect(Collectors.toList()));
    }

    @Test
    void findUserFamilyNameBySomeImproperFraction() {
        assertEquals(List.of("Fernandez", "Blanco", "López", "Blanco", "Torres"),
                user.findUserFamilyNameBySomeImproperFraction().collect(Collectors.toList()));
    }

    @Test
    void findUserIdByAllProperFraction() {
        assertEquals(List.of(),
                user.findUserIdByAllProperFraction().collect(Collectors.toList()));
    }

    @Test
    void findFractionSubtractionByUserName() {
        assertEquals(0, user.findFractionSubtractionByUserName("Paula").getNumerator());
        assertEquals(0, user.findFractionSubtractionByUserName("Paula").getDenominator());
        assertEquals(60, user.findFractionSubtractionByUserName("Ana").getDenominator());
    }
}
