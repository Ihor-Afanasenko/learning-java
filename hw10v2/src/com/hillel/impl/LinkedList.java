package com.hillel.impl;

public class LinkedList<T> {
	private int size = 0;
	private Node first;

	// Initialization list as empty
	public LinkedList() {
	}

	// Initialization List from array
	public LinkedList(T[] args) {
		createListFromArray(args);
	}

	// Add element in the first
	public void addFirst(T element) {
		if (!isEmpty()) {
			Node oldFirst = first;
			first = new Node();
			first.element = element;
			first.next = oldFirst;
		} else {
			Node newNode = new Node();
			newNode.next = null;
		}
		size++;
	}

	// Add element in the last
	public void addLast(T element) {
		Node newNode = new Node();
		newNode.element = element;
		newNode.next = null;
		if (isEmpty()) {
			first = newNode;
		} else {
			(linkElementByIndex(size)).next = newNode;
		}
		size++;
	}

	// Add element by the index
	public void addByIndex(int index, T element) {
		if (checkIndex(index)) {
			System.out.println("Invalid index");
		} else {
			if (index == 1) {
				addFirst(element);
			} else {
				Node newNode = new Node();
				newNode.element = element;
				Node currentLink = linkElementByIndex(index);
				linkBeforeElement(currentLink).next = newNode;
				linkElementByIndex(index).next = null;
				newNode.next = currentLink;
				size++;
			}
		}
	}

	// Remove first element in the List
	public void removeFirst() {
		if (isEmpty()) {
			System.out.println("Not element in the LinkedList");
		} else {
			first = first.next;
			size--;
		}
	}

	// Remove last element in the List
	public void removeLast() {
		if (isEmpty()) {
			System.out.println("Not element in the LinkedList");
			return;
		} else if (size > 1) {
			(linkBeforeElement(linkElementByIndex(size))).next = null;
		} else {
			linkElementByIndex(size).next = null;
		}
		size--;
	}

	// Remove element by the index
	public void removeElementByIndex(int index) {
		if (checkIndex(index)) {
			System.out.println("Invalid index");
		} else {
			if (index == 1) {
				removeFirst();
			} else {
				(linkBeforeElement(linkElementByIndex(index))).next = linkElementByIndex(index).next;
				size--;
			}
		}
	}

	// Replacing two elements of LinkedList
	public void replaceTwoElements(int firstIndex, int secondIndex) {

		if (checkIndex(firstIndex) | checkIndex(secondIndex)) {
			System.out.println("Wrong index");
		} else {

			T currentElementFirst = linkElementByIndex(firstIndex).element;
			T currentElementSecond = linkElementByIndex(secondIndex).element;

			removeElementByIndex(firstIndex);
			addByIndex(firstIndex, currentElementSecond);

			removeElementByIndex(secondIndex);
			addByIndex(secondIndex, currentElementFirst);
		}
	}

	// Print element LinkedList
	public void printLinkedList() {
		if (!isEmpty()) {
			StringBuilder list = new StringBuilder();
			for (Node current = first; current != null; current = current.next) {
				list.append((current.element).toString() + " ");
			}
			System.out.println("LinkedList has next element: " + list);
		} else {
			isEmptyList();
		}
	}

	// Size List
	public String sizeLinkedList() {
		return "Size LinkedList is: " + size;
	}

	public boolean isEmpty() {
		return (size == 0) ? true : false;
	}

	// Check List for emptiness
	public String isEmptyList() {
		return (size == 0) ? "List is empty." : "List isn't empty.";
	}

	public void createListFromArray(T[] args) {
		if (args.length == 0) {
			System.out.println("Input array is empty.");
			return;
		}
		for (T arg : args) {
			addLast(arg);
		}
	}

	private class Node {
		T element;
		Node next;
	}

	private Node linkElementByIndex(int index) {
		int counterIndex = 0;
		Node linkElement = null;
		for (Node current = first; current != null; current = current.next) {
			counterIndex++;
			if (counterIndex == index) {
				linkElement = current;
			}
		}
		return linkElement;
	}

	private Node linkBeforeElement(Node linkElement) {
		Node linkBeforeElement = null;
		for (Node current = first; current != linkElement; current = current.next) {
			linkBeforeElement = current;
		}
		return linkBeforeElement;
	}

	private boolean checkIndex(int index) {
		return (index > size & index < 0) ? true : false;
	}	
}