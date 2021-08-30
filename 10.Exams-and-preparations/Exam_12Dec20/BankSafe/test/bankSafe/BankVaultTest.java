package bankSafe;


import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Map;

import static org.junit.Assert.*;

public class BankVaultTest {

    //TODO: Write your tests here
    private BankVault bankVault;
    @Before
    public void setUp() {
        bankVault = new BankVault();
    }

    @Test
    public void testBankExists() {
        assertNotNull(bankVault);
    }

    @Test
    public void testGetCells() {
        Map<String, Item> gettedItems = bankVault.getVaultCells();
        assertNotNull(gettedItems);
        assertEquals(12, gettedItems.size());
    }

    @Test
    public void testItemGetId() {
        Item item = new Item("me", "1");
        assertNotNull(item);
        assertEquals("1", item.getItemId());
    }

    @Test
    public void testItemGetOwner() {
        Item item = new Item("me", "1");
        assertNotNull(item);
        assertEquals("me", item.getOwner());
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemCellNotFound() throws OperationNotSupportedException, IllegalArgumentException {
        Item item = new Item("me", "1");
        assertNotNull(item);
        bankVault.addItem("A111", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testAddItemCellAlreadyTaken() throws OperationNotSupportedException, IllegalArgumentException {
        Item item = new Item("me", "1");
        Item item2 = new Item("me2", "2");
        assertNotNull(item);
        assertNotNull(item2);
        String result = bankVault.addItem("A1", item);
        assertEquals("Item:1 saved successfully!", result);
        bankVault.addItem("A1", item2);
    }

    @Test (expected = OperationNotSupportedException.class)
    public void testAddItemTwoTimesExceptionExpected() throws OperationNotSupportedException, IllegalArgumentException {
        Item item = new Item("me", "1");
        assertNotNull(item);
        String result = bankVault.addItem("A1", item);
        assertEquals("Item:1 saved successfully!", result);
        bankVault.addItem("A2", item);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNonExistingCell() {
        bankVault.removeItem("TWO", null);
    }

    @Test (expected = IllegalArgumentException.class)
    public void testRemoveNonExistingItem() {
        Item item = new Item("me", "1");
        bankVault.removeItem("A1", item);
    }

    @Test
    public void testRemoveItem() throws OperationNotSupportedException, IllegalArgumentException {
        Item item = new Item("me", "1");
        assertNotNull(item);
        String result = bankVault.addItem("A1", item);
        assertEquals("Item:1 saved successfully!", result);
        result = bankVault.removeItem("A1", item);
        assertEquals("Remove item:1 successfully!", result);
        assertNull(bankVault.getVaultCells().get("A1"));
    }
}