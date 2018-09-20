package com.programmergirl;

import java.util.*;

public class HashTableUsingChaining<K,V> {

    private HashEntry[] hashTable;
    private int size;
    
    private class HashEntry<K, V> {
        K key;
        V value;
        HashEntry<K, V> next;
        
        HashEntry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

    public HashTableUsingChaining(int capacity) {
        this.hashTable = new HashEntry[capacity];
    }

    private int getElementIndex(K key) {
        return key.hashCode() % hashTable.length;
    }

    public void put(K key, V value) {
        if(key == null)
            throw new IllegalArgumentException("Key can't be null");
        int index = getElementIndex(key);
        HashEntry<K,V> newEntry = new HashEntry(key, value);
        if(hashTable[index] == null) {
            hashTable[index] = newEntry;
        } else {
            System.out.println("Element Exists at index :"+index);
            hashTable[index].next = newEntry;
        }
        size++;
    }

    public V get(K key) {
        if(key == null)
            throw new IllegalArgumentException("Key can't be null");
        int index = getElementIndex(key);
        HashEntry<K,V> current = hashTable[index];
        while(current != null && key != current.key) {
            current = current.next;
        }
        System.out.println(current.value);
        return current.value;
    }

    public boolean containsKey(K key) {
        int index = getElementIndex(key);
        HashEntry<K,V> current = hashTable[index];
        while(current != null) {
            if(current.key == key)
                return true;
        }
        return false;
    }

    public V remove(K key) {
        int index = getElementIndex(key);
        HashEntry<K,V> current = hashTable[index];
        HashEntry<K, V> hashEntryRemoved;
        if(current == null)
            throw new IllegalArgumentException("No such key exists!");
        if(current.key == key) {
            hashTable[index] = null;
            hashEntryRemoved = current;
        }
        else {
            while(current.next != null && current.next.key != key) {
                current = current.next;
            }    
            if(current.next == null)
                throw new IllegalArgumentException("No such key exists!");
            hashEntryRemoved = current.next;
            current.next = current.next.next;
        }
        size--;
        return hashEntryRemoved.value;
    }
    
    public int size() {
        return size;
    }

    @Override
    public String toString() {
        String result = "[";
        for(HashEntry<K, V> entry : hashTable) {
            while(entry != null) {
                result += "{"+ entry.key + ", " + entry.value + "}";
                entry = entry.next;
            }
        }
        result += "]";
        return result;
    }
}
