package org.example.services.cacheService.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DLLList {
    private movieNode head;
    private movieNode tail;
    private int size;

    public void add(movieNode Node)
    {
        movieNode next=head.getNext();
        head.setNext(Node);
        Node.setPrev(head);
        Node.setNext(next);
        next.setPrev(Node);
        size++;
    }

    public void remove(movieNode Node)
    {
        movieNode prev=Node.getPrev();
        movieNode next=Node.getNext();
        prev.setNext(next);
        next.setPrev(prev);
        Node.setNext(null);
        Node.setPrev(null);
        size--;
    }
}
