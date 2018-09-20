package com.programmergirl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.junit.Before;

public class HashTableUsingChainingTest 
{

	private HashTableUsingChaining<String, String> hashTable = new HashTableUsingChaining(20);

	@Before
	public void init() {
		hashTable.put("1", "Apple");
		hashTable.put("2", "Banana");
		hashTable.put("3", "Guava");
	}

	@Test
	public void givenHashTable_whenGetInvokedWithKey_thenReturnsElementValue()
	{
		assertEquals(hashTable.get("2"), "Banana");
		assertEquals(hashTable.get("1"), "Apple");
		assertEquals(hashTable.get("3"), "Guava");

	}

	@Test
	public void givenHashTable_whenContainsKeyInvoked_thenChecksElementExistsOrNot()
	{
		assertTrue(hashTable.containsKey("1"));
		assertTrue(hashTable.containsKey("2"));
		assertTrue(hashTable.containsKey("3"));
		assertFalse(hashTable.containsKey("4"));
	}

	@Test
	public void givenHashTable_whenSizeInvoked_thenReturnSize()
	{
		assertEquals(hashTable.size(), 3);
	}

	@Test
	public void givenHashTable_whenRemoveInvoked_thenRemoveElementAndReturnItsValue()
	{
		assertEquals(hashTable.remove("2"), "Banana");
		assertEquals(hashTable.size(), 2);    
	}

	@Test
	public void givenHashTable_whenPutInvokedAndKeyPresent_thenUpdateItsValue()
	{
		hashTable.put("1", "Papaya");
		assertEquals(hashTable.size(), 3); 
		assertEquals(hashTable.get("1"), "Papaya");    
	}
}
