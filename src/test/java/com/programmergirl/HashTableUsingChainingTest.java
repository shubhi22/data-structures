package com.programmergirl;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import org.junit.Test;

public class HashTableUsingChainingTest 
{
   
    @Test
    public void testHashTable()
    {
       HashTableUsingChaining<String> hashTable = new HashTableUsingChaining();
       hashTable.insert("Apple");
       hashTable.insert("Banana");
       hashTable.insert("Guava");

       assertFalse(hashTable.search("Grapes"));
       assertTrue(hashTable.search("Banana"));
       assertTrue(hashTable.search("Apple"));
       assertTrue(hashTable.search("Guava"));
       assertFalse(hashTable.search("guava"));

       hashTable.delete("Guava");

       assertFalse(hashTable.search("Guava")); 
    }
}
