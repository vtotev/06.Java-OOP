package aquarium;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class AquariumTests {
    //TODO: TEST ALL THE FUNCTIONALITY OF THE PROVIDED CLASS Aquarium
    public static Aquarium aquarium;

    @Before
    public void setUp() {
        aquarium = new Aquarium("Fishes", 10);
    }

    @Test
    public void testFishGetName() {
        Fish fish = new Fish("Nemo");
        assertNotNull(fish);
        assertEquals("Nemo", fish.getName());
    }

    @Test
    public void testFishSetAvailable() {
        Fish fish = new Fish("Nemo");
        assertNotNull(fish);
        fish.setAvailable(false);
        assertFalse(fish.isAvailable());
    }

    @Test
    public void testFishIsAvailable() {
        Fish fish = new Fish("Nemo");
        assertNotNull(fish);
        assertTrue(fish.isAvailable());
    }

    @Test (expected = NullPointerException.class)
    public void testAquariumSetNameNullException(){
        Aquarium newAq = new Aquarium(null, 5);
    }

    @Test (expected = NullPointerException.class)
    public void testAquariumSetNameEmptyException(){
        Aquarium newAq = new Aquarium("", 5);
    }

    @Test (expected = NullPointerException.class)
    public void testAquariumSetNameSpacesException(){
        Aquarium newAq = new Aquarium("     ", 5);
    }

    @Test
    public void testGetName() {
        assertNotNull(aquarium);
        assertEquals("Fishes", aquarium.getName());
    }


    @Test (expected = IllegalArgumentException.class)
    public void testAquariumSetCapacityException(){
        Aquarium newAq = new Aquarium("Fishtank", -1);
    }

    @Test
    public void testAquariumSetCapacityZeroException(){
        Aquarium newAq = new Aquarium("Fishtank", 0);
        assertNotNull(newAq);
        assertEquals(0, newAq.getCapacity());
    }


    @Test
    public void testGetCapacity() {
        assertNotNull(aquarium);
        assertEquals(10, aquarium.getCapacity());
    }

    @Test
    public void testAddFishes() {
        addFishes();
        assertNotNull(aquarium);
        assertEquals(10, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddFishesMoreThanCapacity() {
        addFishes();
        assertNotNull(aquarium);
        aquarium.add(new Fish("Fishy"));
    }

    @Test
    public void testGetCount() {
        addFishes();
        assertNotNull(aquarium);
        assertEquals(10, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveFishNullException() {
        aquarium.remove("fishy2");
    }

    @Test
    public void testRemoveFish() {
        addFishes();
        aquarium.remove("fishNum2");
        assertNotNull(aquarium);
        assertEquals(9, aquarium.getCount());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testSellFishNullException() {
        aquarium.sellFish("fishy2");
    }

    @Test
    public void testSellFish() {
        addFishes();
        Fish soldFish = aquarium.sellFish("fishNum2");
        assertNotNull(aquarium);
        assertNotNull(soldFish);
        assertEquals("fishNum2", soldFish.getName());
        assertFalse (soldFish.isAvailable());
    }

    @Test
    public void testReport() {
        aquarium.add(new Fish("Nemo"));
        assertNotNull(aquarium);
        assertEquals("Fish available at Fishes: Nemo", aquarium.report());
    }

    @Test
    public void testReportTwoFishes() {
        aquarium.add(new Fish("Nemo"));
        aquarium.add(new Fish("Dory"));
        assertNotNull(aquarium);
        assertEquals("Fish available at Fishes: Nemo, Dory", aquarium.report());
    }

    private void addFishes() {
        for (int i = 0; i < 10; i++) {
            aquarium.add(new Fish("fishNum"+i));
        }
    }
}

