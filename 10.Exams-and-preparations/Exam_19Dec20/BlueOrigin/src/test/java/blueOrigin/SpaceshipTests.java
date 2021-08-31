package blueOrigin;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class SpaceshipTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Spaceship
    private Spaceship spaceship;
    private Astronaut astronaut;

    @Before
    public void setUp() {
        spaceship = new Spaceship("Ship", 10);
        astronaut = new Astronaut("astronaut", 80);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSetZeroCapacity () {
        new Spaceship("TestShip", -1);
    }

    @Test (expected = NullPointerException.class)
    public void testSetNullName () {
        new Spaceship(null, 0);
    }

    @Test
    public void testAstroGetName() {
        assertEquals("astronaut", astronaut.getName());
    }
    @Test
    public void testAstroGetOxygen() {
        assertTrue(astronaut.getOxygenInPercentage() == 80);
    }

    @Test
    public void testShipGetCount() {
        spaceship.add(astronaut);
        assertEquals(1, spaceship.getCount());
    }

    @Test
    public void testShipGetCapacity() {
        assertEquals(10, spaceship.getCapacity());
    }

    @Test
    public void testGetShipName() {
        assertEquals("Ship", spaceship.getName());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShipAddDuplicate() {
        spaceship.add(astronaut);
        spaceship.add(astronaut);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testShipAddOverCapacity() {
        addAstronauts();
        spaceship.add(astronaut);
    }

    @Test
    public void testRemoveNullEntry() {
        boolean removed = spaceship.remove("astro");
        assertFalse(removed);
    }

    @Test
    public void testRemoveEntrySuccessfully() {
        spaceship.add(astronaut);
        boolean removed = spaceship.remove(astronaut.getName());
        assertTrue(removed);
    }

    private void addAstronauts() {
        for (int i = 1; i <= 10; i++) {
            Astronaut astronaut = new Astronaut("Astro-"+i, 50+i);
            spaceship.add(astronaut);
        }
    }
}
