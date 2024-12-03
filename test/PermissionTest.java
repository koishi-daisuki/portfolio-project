import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

/**
 * PermissionTest.java test cases for permission
 */
public class PermissionTest {

    /**
     * test constructor.
     */
    @Test
    public void testConstructor1() {
        Permission p = new Permission1("name", "description");
        assertEquals("name", p.getName());
        assertEquals("name:\ndescription", p.getDescription());
    }

    /**
     * test constructor with description that starts with name.
     */
    @Test
    public void testConstructor2() {
        Permission p = new Permission1("name", "name:\ndescription");
        assertEquals("name", p.getName());
        assertEquals("name:\ndescription", p.getDescription());
    }

    /**
     * test setName method.
     */
    @Test
    public void testSetName() {
        Permission p = new Permission1("name", "description");
        assertTrue(p.setName("newName"));
        assertEquals("newName", p.getName());
        assertEquals("newName:\ndescription", p.getDescription());
    }

    /**
     * Test getId method.
     */
    @Test
    public void testGetId() {
        Permission p = new Permission1("name", "description");
        Permission p2 = new Permission1("Name", "description");
        assertEquals(p.getId(), p.getId());
        assertNotEquals(p.getId(), p2.getId());
    }

    /**
     * test getName method.
     */
    @Test
    public void testGetName() {
        String name = "name";
        Permission p = new Permission1(name, "description");
        assertEquals(name, p.getName());
    }

    /**
     * test getDesciption method.
     */
    @Test
    public void testGetDescription1() {
        String name = "name";
        String description = "description";
        Permission p = new Permission1(name, description);
        assertEquals(name + ":\n" + description, p.getDescription());
    }

    /**
     * test getDesciption method with description that is starts with name.
     */
    @Test
    public void testGetDescription2() {
        String name = "name";
        String description = name + ":\ndescription";
        Permission p = new Permission1(name, description);
        assertEquals(description, p.getDescription());
    }

    /**
     * Test setDescription method.
     */
    @Test
    public void testSetDescriptionFalse() {
        Permission p = new Permission1("name", "description");
        assertFalse(p.setDescription("newDescription"));
        assertEquals("name:\ndescription", p.getDescription());
    }

    /**
     * Test setDescription method with description that starts with name.
     */
    @Test
    public void testSetDescriptionTrue() {
        Permission p = new Permission1("name", "description");
        assertTrue(p.setDescription("name:\nnewDescription"));
        assertEquals("name:\nnewDescription", p.getDescription());
    }

    /**
     * Test checkUniqueness method true.
     */
    @Test
    public void testCheckUniquenessTrue() {
        Permission1.addToSet("name");
        assertTrue(Permission1.checkUniqueness("newName"));
    }

    /**
     * Test checkUniqueness method false.
     */
    @Test
    public void testCheckUniquenessFalse() {
        Permission1.addToSet("name");
        assertFalse(Permission1.checkUniqueness("name"));
    }

    /**
     * Test removeFromSet method.
     */
    @Test
    public void testRemoveFromSet() {
        Permission1.addToSet("name");
        assertTrue(Permission1.removeFromSet("name"));
        assertFalse(Permission1.removeFromSet("name"));
    }

    /**
     * Test addToSet method.
     */
    @Test
    public void testAddToSet() {
        assertTrue(Permission1.addToSet("name"));
        assertFalse(Permission1.addToSet("name"));
        assertTrue(Permission1.removeFromSet("name"));
    }

    /**
     * Test toString method1.
     */
    @Test
    public void testToString1() {
        Permission p = new Permission1("name", "description");
        String id = p.getId();
        assertEquals(
                "Permission1 [id=" + id
                        + ", name=name, description=name:\ndescription]",
                p.toString());
    }

    /**
     * Test toString method 2.
     */
    @Test
    public void testToString2() {
        Permission p = new Permission1("name", "name:\ndescription");
        String id = p.getId();
        assertEquals(
                "Permission1 [id=" + id
                        + ", name=name, description=name:\ndescription]",
                p.toString());
    }

    /**
     * Test equals method true.
     */
    @Test
    public void testEqualsTrue() {
        Permission p1 = new Permission1("name", "description");
        Permission p2 = p1.newInstance();
        assertTrue(p1.equals(p2));
    }

    /**
     * Test equals method false.
     */
    @Test
    public void testEqualsFalse() {
        Permission p1 = new Permission1("name", "description");
        Permission p2 = new Permission1("Name", "description");
        assertFalse(p1.equals(p2));
    }

    /**
     * Test HashCode method.
     */
    @Test
    public void testHashCode() {
        Permission p = new Permission1("name", "description");
        assertEquals(p.getId().hashCode(), p.hashCode());
    }

    /**
     * Test newInstance method.
     */
    @Test
    public void testNewInstance() {
        Permission p1 = new Permission1("name", "description");
        Permission p2 = p1.newInstance();
        assertTrue(p1.equals(p2));
    }

    /**
     * Test transferForm method.
     */
    @Test
    public void testTransferFrom() {
        Permission p1 = new Permission1("name", "description");
        Permission p2 = new Permission1("Name", "description");
        Permission p3 = p1.newInstance();
        p3.transferFrom(p2);
        assertFalse(p1.equals(p3));
        assertEquals(p2.getDescription(), "default:\ndefault");
        assertEquals(p2.getName(), "default");
    }

    /**
     * Test clear method.
     */
    @Test
    public void testClear() {
        Permission p = new Permission1("name", "description");
        String id = p.getId();
        p.clear();
        assertEquals(p.getDescription(), "default:\ndefault");
        assertEquals(p.getName(), "default");
        assertEquals(p.getId(), id);
    }
}
