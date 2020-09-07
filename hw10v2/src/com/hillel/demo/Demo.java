package com.hillel.demo;

import com.hillel.impl.LinkedList;

public class Demo {

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
		 list.replaceTwoElements(1,2);
		 list.printLinkedList();
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
		listNumber.replaceTwoElements(1, 19);
		listNumber.printLinkedList();
		listNumber.removeElementByIndex(10);
		listNumber.printLinkedList();

	}

}
