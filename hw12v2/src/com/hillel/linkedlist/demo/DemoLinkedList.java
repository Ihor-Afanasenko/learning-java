package com.hillel.linkedlist.demo;

import java.util.Iterator;

import com.hillel.linkedlist.impl.LinkedList;

public class DemoLinkedList {

	public static void main(String[] args) {

		String[] array = { "first", "second", "third", "forth", "fifth" };

		LinkedList<String> list = new LinkedList<>(array);
		list.printLinkedList();

		list.replaceTwoElements(1, 4);
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());

		list.removeFirst();

		list.removeLast();
		list.addLast("first");
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.addFirst("zero");
		list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeFirst();
		System.out.println(list.sizeLinkedList());

		list.removeLast();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		System.out.println(list.sizeLinkedList());
		list.addFirst("first");
		list.printLinkedList();
		list.addLast("second");
		list.printLinkedList();
		// list.replaceTwoElements(1,2);
		// list.printLinkedList();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		System.out.println(list.sizeLinkedList());
		list.removeLast();
		System.out.println(list.sizeLinkedList());
		list.addLast("New");
		System.out.println(list.sizeLinkedList());
		list.printLinkedList();

		Integer[] arrayNumber = new Integer[20];
		for (int i = 0; i < arrayNumber.length; i++) {
			arrayNumber[i] = i;
		}

		LinkedList<Integer> listNumber = new LinkedList<Integer>(arrayNumber);
		listNumber.removeFirst();
		listNumber.printLinkedList();
		listNumber.replaceTwoElements(1, 18);
		listNumber.printLinkedList();
		listNumber.removeElementByIndex(10);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.addByIndex(18, 19);
		listNumber.printLinkedList();
		listNumber.removeLast();
		listNumber.printLinkedList();
		listNumber.replaceTwoElements(17, 1);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.replaceTwoElements(18, 1);
		listNumber.removeLast();
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.addByIndex(18, 20);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.addByIndex(19, 20);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.addByIndex(20, 20);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.addByIndex(21, 21);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.removeElementByIndex(21);
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.printLinkedList();
		System.out.println(listNumber.sizeLinkedList());
		
		System.out.println("Print LinkedList use Iterator");
		Iterator<Integer> itr=listNumber.iterator();
		int index=0;
		while(itr.hasNext()) {
			System.out.print(itr.next()+" ");
			index++;
			if (index==3) {
				itr.remove();
			}
		}
		System.out.println();
		System.out.println(listNumber.sizeLinkedList());
		listNumber.printLinkedList();
		listNumber.removeFirst();
		listNumber.printLinkedList();
		listNumber.addFirst(222);
		listNumber.printLinkedList();


//		Double[] arrayDouble = new Double[0];
//		LinkedList<Double> listDouble = new LinkedList<>(arrayDouble);
		

	}

}
