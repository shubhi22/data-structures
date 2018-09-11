package com.programmergirl;

public class HashTableUsingChaining<T> {
    
    public static final int SIZE = 1000;
    private class Node<T> {
        T data;
        Node<T> next;
        
        Node(T data, Node<T> next) {
            this.data = data;
            this.next = next;
        }
        
         Node(T data) {
            this.data = data;
            this.next = null;
        }
    }
   private Node<T>[] hashTable = new Node[SIZE];
    
    public void insert(T data) {
        int index = data.hashCode() % SIZE;
        Node curr = hashTable[index];
        if(curr == null) {
            hashTable[index] = new Node(data);
            return;
        }
        while(curr.next!=null)
            curr = curr.next;
        curr.next = new Node(data);
    }
    
    public boolean search(T data) {
        int index = data.hashCode() % SIZE;
        Node curr = hashTable[index];
        if(curr == null)
            return false;
        if(curr.data.equals(data))
            return true;
        while(curr.next != null) {
            if(curr.next.data.equals(data))
                return true;
        }
        return false;
        
    }
    
    public void delete(T data) {
        int index = data.hashCode() % SIZE;
        Node curr = hashTable[index];
        if(curr == null)
            return;
        if(curr.data.equals(data)) {
            hashTable[index] = null;
            return;
        }
        while(curr.next != null && !curr.next.data.equals(data))
            curr=curr.next;
        if(curr.next != null)
            curr.next = curr.next.next;
    }
    
    
    
}
