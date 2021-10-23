import nl.jqno.equalsverifier.EqualsVerifier;

import static org.junit.Assert.*;

public class StudentTest {

    @org.junit.Test
    public void testEquals() {
        EqualsVerifier.simple().forClass(Student.class).verify();
    }
}